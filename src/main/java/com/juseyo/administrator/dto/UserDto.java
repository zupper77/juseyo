/**
 * @file UserDto.java
 * @brief 조직원 dto
 * @author 개발3/파트1
 * @author 김순모
 * @date 생성 : 2014. 4. 17.
 * @date 최종수정: 2014. 4. 17.
 */
package com.juseyo.administrator.dto;

import org.apache.ibatis.type.Alias;

/**
 * @brief UserDto
 * @author 개발3팀/파트1
 * @version 1.0
 * @date 생성: 2014. 4. 17.
 * @date 최종수정: 2014. 4. 17.
 * @remark
 */
@Alias("user.userDto")
public class UserDto {
    // 조직원 코드
    private String userCd;
    // 사용자 패스워드
    private String userPwd;
    private String delYn;
    private String userNm;

    public String getUserCd() {
        return userCd;
    }

    public void setUserCd(String userCd) {
        this.userCd = userCd;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }
}
