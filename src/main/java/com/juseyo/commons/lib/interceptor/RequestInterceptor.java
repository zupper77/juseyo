/**
 * @file			RequestInterceptor.java
 * @brief    	기본요청 처리용 인터셉터  
 * @author  	개발1팀 / 파트5
 * @author  	김연근 ( solaris@wemakeprice.com )
 * @date    	생성: 2014-03-14
 * @date    	최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.interceptor;

import com.juseyo.commons.lib.messages.common.MessageSetter;
import com.juseyo.commons.lib.utility.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springbyexample.web.servlet.view.tiles2.TilesUrlBasedViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
* @brief 	RequestInterceptor
* @author 	개발1팀 / 파트5
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
@Aspect
public class RequestInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "MessageCommonSetter")
	private MessageSetter messageSetter;

	@Autowired
	private TilesUrlBasedViewResolver tilesUrlBasedViewResolver;		
	

	/**
	 * 모든 controller호출에 대한 return log 위한 pointcut 선언 
	 */
	@Pointcut("execution(* com.juseyo..*Controller*.*(..))")
	public void call4ControllerLog() {}

	
	/**
	 * 모든 controller에서 확장자를 통한 Tiles2 환경설정 
	 */
	@Pointcut("execution(* com.juseyo..*Controller*.*(..))")
	public void afterConfiguresController() {}
	
	
	 /**
	 * @brief		모든 controller의 호출에 대한 return log 
	 * @details	
	 * @param 	joinPoint
	 * @return		
	 */
	@AfterReturning("call4ControllerLog()")
	public void _afterLog(JoinPoint joinPoint)  throws Exception  {
		Locale _locale = null;
		BindingAwareModelMap _model = null;
		HttpServletRequest _request = null;
		HttpServletResponse _response = null;
		HttpSession _session = null;
		Logger _logger = logger;
		
		Object[] args = joinPoint.getArgs();
	
		for (Object arg : args) {
			
			if(arg instanceof BindingAwareModelMap) {
				_model = (BindingAwareModelMap) arg;
				// 정상적인 처리 로그.. 
				if( logger.isDebugEnabled() ){
				    LogUtil.debugReturn(_logger, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), this.getReturn( (BindingAwareModelMap)arg  ));
				} else {
				    LogUtil.debugShortReturn(_logger, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), this.getReturn( (BindingAwareModelMap)arg  ));
				}
			} else if(arg instanceof HttpServletRequest) {
				_request = (HttpServletRequest) arg;
				_locale = _request.getLocale();
			} else if(arg instanceof HttpServletResponse) {
				_response = (HttpServletResponse) arg;
			} else if(arg instanceof HttpSession) {
				_session = (HttpSession) arg;
			} 
		}
		
	
	}	
	
	 /**
	 * @brief		Tiles2 Controller의 리턴형태 결정을 위한  
	 * @details	
	 * @param 	joinPoint
	 * @return		
	 */

	@After("afterConfiguresController()")
	public void _beforeTilesConfigures(JoinPoint joinPoint) throws Exception {
		String uri = null;

		tilesUrlBasedViewResolver.clearCache();
		tilesUrlBasedViewResolver.setTilesDefinitionName("default");
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		uri = request.getRequestURI();

		if(uri.endsWith(".do")){
			tilesUrlBasedViewResolver.clearCache();
			tilesUrlBasedViewResolver.setTilesDefinitionName("default");
		} else if(uri.endsWith(".dash")){
			tilesUrlBasedViewResolver.clearCache();
			tilesUrlBasedViewResolver.setTilesDefinitionName("dashboard");
		} else if(uri.endsWith(".pop")){
			tilesUrlBasedViewResolver.clearCache();
			tilesUrlBasedViewResolver.setTilesDefinitionName("popup");
        }
	}
	
	 /**
	 * @brief		return parsing : 리턴데이터를 로그에 남기기 위함  
	 * @details	
	 * @param 	map
	 * @return		Map 파싱결과를 스트링으로 저장 		
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
//							+ "\n"
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