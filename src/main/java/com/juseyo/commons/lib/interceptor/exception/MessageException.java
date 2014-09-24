package com.juseyo.commons.lib.interceptor.exception;

/**
 * Created by popldo on 2014. 5. 2..
 */
public class MessageException extends Exception {
    String messageId;
    String messageTarget;
    public MessageException(String messageId){
        this.messageId = messageId;
    }
    public MessageException(String messageId,String messageTarget){
        this.messageId = messageId;
        this.messageTarget = messageTarget;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageTarget() {
        return messageTarget;
    }

    public void setMessageTarget(String messageTarget) {
        this.messageTarget = messageTarget;
    }
}
