/**
 * @file		LogUtil.java
 * @brief   Log 관련 유틸리티  
 * @author  개발1팀 / 파트1
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */package com.juseyo.commons.lib.utility;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;

public class LogUtil {
 
	/**
	 * 호출 시 입력 정보 로깅
	 * @param logger
	 * @param className
	 * @param method
	 * @param text
	 */
	public static void infoCall(Logger logger, String className, String method, String text)  throws Exception  {
		try {
			logger.info("-------Call Start--------" + DateUtil.formatTodayWithMil());
			logger.info(" - [" + className + ": " + method + "]");
			logger.info(" - parameters -");
			logger.info(text + "");
			logger.info("-------Call End--------\n");
		} catch (Exception e) {
		}
	}

    /**
     * 호출 시 입력 정보 로깅
     * @param logger
     * @param className
     * @param method
     * @param text
     */
    public static void infoShortCall(Logger logger, String className, String method, String text)  throws Exception  {
        try {
            logger.info("## Calling Start [ "+DateUtil.formatTodayWithMil()+" ] >> ["+className+" : "+method+"] >> values ["+text+"] >> End##" );
        } catch (Exception e) {
        }
    }	
	
	/**
	 * 반환 시 출력 정보 로깅
	 * @param logger
	 * @param className
	 * @param method
	 * @param text
	 */
	public static void infoReturn(Logger logger, String className, String method, String text)  throws Exception {
		try {
			logger.info("-------Return Start--------" + DateUtil.formatTodayWithMil());
			logger.info(" - [" + className + ": " + method + "]");
			logger.info(" - values -");
			logger.info(text + "");
			logger.info("-------Return End--------\n");
		} catch (Exception e) {
		}
	}
	
	   /**
     * 반환 시 출력 정보 로깅
     * @param logger
     * @param className
     * @param method
     * @param text
     */
    public static void infoShortReturn(Logger logger, String className, String method, String text)  throws Exception {
        try {
            logger.info("## Return Start [ "+DateUtil.formatTodayWithMil()+" ] >> ["+className+" : "+method+"] >> values ["+text+"] >> End##" );
        } catch (Exception e) {
        }
    }

	/**
	 * 예외 발생 시 로깅 
	 * @param logger
	 * @param className
	 * @param method
	 * @param error
	 */
	public static void infoThrow(Logger logger, String className, String method, Throwable error)  throws Exception {
		try {
			logger.info("-------Throw Start--------" + DateUtil.formatTodayWithMil());
			logger.info(" - [" + className + ": " + method + "]");
			logger.info(" - values -");
			logger.info("   Error: " + error + "");
			logger.info(getStackTraces(error));
			logger.info("-------Throw End--------\n");
		} catch (Exception e) {
		}
	}

	/**
	 * 개별 로깅 시 사용
	 * @param logger
	 * @param text
	 */
	public static void infoText(Logger logger, String text)  throws Exception {
		
		try {
			
/*   로그파일 Dao 제거			
 			logger.info("-------Text Start--------" + DateUtil.formatTodayWithMil());
			logger.info(text + "");
			logger.info("-------Text End--------\n");
*/
		} catch (Exception e) {
		}
	}


	/**
	 * 호출 시 입력 정보 로깅 ( 디버그 )
	 * @param logger
	 * @param className
	 * @param method
	 * @param text
	 */
	public static void debugCall(Logger logger, String className, String method, String text)  throws Exception  {
		try {
			logger.debug("-------Call Start--------" + DateUtil.formatTodayWithMil());
			logger.debug(" - [" + className + ": " + method + "]");
			logger.debug(" - parameters -");
			logger.debug(text + "");
			logger.debug("-------Call End--------\n");
		} catch (Exception e) {
		}
	}	
	
    /**
     * 호출 시 입력 정보 로깅 ( 디버그 )
     * @param logger
     * @param className
     * @param method
     * @param text
     */
    public static void debugShortCall(Logger logger, String className, String method, String text)  throws Exception  {
        try {
            logger.debug("## Calling Start [ "+DateUtil.formatTodayWithMil()+" ] >> ["+className+" : "+method+"] >> values ["+text+"] >> End##" );
        } catch (Exception e) {
        }
    }	
	
	/**
	 * 반환 시 출력 정보 로깅 ( 디버그용 ) 
	 * @param logger
	 * @param className
	 * @param method
	 * @param text
	 */
	public static void debugReturn(Logger logger, String className, String method, String text)  throws Exception {
		try {
			logger.debug("-------Return Start--------" + DateUtil.formatTodayWithMil());
			logger.debug(" - [" + className + ": " + method + "]");
			logger.debug(" - values -");
			logger.debug(text + "");
			logger.debug("-------Return End--------\n");
		} catch (Exception e) {
		}
	}	

    /**
     * 반환 시 출력 정보 로깅 ( 디버그용 ) 
     * @param logger
     * @param className
     * @param method
     * @param text
     */
    public static void debugShortReturn(Logger logger, String className, String method, String text)  throws Exception {
        try {
            logger.debug("## Return Start [ "+DateUtil.formatTodayWithMil()+" ] >> ["+className+" : "+method+"] >> values ["+text+"] >> End##" );
        } catch (Exception e) {
        }
    }   	
	
	/**
	 * 예외 발생 시 로깅 ( debug )
	 * @param logger
	 * @param className
	 * @param method
	 * @param error
	 */
	public static void debugThrow(Logger logger, String className, String method, Throwable error)  throws Exception  {
		try {
			logger.debug("-------Throw Start--------" + DateUtil.formatTodayWithMil());
			logger.debug(" - [" + className + ": " + method + "]");
			logger.debug(" - values -");
			logger.debug("   Error: " + error + "");
			logger.debug(getStackTraces(error));
			logger.debug("-------Throw End--------\n");
		} catch (Exception e) {
		}
	}	
	
	
	/**
	 * 개별 로깅 시 사용: debug
	 * @param logger
	 * @param text
	 */
	public static void debugText(Logger logger, String text)  throws Exception {
		try {
			logger.debug("---------------Text Start------------------" + DateUtil.formatTodayWithMil());
			logger.debug(text + "");
			logger.debug("---------------Text End------------------\n");
		} catch (Exception e) {
		}
	}

	/**
	 * PrintStackTrace 로깅
	 * @param logger
	 * @param error
	 */
	public static void infoPrintStackTrace(Logger logger, Throwable error)  throws Exception {
		try {
			logger.info("-------PrintStackTrace Start--------" + DateUtil.formatTodayWithMil());
			logger.info(getStackTraces(error));
			logger.info("-------PrintStackTrace End--------\n");
		} catch (Exception e) {
		}
	}
	
	/**
	 * PrintStackTrace 로깅
	 * @param error
	 * @return
	 */
	private static String getStackTraces(Throwable error)  throws Exception {
		StringBuffer sb = new StringBuffer();
		
		try {
			sb.append("error message: " + error.getMessage() + "");
			
			int line = 0;
			StackTraceElement[] stackTraces = error.getStackTrace();
			for(StackTraceElement stackTrace : stackTraces) {
				sb.append("     " + stackTrace.getClassName() + ": " + stackTrace.getFileName() + " (" + stackTrace.getLineNumber() + ") \n");
				line++;
				
				if(line > 10) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
