/**
 * @file		MappingXmlView.java
 * @brief   JSON View방식을 XML 방식으로 전환 
 * @author  개발1팀 / 파트1
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.resolver.xml;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.google.gson.Gson;

/**
* @brief 	MappingXmlView
* @author 	개발1팀 / 파트1
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
public class MappingXmlView extends MappingJacksonJsonView {

	public static final String DEFAULT_CONTENT_TYPE = "application/xml";

	@Override
	public String getContentType() {
		return DEFAULT_CONTENT_TYPE;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Gson gson = new Gson();
		String source = gson.toJson(model);
		
		XMLSerializer serializer = new XMLSerializer(); 
        JSON json = JSONSerializer.toJSON( source );
        serializer.setRootName("response");
        
        String objectRes = serializer.write( json );  	
		response.getOutputStream().write( objectRes.getBytes() );
		response.setContentType(DEFAULT_CONTENT_TYPE);
	}

}
