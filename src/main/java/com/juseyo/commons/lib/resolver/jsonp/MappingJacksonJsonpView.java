/**
 * @file		MappingJacksonJsonpView.java
 * @brief   JSON View방식을 JSONP 방식으로 전환 
 * @author  개발1팀 / 파트1
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.resolver.jsonp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
* @brief 	MappingJacksonJsonpView
* @author 	개발1팀 / 파트1
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
public class MappingJacksonJsonpView extends MappingJacksonJsonView {

	public static final String DEFAULT_CONTENT_TYPE = "application/javascript";

	@Override
	public String getContentType() {
		return DEFAULT_CONTENT_TYPE;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if("GET".equals(request.getMethod().toUpperCase())) {

			@SuppressWarnings("unchecked")
			Map<String, String[]> params = request.getParameterMap();

			if(params.containsKey("callback")) {
				response.getOutputStream().write(new String(params.get("callback")[0] + "(").getBytes());
				super.render(model, request, response);
				response.getOutputStream().write(new String(");").getBytes());
				response.setContentType(DEFAULT_CONTENT_TYPE);
			} else {
				super.render(model, request, response);
			}
		} else {
			super.render(model, request, response);
		}
	}

}
