/**
 * @file		mcrypt.java
 * @brief   PHP와 동일한 암호화 방식으로 적 
 * @author  개발1팀 / 파트5
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.encryption.mcrypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Repository;

import com.juseyo.commons.lib.utility.Base64;

/**
* @brief 	mcrypto
* @author 	개발1팀 / 파트5
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
@Repository("mcrypto")
public class mcrypto {

	static char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private SecretKeySpec passkeyspec;
	private SecretKeySpec userkeyspec;

	private String passwdSecretKey = "wlrmagodqhrgksrk";
	private String userinfoSecretKey = "roqkftlfghkdlxld";

	 /**
	 * @brief		메소드 초기화 데이터 적 
	 * @details	암복호화키 초기화 
	 * @param 	
	 * @return		
	 */
	public mcrypto() {
		String PasspaddedKey = passwdSecretKey;
		String UserpaddedKey = userinfoSecretKey;
		passkeyspec = new SecretKeySpec(PasspaddedKey.getBytes(), "AES");
		userkeyspec = new SecretKeySpec(UserpaddedKey.getBytes(), "AES");
	}

	 /**
	 * @brief		패스워드 암호화  
	 * @details	지정된 파라미터를 패스워드 암호화키로 암호화  
	 * @param 	source 암호화 대상 
	 * @return		암호화된 데이터 
	 */
	public String encryptPass(String source) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, passkeyspec);
		String paddedData = padString2(source);
		return bytesToHex(cipher.doFinal(paddedData.getBytes()));
	}

	 /**
	 * @brief		사용자 정보  암호화  
	 * @details	지정된 파라미터를 사용자정보  암호화키로 암호화  
	 * @param 	source 암호화 대상 
	 * @return		암호화된 데이터 
	 */
	public String encryptUser(String source) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, userkeyspec);
		String paddedData = padString2(source);
		return bytesToHex(cipher.doFinal(paddedData.getBytes()));
	}

    /**
     * @brief       일반 정보  암호화  
     * @details 지정된 파라미터를 사용자정보  암호화키로 암호화  
     * @param   source 암호화 대상 
     * @return      암호화된 데이터 
     */
	public String encryptNormal(String source) throws Exception {
	    
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, userkeyspec);
        
        byte[] encrypted = cipher.doFinal(source.getBytes("UTF-8"));
        String enStr = new String(Base64.encodeBytes(encrypted));
        
        return enStr;
    }
    
	 /**
	 * @brief		패스워드 복호화 
	 * @details	지정된 파라미터를 패스워드 암호화키로 복호화   
	 * @param 	source 복호화 대상 
	 * @return		복호화된 데이터 
	 */
	public String decryptPass(String source) throws Exception {
		if (source == null || source.length() == 0)
			throw new Exception("Empty string");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, passkeyspec);
		return new String(cipher.doFinal(hexToBytes(source)));
	}

	 /**
	 * @brief		사용자정보  복호화 
	 * @details	지정된 파라미터를 사용자정보  암호화키로 복호화   
	 * @param 	source 복호화 대상 
	 * @return		복호화된 데이터 
	 */
	public String decryptUser(String source) throws Exception {
		if (source == null || source.length() == 0)
			throw new Exception("Empty string");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, userkeyspec);
		return new String(cipher.doFinal(hexToBytes(source)));
	}

    /**
     * @brief       일반 정보  복호화 
     * @details 지정된 파라미터를 사용자정보  암호화키로 복호화   
     * @param   source 복호화 대상 
     * @return      복호화된 데이터 
     */
    public String decryptNormal(String source) throws Exception {
        if (source == null || source.length() == 0)
            throw new Exception("Empty string");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, userkeyspec);
        return new String(cipher.doFinal(Base64.decode(source)));
    }
	
	
	public static String bytesToHex(byte[] buf) {
		char[] chars = new char[2 * buf.length];
		for (int i = 0; i < buf.length; ++i) {
			chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
			chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
		}
		return new String(chars);
	}

	public static byte[] hexToBytes(String str) {
		if (str == null) {
			return null;
		} else if (str.length() < 2) {
			return null;
		} else {
			int len = str.length() / 2;
			byte[] buffer = new byte[len];
			for (int i = 0; i < len; i++) {
				buffer[i] = (byte) Integer.parseInt(
						str.substring(i * 2, i * 2 + 2), 16);
			}
			return buffer;
		}
	}

	public static String padString2(String source) {
		char paddingChar = '\0';
		int size = 16;
		int padLength = size - source.length() % size;

		for (int i = 0; i < padLength; i++) {
			source += paddingChar;
		}

		return source;
	}

	@SuppressWarnings("unused")
	private static String padString(String source) {
		char paddingChar = 0;
		int size = 16;
		int x = source.length() % size;
		int padLength = size - x;

		for (int i = 0; i < padLength; i++) {
			source += paddingChar;
		}

		return source;
	}
}
