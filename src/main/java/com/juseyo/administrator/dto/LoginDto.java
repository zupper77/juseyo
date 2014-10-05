/**
 * @file	LoginDto.java
 * @brief   간단한 설명 
 * @author  개발3/파트1
 * @author  iljesica
 * @date    생성 : 2014. 4. 29.
 * @date    최종수정: 2014. 4. 29.
 */
package com.juseyo.administrator.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

/**
 * @brief 	LoginDto
 * @author 	개발3팀/파트1/iljesica
 * @version 1.0
 * @date    생성: 2014. 4. 29.
 * @date    최종수정: 2014. 4. 29.
 * @remark	
 */
@Alias("user.loginDto")
public class LoginDto {
	/**
	 * 로그인 번호
	 */
	private Integer loginSeq;
	/**
	 * 직원코드
	 */
	private String userCd;
	/**
	 * 로그인 아이피
	 */
	private String loginIp;
	/**
	 * 로그인 os
	 * 
	 */
	private String loginOs;
	/**
	 * 로그인 브라우져
	 */
	private String loginBrowser;
	/**
	 * 로그인 날짜
	 */
	private Timestamp loginAt;
	/**
	 * @return the loginSeq
	 */
	public Integer getLoginSeq() {
		return loginSeq;
	}
	/**
	 * @param loginSeq the loginSeq to set
	 */
	public void setLoginSeq(Integer loginSeq) {
		this.loginSeq = loginSeq;
	}
	/**
	 * @return the userCd
	 */
	public String getUserCd() {
		return userCd;
	}
	/**
	 * @param userCd the userCd to set
	 */
	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}
	/**
	 * @return the loginIp
	 */
	public String getLoginIp() {
		return loginIp;
	}
	/**
	 * @param loginIp the loginIp to set
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	/**
	 * @return the loginOs
	 */
	public String getLoginOs() {
		return loginOs;
	}
	/**
	 * @param loginOs the loginOs to set
	 */
	public void setLoginOs(String loginOs) {
		this.loginOs = loginOs;
	}
	/**
	 * @return the loginBrowser
	 */
	public String getLoginBrowser() {
		return loginBrowser;
	}
	/**
	 * @param loginBrowser the loginBrowser to set
	 */
	public void setLoginBrowser(String loginBrowser) {
		this.loginBrowser = loginBrowser;
	}
	/**
	 * @return the loginAt
	 */
	public Timestamp getLoginAt() {
		return loginAt;
	}
	/**
	 * @param loginAt the loginAt to set
	 */
	public void setLoginAt(Timestamp loginAt) {
		this.loginAt = loginAt;
	}
	
	

}
