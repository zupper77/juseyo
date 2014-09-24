/**
 * @file		ResolverUtil.java
 * @brief   입력된 스트링을 기준으로 리졸버 선택하여 리턴함 
 * @author  개발1팀 / 파트1
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.utility;

/**
* @brief 	ResolverUtil
* @author 	개발1팀 / 파트1
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/

public class ResolverUtil {

	/**
	 * 요청한  response_type 으로 Viewer를 결정함 
	 * @param String response_type
	 * @return String viewerString
	 */
	 /**
	 * @brief	요청한  response_type 으로 Viewer를 결정함 
	 * @details	기본은 jsonResolver 
	 * @param String response_type
	 * @return String viewerString
	 */
    public static String selectViewer( String response_type )  throws Exception {  
       
    	if( response_type.matches( ".*jsonp.*") ){
    		return "jsonpViewer";
    	} else if( response_type.matches( ".*xml.*") ){
    		return "xmlViewer";
    	}
        return "jsonViewer";  
    }

}
