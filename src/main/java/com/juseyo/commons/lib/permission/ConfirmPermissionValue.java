/**
 * @file		ConfirmPermissionValue.java
 * @brief   로그인 관련 인증확인용 클레스 
 * @author  개발1팀 / 파트5
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.permission;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

/**
* @brief 	ConfirmPermissionValue
* @author 	개발1팀 / 파트5
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
@Repository("ConfirmPermissionValue")
public class ConfirmPermissionValue {

	 /**
	 * @brief		MVC & JSP View 방식의 처리중 로그인 확인이 필요한 경우 사용 
	 * @details	
	 * @param 	HttpSession
	 * @return		boolean
	 */
	public boolean mvcCheckSession(HttpSession session) throws Exception {
		// 각각의 세션에 저장된 값이 있는 경우 로그인이 된 상태로 설정하고 true를 리턴하고
		// 로그인이 안되었다고 확인되는 경우 false를 리턴함. 
		return false;
	}

	 /**
	 * @brief		REST방식의 처리중 로그인 확인이 필요한 경우 사용 
	 * @details	
	 * @param 	HttpSession
	 * @return		boolean
	 */
	public boolean restCheckSession(HttpSession session) throws Exception {
		// 각각의 세션에 저장된 값이 있는 경우 로그인이 된 상태로 설정하고 true를 리턴하고
		// 로그인이 안되었다고 확인되는 경우 false를 리턴함. 	
		return false;
	}


	
}
