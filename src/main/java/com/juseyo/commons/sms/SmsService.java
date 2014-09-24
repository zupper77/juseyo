/**
* @file SmsService.java
* @brief 문자 발송
* @author 개발지원2팀 / 간지파트
* @author 이학선
* @date 생성: 2014-04-25
* @date 최종수정: 2014-04-25
*/
package com.juseyo.commons.sms;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.juseyo.commons.lib.mybatis.UserSqlSessionFactory;

/**
 * @brief Sms 발송을 위한 Service Class
 * @author 개발지원2팀 / 간지파트 / 이학선
 * @version (1.0)
 * @date 생성 : 2014-04-25
 * @date 최종수정 : 2014-04-25
 * @remark
 * 
 */
@Repository("SmsService")
public class SmsService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsService.class); //this.getClass()
    
    private static final String RTN_UNKNOWN_CD = "UNKNOWN";
    private static final String RTN_SUCCESS_CD = "0000";
    private static final String RTN_FAIL_CD = "9100";
    private static final String RTN_EXCEPTION_CD = "9999";
    
    private static final String REGX_CALL_TO = "^01\\d{1}-?(\\d{3}|\\d{4})-?\\d{4}$";//"^01(?:01[6-9])-(?:\\d{3}\\d{4})-?\\d{4}$";    //"^01(?:01[6-9])-?(\\d{3}|\\d{4})-?\\d{4}$
    private static final String REGX_CALL_FROM = "^[0-9|-]*$";
    
    @Resource(name="userSqlSessionFactory")
    private UserSqlSessionFactory userSqlSessionFactory;
    
    /**
     * @brief 문자 발송
     * @details Sms 발송
     * @param callTo 수신자 전화번호
     * @param callFrom 발신자 전화번호
     * @param smsTxt 발신 메시지
     * @return String 0000이면 성공 나머지는 실패
     * @throws Exception 
     */
     public String send(String callTo, String callFrom, String smsTxt) throws Exception {
         HashMap<String, String> params = new HashMap<String, String>();
         params.put("callTo", callTo);
         params.put("callFrom", callFrom);
         params.put("smsTxt", smsTxt);
         
         String result = send(params);
         return result;
     }
     
     /**
      * @brief 문자 발송 Async 메소드
      * @details Sms 발송
      * @param callTo 수신자 전화번호
      * @param callFrom 발신자 전화번호
      * @param smsTxt 발신 메시지
      */
      public void sendAsync(final String callTo, final String callFrom, final String smsTxt) throws Exception{
    	  Runnable task = new Runnable() {
              @Override
              public void run() {
                  try {
                	  HashMap<String, String> params = new HashMap<String, String>();
                      params.put("callTo", callTo);
                      params.put("callFrom", callFrom);
                      params.put("smsTxt", smsTxt);
                      
                      sendAsync(params);
                  } catch (Exception ex) {
                	  LOGGER.error(ex.getMessage());
                  }
              }
          };
          new Thread(task, "ServiceSMSThread").start();
          
          
          
      }
      
    /**
    * @brief 문자 발송
    * @details sms 발송
    * @param params sms 발송 정보
    * @return String 0000이면 성공 나머지는 실패
     * @throws Exception 
    */
    private String send(HashMap<String, String> params) throws Exception {
    	
    	String result;
    	result = sendService(params,false);
        
        return result;
    }
        
    /**
     * @brief 문자 발송 비동기처리 메소드
     * @details sms 발송
     * @param params sms 발송 정보
     */
     private void sendAsync(HashMap<String, String> params) throws Exception{
         
         sendService(params,true);
     }
     
     
     /**
      * @brief 문자 발송 공통 처리 메소드
      * @details sms 발송
      * @param params sms 발송 정보
      */
     @Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor={Exception.class})
     private String sendService(HashMap<String, String> params, Boolean AsyncYn) throws Exception{
    	 
    	 String result = RTN_UNKNOWN_CD;
         int rtn_sms = 0;
         
    	 try {
    		 if (params == null) {
                 result = "1000";
                 LOGGER.info("SmsService.send()["+result+"] params is null");
                 return result;
             }
             
             if (params.get("callTo") == null) {
                 result = "1001";
                 LOGGER.info("SmsService.send()["+result+"] callTo is null");
                 return result;
             }
             if (!params.get("callTo").matches(REGX_CALL_TO)) {
                 result = "1002";
                 LOGGER.info("SmsService.send()["+result+"] callTo["+params.get("callTo")+"] is not valid");
                 return result;
             }
             
             if (params.get("callFrom") == null) {
                 result = "1003";
                 LOGGER.info("SmsService.send()["+result+"] callFrom is null");
                 return result;
             }
             if (!params.get("callFrom").matches(REGX_CALL_FROM)) {
                 result = "1004";
                 LOGGER.info("SmsService.send()["+result+"] callFrom["+params.get("callFrom")+"] is not valid");
                 return result;
             }
             
             if (params.get("smsTxt") == null) {
                 result = "1005";
                 LOGGER.info("SmsService.send()["+result+"] smsTxt is null");
                 return result;
             }
             
             if (params.get("smsTxt").length() < 1) {
                 result = "1006";
                 LOGGER.info("SmsService.send()["+result+"] smsTxt length under 1");
                 return result;
             }
             
             if (params.get("msgType") == null) {
                 params.put("msgType", "4");
             }
             
             if ("4".equals(params.get("msgType"))) {
                 if (params.get("smsTxt").getBytes("EUC-KR").length > 80 ) {
                     result = "1010";
                     LOGGER.info("SmsService.send()["+result+"] smsTxt["+params.get("smsTxt")+"] bytes over 80");
                     return result;
                 }
             }
             
             params.put("callTo", params.get("callTo").replaceAll("-", ""));
             params.put("callFrom", params.get("callFrom").replaceAll("-", ""));
             
             //rtn_sms = userSqlSessionFactory.cd().insert("sql.com.wemakeprice.commons.sms.insertMsgData", params);
             
             if (rtn_sms == 1) {
                 result = RTN_SUCCESS_CD;
             } else {
                 result = RTN_FAIL_CD;
                 LOGGER.info("SmsService.send()["+result+"] smsTxt["+params.get("smsTxt")+"] bytes over 80");
             }
         	
             
         } catch (Exception ex) {
        	 //비동기 처리의 경우 transaction 처리 안함
        	 if(!AsyncYn)  TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	 
             result = RTN_EXCEPTION_CD;
             LOGGER.error("SmsService.send()["+result+"] params["+params.toString()+"]", ex);
         }
    	 //async test ...
//    	 Thread.sleep(10000);
//    	 LOGGER.debug("SMS send success !!");
    	 
    	 return result;
     }
}
