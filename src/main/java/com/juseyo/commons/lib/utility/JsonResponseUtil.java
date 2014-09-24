package com.juseyo.commons.lib.utility;

import net.sf.json.JSONSerializer;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonResponseUtil {
	private Logger logger = Logger.getLogger (this.getClass());
	
	@SuppressWarnings("static-access")
	public ResponseEntity<String> getJSONResponse(Object obj) throws Exception {
		String jsonString = new JSONSerializer().toJSON(obj).toString();
		logger.debug("[getJSONResponse][jsonString]" + jsonString);
        return new ResponseEntity<String>(jsonString, makeJSONHttpHeaders(), HttpStatus.CREATED);
    }
     
    @SuppressWarnings("static-access")
	public String getJSONString(Object obj) throws Exception {
        return new JSONSerializer().toJSON(obj).toString();
    }
    
    private HttpHeaders makeJSONHttpHeaders() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-type", "application/json; charset=UTF-8");
        return responseHeaders;
	}
}
