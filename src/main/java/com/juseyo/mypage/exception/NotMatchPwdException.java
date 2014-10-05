/**
 * @file NotMatchPwdException.java
 * @brief 간단한 설명 
 * @author 개발3/파트2
 * @author 이정우
 * @date 생성 : 2014. 5. 7.
 * @date 최종수정: 2014. 5. 7.
 */
package com.juseyo.mypage.exception;

/**
 * @brief   NotMatchPwdException
 * @author  개발3팀/파트2/송아영
 * @version 1.0
 * @date    생성: 2014. 5. 7.
 * @date    최종수정: 2014. 5. 7.
 * @remark
 */
public class NotMatchPwdException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NotMatchPwdException(){
        super();
    }

    /**
     * @param string
     */
    public NotMatchPwdException(String msg) {
        super(msg);
    }
}
