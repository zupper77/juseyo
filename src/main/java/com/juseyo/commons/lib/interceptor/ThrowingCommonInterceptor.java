/**
 * @file			ThrowingCommonInterceptor.java
 * @brief   	3팀용 인터셉터 ( 에러처리 전용 ) 
 * @author  개발1팀 / 파트5
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.interceptor;

import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.juseyo.commons.lib.interceptor.exception.NullDataException;
import com.juseyo.commons.lib.interceptor.exception.ParameterException;
import com.juseyo.commons.lib.interceptor.exception.PermissionException;
import com.juseyo.commons.lib.messages.common.MessageSetter;
import com.juseyo.commons.lib.utility.LogUtil;
/**
* @brief 	ThrowingCommonInterceptor
* @author 	개발1팀 / 파트5
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
@Aspect
public class ThrowingCommonInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "MessageCommonSetter")
	private MessageSetter messageSetter;
	
	/**
	 * 모든 Exception에 대한 처리 및 에러출력을 위한 pointcut 선언  ( com.wemakeprice.hello, com.wemakeprice.sample )
	 */
	@Pointcut("execution(* com.wemakeprice.sample..*Controller*.*(..)) || execution(* com.wemakeprice.hello..*Controller*.*(..))")
	public void pointcut4throwingLog() {}
	
	 /**
	 * @brief		모든 호출에 대한 exception 처리 ( 공통용 )
	 * @details	
	 * @param 	joinPoint
	 * @throws 	Exception
	 * @return		
	 */
	@AfterThrowing(pointcut = "pointcut4throwingLog()", throwing = "error")
	public void _throwing(JoinPoint joinPoint, Throwable error) throws Exception {
		
		BindingAwareModelMap _model = null;
		HttpServletRequest _request = null;
		Logger _logger_error = logger;
		
		/* 기본 에러처리 페이지 ( JSP인 경우 초기값 ) */ 
		String request_viewer ="error";
		
		Object[] args = joinPoint.getArgs();
		
		try {
			
			for (Object arg : args) {
				
				if(arg instanceof BindingAwareModelMap) {
					_model = (BindingAwareModelMap) arg;
				} else if(arg instanceof HttpServletRequest) {
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
		} catch (Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
		} finally {
			args = null;
		}

		Map<String, ?> map = null;
		
		if(error instanceof NullDataException) {
			// 1000
			map = messageSetter.setCommonMessage( "1001", this.getClass().getName());
			LogUtil.infoThrow(_logger_error, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), error);
		} else if(error instanceof ParameterException) {
			// 1001
			map = messageSetter.setCommonMessage( "1002", this.getClass().getName());
			LogUtil.infoThrow(_logger_error, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), error);
		} else if(error instanceof IllegalStateException ){
			// 입력 파라미터가  JSON 데이터가 아님 
			map = messageSetter.setCommonMessage( "1003", this.getClass().getName());
			LogUtil.infoThrow(_logger_error, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), error);
		} else if(error instanceof DataAccessException ){
			// Mybatis DB 관련 오류 발생 
			map = messageSetter.setCommonMessage( "1004", this.getClass().getName());
			LogUtil.infoThrow(_logger_error, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), error);		
		} else if( error instanceof PermissionException ){
			// 로그인 에러 
				map = messageSetter.setCommonMessage( "1005", this.getClass().getName());
				LogUtil.infoThrow(_logger_error, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), error);
		} else {
			map = messageSetter.setCommonMessage( "9000", this.getClass().getName());
			LogUtil.infoThrow(_logger_error, joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), error);
		} 
		
			throw new ModelAndViewDefiningException( new ModelAndView(request_viewer, map) );

	}	
	
	
	
	
}
