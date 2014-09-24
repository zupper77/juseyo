/**
 * @file		StandardResponseUtil.java
 * @brief   messageSetter를 통해 돌아온 JSON 데이터의 파싱 
 * @author  개발1팀 / eagle파트
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-19
 * @date    최종수정: 2014-03-19
 */
package com.juseyo.commons.lib.utility;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
* @brief 	StandardResponseUtil
* @author 	개발1팀 / eagle 파트
* @version 1.0
* @date    생성: 2014-03-19
* @date    최종수정: 2014-03-19
* @remark	
*/
public class StandardResponseUtil {
	
	 /**
	 * @brief	요청한  JSON 스트링을 파싱함  
	 * @details
	 * @param  	source String형태의 데이터소스
	 * @return 	responseValue HashMap형태의 리턴데이터
	 */
	public static HashMap<String,String> responseMap(String source)  throws Exception {
		
		// 리턴할 구조체 선언 
		HashMap<String,String> responseValue = new HashMap<String,String>();
	
		// 기존 JSON 파싱 
		Object obj = JSONValue.parse(source);
		JSONObject object = (JSONObject)obj;
		
		responseValue.put("data", object.get("data").toString());
		responseValue.put("error_desc", object.get("error_desc").toString());
		responseValue.put("result_no", object.get("result_no").toString());
		
		return responseValue;
		
	}
	

	 /**
	 * @brief	요청한  JSON 스트링을 파싱하여 원하는 Tag 에 대한 데이터 전달함  
	 * @details
	 * @param  	source String형태의 데이터소스
	 * @param 	targetName	 원하는 JSON 내부의 Tag
	 * @return 	responseValue 원하는 스티링 데이터
	 */
	public static String responseString( String source, String targetName ) throws Exception {
	
		// 리턴할 구조체 선언 
		String responseValue = null;
		
		// 기존 JSON 파싱 
		Object obj = JSONValue.parse(source);
		JSONObject object = (JSONObject)obj;
		
		responseValue = object.get(targetName).toString();
		
		return responseValue;
	}

	 /**
	 * @brief	요청한  JSON 스트링을 파싱하여 data 에 해당하는 JSON 스트링을 요청한 TypeToken 으로 파싱하여 Object로 리턴함  ..  
	 * @details  default 로  data tag에 대한 파싱 진행
	 * @param source  String으로 전달되는 JSON 소스
	 * @param type TypeToken 형태의 Type 데이터
	 * @return responseValue 리턴되는 Object ( 실사용시는 TypeToken 타입으로 캐스팅해야함 )
	 */
	public static Object responseObject( String source, Type type ) throws Exception {

		Gson gson = new Gson();
		// 기존 JSON 파싱 
		Object obj = JSONValue.parse(source);
		JSONObject object = (JSONObject)obj;
		
		String data = object.get("data").toString();
		Object responseValue = gson.fromJson(data, type);
		
		return responseValue;
	}
	
	 /**
	 * @brief	요청한  JSON 스트링을 파싱하여 data 에 해당하는 JSON 스트링을 요청한 TypeToken 으로 파싱하여 Object로 리턴함  ..  
	 * @details 지정한 JSON 테그에 대해 파싱 진행 ( 파싱할것이 없는 TAG는 사용금지 )
	 * @param source  String으로 전달되는 JSON 소스
	 * @param type TypeToken 형태의 Type 데이터
	 * @param 	targetName	 원하는 JSON 내부의 Tag 
	 * @return responseValue 리턴되는 Object ( 실사용시는 TypeToken 타입으로 캐스팅해야함 )
	 */
	public static Object responseObject( String source, Type type, String tagName ) throws Exception {

		Gson gson = new Gson();
		// 기존 JSON 파싱 
		Object obj = JSONValue.parse(source);
		JSONObject object = (JSONObject)obj;
		
		String data = object.get(tagName).toString();
		Object responseValue = gson.fromJson(data, type);
		
		return responseValue;
	}	
	
}
