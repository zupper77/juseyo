/**
 * @file SHA256Util.java
 * @brief   패스워드를 단방향 암호화 방식인 SHA-256방식으로 암호화 한다.
 * @author  개발3팀/파트3
 * @author  최경진
 * @date    생성: 2014. 4. 21.
 * @date    최종수정: 2014. 4. 21.
 */
package com.juseyo.commons.lib.utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @brief SHA256Util
 * @author 개발3팀/파트3/최경진
 * @version 1.0
 * @date 생성: 2014. 4. 21.
 * @date 최종수정: 2014. 4. 21.
 * @remark
 */
public class SHA256Util {

    /**
     * 
     * @brief 스트링을 SHA256방식으로 암호화한다.
     * @details 스트링을 받아서 SHA256방식으로 암호화 한다.
     * @param password
     *            패스워드
     * @return String 암호화한 값
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (password == null || "".equals(password)) {
            return null;
        }
        return getString(getHash(password));
    }

    /**
     * 
     * @brief From a password, a number of iterations, returns the corresponding digest
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        byte[] input = digest.digest(password.getBytes("UTF-8"));
        return input;
    }

    /**
     * 
     * @brief From a byte[] returns a base 64 representation
     * @details
     * @param data
     * @return
     */
    private static String getString(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).toUpperCase().substring(1));

        }
        return sb.toString();
    }

}
