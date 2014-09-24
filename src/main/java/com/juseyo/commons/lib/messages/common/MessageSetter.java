/**
 * @file		MessageSetter.java
 * @brief   	리턴메시지를 설정하여 리턴헤주는 클레스 
 * @author  	개발1팀 / 파트5
 * @author  	김연근 ( solaris@wemakeprice.com )
 * @date    	생성: 2014-03-14
 * @date    	최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.messages.common;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.juseyo.commons.lib.messages.MessageService;

/**
* @brief 	MessageSetter
* @author 	개발1팀 / 파트5
* @version 1.0
* @date    생성: 2014-03-14
* @date    최종수정: 2014-03-14
* @remark	
*/
@Repository("MessageCommonSetter") 
public class MessageSetter {
	
	@Resource(name = "MessageCommonServiceImpl")
	private MessageService messageService;

	@Resource(name = "MessageAlphaServiceImpl")
	private MessageService messageAlphaService;
	
	@Resource(name = "MessageBravoServiceImpl")
	private MessageService messageBravoService;
	
	@Resource(name = "MessageCharlieServiceImpl")
	private MessageService messageCharlieService;
	
	private Map<?, ?> messages;

	/**
	 * 메세지 리턴
	 * @param code
	 * @return
	 */
	public String getMessages(String code) throws Exception {
		return (String)messageService.getString(code);
	}

	
	/**
	 * 메세지 리턴 ( 각각의 종류별로 찾아서 )
	 * @param code
	 * @return
	 */
	public String getMessages(String code, String className) throws Exception {
		
		if( className.contains("Alpha") ){
			return (String)messageAlphaService.getString(code);
		} else if( className.contains("Bravo") ){
			return (String)messageBravoService.getString(code);
		} else if( className.contains("Charlie") ){
			return (String)messageCharlieService.getString(code);
		} else {
			return (String)messageService.getString(code);
		}

	}
	/**
	 * 0000 - 프로세스 성공 : 메세지 세팅 ( JSON / JSONP / XML )
	 * @param model
	 * @return
	 */
	public void set0000(Model model) {
		String code = "0000";
		model.addAttribute("result_no", code);
		model.addAttribute("error_desc", "");
	}

	
	/**
	 * 공통 메세지 세팅 ( 코드, 컨트롤러명  )
	 * @return
	 * @throws Exception
	 */
	public Map<String, ?> setCommonMessage(String code, String className) throws Exception {
		return (Map<String, ?>) setModel(code, className); 
	}	

	
	/**
	 * 리턴 모델에 code 세팅
	 * @param code
	 * @return
	 */
	 public ModelMap setModel(String code, String className) throws Exception {
		ModelMap model = new ModelMap();
		model.addAttribute("result_no", code);
		model.addAttribute("error_desc", this.getMessages(code, className));
		model.addAttribute("data", "");
		return model;
	}

	
	/**
	 * 리턴 모델에 code와 message 세팅
	 * @param code
	 * @param msg
	 * @return
	 */
	public ModelMap setModelWithMessage(String code, String msg) {
		ModelMap model = new ModelMap();
		model.addAttribute("result_no", code);
		model.addAttribute("error_desc", msg);
		model.addAttribute("data", "");
		return model;
	}

	/**
	 * 지정된 코드에 대한 파라미터 모델에 메세지 세팅 ( model )
	 * @param Model model
	 * @param String code
	 * @return
	 */
	public void setMethod(Model model, String code) throws Exception {
		model.addAttribute("result_no", code);
		model.addAttribute("error_desc", this.getMessages(code));
		model.addAttribute("data", "");
	}	
		
	 /**
     * 지정된 코드에 대한 파라미터 모델에 메세지 세팅 ( model )
     * @param Model model
     * @param String code
     * @param String className ( Alpha / Bravo / Charlie )
     * @return
     */
	public void setMethod(Model model, String code, String className) throws Exception {
        model.addAttribute("result_no", code);
        model.addAttribute("error_desc", this.getMessages(code, className ));
        model.addAttribute("data", "");
    }   
    
	
}