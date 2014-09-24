/**
 * @file		Md5Util.java
 * @brief   Md5관련 유틸리티  
 * @author  개발1팀 / 파트1
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	/**
	 * MD5로 인코딩한다.
	 * @param bytData
	 * @return
	 */
    public static String encodingMD5(byte[] bytData)  throws Exception {  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
          
        md.update(bytData);  
          
        byte[] passData = md.digest();  
          
        String passStr = "";  
        
        for (int i=0; i<passData.length; i++){  
            passStr += Integer.toHexString(passData[i] & 0xFF).toUpperCase();  
        }  
          
        return new String(passStr);  
    }

    /**
	 * MD5로 인코딩한다.
     * @param orgStr
     * @return
     */
    public static String encodingMD5(String orgStr) throws Exception {  
        byte[] bytData = orgStr.getBytes();  
        return encodingMD5(bytData);
    }
}
