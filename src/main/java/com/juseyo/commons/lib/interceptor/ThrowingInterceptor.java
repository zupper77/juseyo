/**
 * @file			ThrowingChalieInterceptor.java
 * @brief   	3팀용 인터셉터 ( 에러처리 전용 ) 
 * @author  개발1팀 / 파트5
 * @author  김연근 ( solaris@juseyo.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-04-21
 */
package com.juseyo.commons.lib.interceptor;

import com.juseyo.certification.exception.AccessDeniedException;
import com.juseyo.certification.exception.SessionNotFoundException;
import com.juseyo.commons.lib.interceptor.exception.NullDataException;
import com.juseyo.commons.lib.interceptor.exception.ParameterException;
import com.juseyo.commons.lib.messages.common.MessageSetter;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @brief ThrowingChalieInterceptor
 * @author 개발1팀 / 파트5
 * @version 1.0
 * @date 생성: 2014-03-14
 * @date 최종수정: 2014-04-21
 * @remark SessionNotFoundException, AccessDeniedException 처리 추가
 */
@Aspect
public class ThrowingInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "MessageCommonSetter")
    private MessageSetter messageSetter;

    /**
     * @brief 모든 Exception에 대한 처리 및 에러출력을 위한 pointcut 선언
     * @details
     * @param
     * @return
     */
    @Pointcut("execution(* com.juseyo.certification..*Controller.*(..)) || execution(* com.juseyo.administrator..*Controller.*(..)) || execution(* com.juseyo.certification.interceptor..*(..))")
    public void pointcut4throwingLog() {
    }

    /**
     * @brief 모든 호출에 대한 exception 처리 ( 3 팀용 )
     * @details
     * @param joinPoint
     * @throws Exception
     * @return
     */
    @AfterThrowing(pointcut = "pointcut4throwingLog()", throwing = "error")
    public void _throwing(JoinPoint joinPoint, Throwable error) throws Exception {

        BindingAwareModelMap _model = null;
        //HttpServletRequest _request = null;
        HttpServletRequest _request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        /* 기본 에러처리 페이지 ( JSP인 경우 초기값 ) */
        String request_viewer = "error";

        Object[] args = joinPoint.getArgs();

        try {

            for (Object arg : args) {

                if (arg instanceof BindingAwareModelMap) {
                    _model = (BindingAwareModelMap) arg;
                } else if (arg instanceof HttpServletRequest) {
                    _request = (HttpServletRequest) arg;
                    // 파라미터로 format 이 있는 경우 Resolver 결정 
                    String _format = (String) _request.getParameter("format");

                    if (null != _format) {
                        if (_format.toUpperCase().equals("JSON")) {
                            request_viewer = "jsonViewer";
                        } else if (_format.toUpperCase().equals("XML")) {
                            request_viewer = "xmlViewer";
                        } else if (_format.toUpperCase().equals("JSONP")) {
                            request_viewer = "jsonpViewer";
                        } else {
                            request_viewer = "jsonViewer";
                        }
                    }

                }

            }
        } catch (Exception e) {
            logger.error("Throwing viewer set error. trace : {}", ExceptionUtils.getStackTrace(error));
        } finally {
            args = null;
        }

        Map<String, ?> map = null;

        if (error instanceof NullDataException) {
            String errorCode = "3001";
            map = messageSetter.setCommonMessage(errorCode, this.getClass().getName());
            logger.error("ErrorCode:{}, Trace:{}", errorCode, ExceptionUtils.getStackTrace(error));

        } else if (error instanceof ParameterException) {
            String errorCode = "3002";
            map = messageSetter.setCommonMessage(errorCode, this.getClass().getName());
            logger.error("ErrorCode:{}, Trace:{}", errorCode, ExceptionUtils.getStackTrace(error));

        } else if (error instanceof IllegalStateException) {
            String errorCode = "3003";
            logger.error("ErrorCode:{}, Trace:{}", errorCode, ExceptionUtils.getStackTrace(error));
            logger.error(ExceptionUtils.getStackTrace(error));

        } else if (error instanceof DataAccessException) {
            // DB 에러
            String errorCode = "3004";
            logger.error("ErrorCode:{}, Trace:{}", errorCode, ExceptionUtils.getStackTrace(error));
            logger.error(ExceptionUtils.getStackTrace(error));

        } else if (error instanceof SessionNotFoundException) {
            // 로그인 에러 
            String errorCode = "3005";
            RedirectView rv = new RedirectView("/login");
            rv.setExposeModelAttributes(false);
            map = messageSetter.setCommonMessage(errorCode, this.getClass().getName());
            // warn 처리
            logger.warn("ErrorCode:{}, Trace:{}", errorCode, error.toString());
            throw new ModelAndViewDefiningException(new ModelAndView(rv, map));

        } else if (error instanceof AccessDeniedException) {
            // 권한에러
            String errorCode = "3006";
            map = messageSetter.setCommonMessage(errorCode, this.getClass().getName());
            // warn 처리
            request_viewer = "permission";
            logger.warn("ErrorCode:{}, Trace:{}", errorCode, error.toString());

        } else {
            String errorCode = "3000";
            map = messageSetter.setCommonMessage(errorCode, this.getClass().getName());
            logger.error(ExceptionUtils.getStackTrace(error));
            
        }

        throw new ModelAndViewDefiningException(new ModelAndView(request_viewer, map));
    }

}
