package com.juseyo.commons.mail.dto;

import java.util.ArrayList;


/**
 * @brief getSendMailDto
 * @author 개발지원2팀 / 간지파트
 * @version (1.0)
 * @date 생성 : 2014-4-18
 * @date 최종수정 : 2014-4-18
 * @remark
 * 
 */

public class SendMailDto {
    
    private String sender; //송신자 메일 주소
    private String senderName; //보내는 사람
    private String subject; //메일 제목
    private String content; //메일 내용
    private String contentType; // 헤더 
    
    private ArrayList<String> receiver; //수신자 메일 주소


    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getReceiver() {
        return receiver;
    }

    public void setReceiver(ArrayList<String> receiver) {
        this.receiver = receiver;
    }

}
