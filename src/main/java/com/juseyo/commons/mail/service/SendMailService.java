package com.juseyo.commons.mail.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.mail.MessagingException;

import com.juseyo.commons.mail.dto.SendMailDto;

public interface SendMailService {
    /**
     * 
     * <pre>
     * 1. MethodName    : sendMail
     * 2. ClassName     : SendMailService
     * 3. Comment       : 메일 발송시 사용되는 메서드
     * 4. 작성자           : leejinwon
     * 5. 작성일           : 2014. 4. 14. 오후 5:11:44
     * </pre>
     * 
     * @param String senderName
     * @param String sender
     * @param ArrayList<String> receiver
     * @param String subject
     * @throws Exception 
     */
    public boolean getSendMailDto( String senderName, String sender, ArrayList<String> receiver, String subject, String content ) throws Exception;
    
    /**
     * 
     * <pre>
     * 1. MethodName    : sendMail
     * 2. ClassName     : SendMailService
     * 3. Comment       : 메일 발송시 사용되는 메서드 ( 지정된 ContentType 으로 발송 )
     * 4. 작성자           : leejinwon
     * 5. 작성일           : 2014. 4. 14. 오후 5:11:44
     * </pre>
     * 
     * @param String senderName
     * @param String sender
     * @param ArrayList<String> receiver
     * @param String subject
     * @param String contextType
     * @throws Exception 
     */
    public  boolean getSendMailDto( String senderName, String sender, ArrayList<String> receiver, String subject, String content, String contextType ) throws Exception;
    /**
     * 
     * <pre>
     * 1. MethodName    : sendTemplate
     * 2. ClassName     : SendMailService
     * 3. Comment       : 메일 발송시 사용되는 메서드
     * 4. 작성자           : 개발1팀 Eagle 파트 김연근 
     * 5. 작성일           : 2014. 4. 24
     * </pre>
     * 
     * @param String senderName
     * @param String sender
     * @param ArrayList<String> receiver
     * @param String subject
     * @param HashMap<String.String> templatePatten
     * @param String templateFilename
     * @throws Exception 
     */ 
    public boolean sendTemplate( String senderName, String sender, ArrayList<String> receiver,  String subject, HashMap<String,String> templatePatten, String templateFilename ) throws Exception;
    
    public void sendAsyncMailDto( String senderName, String sender, ArrayList<String> receiver, String subject, String content ) throws Exception;
    
    public void sendAsyncMailDto( String senderName, String sender, ArrayList<String> receiver, String subject, String content, String contextType ) throws Exception;
     
    public void sendAsyncTemplate( String senderName, String sender, ArrayList<String> receiver,  String subject, HashMap<String,String> templatePatten, String templateFilename ) throws Exception;
}

