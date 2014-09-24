package com.juseyo.commons.lib.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;

/**
 * XStreamUtil
 * XML 내용을 읽어 객체화 합니다.
 * @author hhkim
 *
 */
public class XStreamUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(XStreamUtil.class);
	
	public static void main(String[] args) throws Exception {
		XStreamUtil xStreamUtil = new XStreamUtil();
		StringBuffer xml = new StringBuffer();
		xml.append("<userInfo>");
		xml.append("<userId>1111</userId>");
		xml.append("<userName>김동완</userName>");
		xml.append("<birth>2010.09.10</birth>");
		xml.append("</userInfo>");
//		UserInfoDto userInfo = (UserInfoDto)xStreamUtil.toObjectByXML("userInfo", UserInfoDto.class, xml.toString());
	//	logger.info("[result is :] " + userInfo);
	}
	
	/**
	 * toObjectByXML 
	 * xml 데이터를 읽어 Class에 맞는 Domain Object로 변환하여 리턴한다.
	 * @param classAlias
	 * @param claszz
	 * @param xml
	 * @return object
	 */
	public Object toObjectByXML(String classAlias, Class<?> claszz, String xml)  throws Exception {
		XStream xStream = new XStream();
		xStream.alias(classAlias, claszz);
		Object object = (Object)xStream.fromXML(xml);
		logger.info("[toObjectByXML][object]" + object);
		return object;
	}
	

}