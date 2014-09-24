/**
 * @file			PermissionInterceptor.java
 * @brief   	로그인 인증 확인용 인터셉터  
 * @author  개발1팀 / 파트5
 * @author  김연근 ( solaris@juseyo.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Method;

import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.google.gson.Gson;
import com.juseyo.commons.lib.annotation.ConfirmPermission;
import com.juseyo.commons.lib.messages.common.MessageSetter;
import com.juseyo.commons.lib.permission.ConfirmPermissionValue;
import com.juseyo.commons.lib.utility.LogUtil;

/**
* @brief 	PermissionInterceptor
* @author 	개발1팀 / 파트5
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
@Aspect
public class PermissionInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "MessageCommonSetter")
	private MessageSetter messageSetter;

	@Resource(name="ConfirmPermissionValue")
	private ConfirmPermissionValue confirmsession;
	
	/**
	 * 모든 controller에 대한 비즈니스 로직이전의 인증을 위한 사전 pointcut 선언 ( MVC 모델용 )  
	 */
	@Pointcut("execution(* com.juseyo..*MvcPermissionController.*(..))  &&  @annotation(com.juseyo.commons.lib.annotation.ConfirmPermission)")
	public void beforeMvcPermission() {}
	
	/**
	 * 모든 controller에 대한 비즈니스 로직이전의 인증을 위한 사전 pointcut 선언 ( REST 모델용 )  
	 */
	@Pointcut("execution(* com.juseyo..*RestPermissionController.*(..))  &&  @annotation(com.juseyo.commons.lib.annotation.ConfirmPermission)")
	public void beforeRestPermission() {}
	
	
	 /**
	 * @brief		모든 controller의 사전검사를 위한 Before 로직 ( MVC용 ) 
	 * @details	
	 * @param 	joinPoint
	 * @return	
	 */
	@Before("beforeMvcPermission()")
	public void beforeMvcPermission(JoinPoint joinPoint ) throws Exception {
	
		HttpSession _session = null;
		// 미인증 상태인 경우 기본은 error.jsp 임 
		String request_viewer ="error";
		Logger _logger = logger;
		BindingAwareModelMap _model = null;
		HttpServletRequest _request = null;

		// 지정된 annotation 에서 파라미터 확인 
		Method[] methods = joinPoint.getTarget().getClass().getMethods();
		
		 for (Method m : methods) {
	            if (m.isAnnotationPresent(ConfirmPermission.class)) {
	            	ConfirmPermission cp = m.getAnnotation(ConfirmPermission.class);
	            	// 값이 있다면.. 일단 해당값으로 변경하여 설정함 
	            	if( cp.name() != null && !cp.name().equals("") ){
	            		request_viewer = cp.name();
	            	}
	            }
	        }		
		
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			
			if(arg instanceof HttpSession) {
				_session = (HttpSession) arg;
				if( !confirmsession.mvcCheckSession(_session)){
					
					Map<String, ?> map = messageSetter.setCommonMessage( "P000", joinPoint.getSignature().getName());
					throw new ModelAndViewDefiningException( new ModelAndView(request_viewer, map) );
				}
				break;
			} 
		}
		
	}
	
	 /**
	 * @brief		모든 controller의 사전검사를 위한 Before 로직 ( REST용 ) 
	 * @details	
	 * @param 	joinPoint
	 * @return	
	 */
	@Before("beforeRestPermission()")
	public void beforeRestPermission(JoinPoint joinPoint) throws Exception {
	
		HttpSession _session = null;
		String request_viewer ="jsonViewer";
		Logger _logger = logger;
		BindingAwareModelMap _model = null;
		HttpServletRequest _request = null;
		
		Object[] args = joinPoint.getArgs();
		
		// 리턴을 위하여 모델 먼저 확보 
		for (Object arg : args) {
			if(arg instanceof HttpServletRequest) {
				_request = (HttpServletRequest) arg;
				// 파라미터로 format 이 있는 경우 Resolver 결정 
				String _format = (String) _request.getParameter("format");
	
				if( null != _format ){
					if( _format.toUpperCase().equals("JSON") ){
						request_viewer = "jsonViewer";
					} else if( _format.toUpperCase().equals("XML") ){
						request_viewer = "xmlViewer";
					} else if( _format.toUpperCase().equals("JSONP") ){
						request_viewer = "jsonpViewer";
					} else {
						request_viewer = "jsonViewer";
					}
				}
			}
		}
		
		for (Object arg : args) {
				
			if(arg instanceof HttpSession) {
				_session = (HttpSession) arg;
				if( !confirmsession.restCheckSession(_session)){
					
					Map<String, ?> map = messageSetter.setCommonMessage( "P000", joinPoint.getSignature().getName());
					throw new ModelAndViewDefiningException( new ModelAndView(request_viewer, map) );
				}
				break;
			} 
		}
	
	}	
	
	
	
	/**
	 * return parsing : 리턴데이터를 로그에 남기기 위함
	 * @param map
	 * @return
	 */
	private String getReturn(Map<?, ?> map)  throws Exception {
		
		StringBuffer sb = new StringBuffer();
		Entry<?, ?> entry;
		Set<?> set;
		Iterator<?> it;
		Object value = null;
		String val = null;
		int len = 1000;
		
		try {
			set = map.entrySet();
			it = set.iterator();
			
			while(it.hasNext()) {
				entry = (Entry<?, ?>) it.next();
				value = entry.getValue();

				if(value instanceof String) {
					if(((String) value).length() > len) {
						value = ((String) value).substring(0, len);
					}
					sb.append("   " + entry.getKey() + ": " + value + "\n");
				} else {
				    val = JSONValue.toJSONString(value);
					
					if(val.length() > len) {
						val = val.substring(0, len);
					}
					sb.append("   class: "
							+ value.getClass()
							+ "\n"
							+ "   "
							+ val);
				}
			}
			
			
			
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
		} finally {
			entry = null;
			set = null;
		}
		return sb.toString();
	}

	public static String getBody(HttpServletRequest request) throws IOException {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}