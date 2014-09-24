/**
 * @file		RequestJsonUtil.java
 * @brief   파라미터로 전달된 JSON에서 원하는 Tag이 값을 확인 ( 메소드명확인요망 )
 * @author  개발1팀 / 파트1
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */

package com.juseyo.commons.lib.requestjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.juseyo.commons.lib.interceptor.exception.ParameterException;
import com.juseyo.commons.lib.utility.LogUtil;

/**
* @brief 	RequestJsonUtil
* @author 	개발1팀 / 파트1
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
@Repository("RequestJsonUtil")
public class RequestJsonUtil {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private HashMap<?, ?> hm = null;
	
	public RequestJsonUtil() {
		this.hm = null;
	}
	
	private void setHashMap(String body) throws Exception {
		this.hm = getRequestHashMap(body);
	}
	
	public HashMap<?, ?> getRequestHashMap(String body) throws Exception {
		try {
			HashMap<?, ?> retVal = new Gson().fromJson( body, HashMap.class );
			return retVal;
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}

	public String getString(String body, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			Object value = this.hm.get(key);
			
			if(value instanceof String) {
				return (String) value;
			} else {
				return String.valueOf(value);
			}
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}

	public int getInt(String body, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			Object value = this.hm.get(key);
			
			if(value instanceof Integer) {
				return (Integer) value;
			} else {
				String valueStr = (String) value;
				if(valueStr == null || "".equals(valueStr)) {
					valueStr = "0";
				}
				
				double valueDouble = Double.valueOf((String) value);
				
				int valueInt = (int) valueDouble;
				return valueInt;
			}
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}

	public long getLong(String body, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			Object value = this.hm.get(key);
			
			if(value instanceof Long) {
				return (Long) value;
			} else {
				String valueStr = (String) value;
				if(valueStr == null || "".equals(valueStr)) {
					valueStr = "0";
				}
				
				long valueLong = Long.parseLong(valueStr);
				return valueLong;
			}
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}

	public Double getDouble(String body, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			Object value = this.hm.get(key);
			
			if(value instanceof Double) {
				return (Double) value;
			} else {
				String valueStr = (String) value;
				if(valueStr == null || "".equals(valueStr)) {
					valueStr = "0";
				}
				
				Double valueLong = Double.parseDouble(valueStr);
				return valueLong;
			}
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}	
	
	public int getDoubleInteger(String body, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			Object value = this.hm.get(key);
			
			if(value instanceof Double) {
				return Integer.parseInt(String.valueOf(Math.round((Double) value)));
			} else {
				String valueStr = (String) value;
				if(valueStr == null || "".equals(valueStr)) {
					valueStr = "0";
				}
				
				Double valueLong = Double.parseDouble(valueStr);
				return Integer.parseInt(String.valueOf(Math.round(valueLong)));
			}
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}	

	
	
	public boolean getBoolean(String body, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			String value = (String) this.hm.get(key);
			
			if(value == null || "".equals(value)) {
				return false;
			} else {
				if("TRUE".equals(value.toUpperCase())) {
					return true;
				} else {
					return false;
				}
			}
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> getStringList(String body, String listKey, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			List<?> list = (ArrayList<?>) this.hm.get(listKey);
			
			Map<String, String> ml = null;
			List<String> values = new ArrayList<String>();
			
			for(Object m : list) {
				ml = (Map<String, String>) m;
				values.add(ml.get(key));
			}
			
			return values;
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}

	
	public HashMap<String, Object> getHashMapList( String body, String key ) throws Exception {
		
		Gson gson = new Gson();
		HashMap<String, Object> values = new HashMap<String, Object>();
		
		JsonParser parser = new JsonParser();
	    JsonArray array = parser.parse(body).getAsJsonArray();
	    
	    for( int i = 0 ; i < array.size() ; i++ ){
	    	values = gson.fromJson( array.get(i), HashMap.class );
	    	if( values.containsKey(key) ){
	    		break;
	    	}
	    }	    
	    return values;
	}
	
	
	public String getStringByObject(String body, String objectKey, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			LinkedTreeMap map = (LinkedTreeMap) this.hm.get(objectKey);
			Entry<?, ?> entry;
			Object mapKey = null;
			Object value = null;
			Set<?> set = map.entrySet();
			Iterator<?> it = set.iterator();
			
			while(it.hasNext()) {
				entry = (Entry<?, ?>) it.next();
				mapKey = entry.getKey();
				if(mapKey.equals(key)) {
					value = entry.getValue();
					
					if(value instanceof String) {
						return (String) value;
					} else {
						return String.valueOf(value);
					}
				}
			}
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	public int[] getIntArray(String body, String listKey, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			List<?> list = (ArrayList<?>) this.hm.get(listKey);
			
			Map<String, String> ml = null;
			List<Integer> intList = new ArrayList<Integer>();
			int v = 0;
			
			for(Object m : list) {
				ml = (Map<String, String>) m;
				
				try {
					v = Integer.parseInt(ml.get(key));
				} catch (Exception e) {
					v = 0;
					LogUtil.infoPrintStackTrace(logger, e);
				}
				
				intList.add(v);
			}
			
			int[] values = new int[intList.size()];
			for(int i = 0; i < intList.size(); i++) {
				values[i] = intList.get(i).intValue();
			}
			return values;
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}

	@SuppressWarnings("unchecked")
	public long[] getLongArray(String body, String listKey, String key) throws Exception {
		try {
			this.setHashMap(body);
			
			List<?> list = (ArrayList<?>) this.hm.get(listKey);
			
			Map<String, String> ml = null;
			List<Long> intList = new ArrayList<Long>();
			long v = 0;
			
			for(Object m : list) {
				ml = (Map<String, String>) m;
				
				try {
					v = Long.parseLong(ml.get(key));
				} catch (Exception e) {
					v = 0;
					LogUtil.infoPrintStackTrace(logger, e);
				}
				
				intList.add(v);
			}
			
			long[] values = new long[intList.size()];
			for(int i = 0; i < intList.size(); i++) {
				values[i] = intList.get(i).intValue();
			}
			return values;
		} catch(Exception e) {
			LogUtil.infoPrintStackTrace(logger, e);
			throw new ParameterException(); 
		}
	}
}

