package com.juseyo.commons.lib.utility;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class XmlResponseUtil {
	private Logger logger = Logger.getLogger (this.getClass());
	
	public ResponseEntity<String> getXMLResponse(Object obj) throws Exception {
		logger.info("[getXMLResponse][obj]" + obj);
        return new ResponseEntity<String>(obj.toString(), makeXMLHttpHeaders(), HttpStatus.CREATED);
    }
	
	private HttpHeaders makeXMLHttpHeaders() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-type", "application/xml; charset=UTF-8");
        return responseHeaders;
	}
}
