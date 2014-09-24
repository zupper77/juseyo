package com.juseyo.commons.mail.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.juseyo.commons.lib.utility.FileUtil;
import com.juseyo.commons.lib.utility.PatternUtil;
import com.juseyo.commons.mail.dto.SendMailDto;
import com.juseyo.commons.mail.service.SendMailService;

/**
 * @brief SendMailServiceImpl
 * @author 개발지원2팀 / 간지파트
 * @version (1.0)
 * @date 생성 : 2014-4-18
 * @date 최종수정 : 2014-5-28
 * @remark
 * 
 */

@Repository("SendMailServiceImpl")
public class SendMailServiceImpl implements SendMailService {

    private static final Logger logger = LoggerFactory.getLogger(SendMailServiceImpl.class);
    private static final String mailServer = "mail.wemakeprice.com"; //메일서버 호스트 URL. 2014.4 현재 이 호스트 이외는 스팸으로 처리됨.
    private Message message = null;
    private Address senderAddress = null;
    private Address[] receiverAddress = null;

    public void sendMail(SendMailDto sendMailDto)  throws Exception {

         
        if (sendMailDto.getSender() == null || sendMailDto.getSubject() == null
                || sendMailDto.getContent() == null
                || sendMailDto.getReceiver() == null) {
            throw new NullPointerException(
                    "sender, subject, content, receiver is null.");
        }

        initializeMailServer();
        initializeSender(sendMailDto);
        initializeReceiver(sendMailDto);
        // 메일발송 
        send(sendMailDto);

        logger.debug("send mail success !!!");

    }

    private void initializeMailServer()    throws Exception {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", mailServer);
        Session s = Session.getDefaultInstance(properties);
        this.message = new MimeMessage(s);
    }

    private void initializeSender(SendMailDto sendMailDto) throws Exception {
            
        if (sendMailDto.getSenderName() == null) {
            sendMailDto.setSenderName(sendMailDto.getSender());
        }

        this.senderAddress = new InternetAddress(sendMailDto.getSender(),
                MimeUtility.encodeText(sendMailDto.getSenderName(), "UTF-8", "B"));
    }

    private void initializeReceiver(SendMailDto sendMailDto)  throws Exception {
           
        ArrayList<String> receiverList = sendMailDto.getReceiver();
        int receiverCount = receiverList.size();

        this.receiverAddress = new Address[receiverCount];

        for (int i = 0; i < receiverCount; i++) {
            this.receiverAddress[i] = new InternetAddress( (String) receiverList.get(i));
        }
    }

    private void send(SendMailDto sendMailDto) throws Exception {
          
        this.message.setHeader("content-type", "text/html;charset=UTF-8");
        this.message.setFrom(this.senderAddress);
        this.message.setRecipients(Message.RecipientType.TO,   this.receiverAddress);
        this.message.setSubject(MimeUtility.encodeText(sendMailDto.getSubject(), "UTF-8", "B"));
        this.message.setContent(sendMailDto.getContent(),   "text/html;charset=UTF-8");
        this.message.setSentDate(new Date());

        Transport.send(this.message);
    }
    
    /**
     * 전송할 이메일의 정보의 DTO를 생성하는 메소드 
     * @param senderName : 보내는 사람
     * @param sender    : 송신자 메일 주소
     * @param receiver  : 수신자 메일 주소, N개의 메일을 전송한다.
     * @param subject   : 메일 제목
     * @param content : 메일 내용
     * @return
     */
    public boolean getSendMailDto( String senderName, String sender, ArrayList<String> receiver, String subject, String content ) throws Exception {
        
        SendMailDto sendMailDto = new SendMailDto();
        sendMailDto.setSender(sender);
        sendMailDto.setSenderName(senderName);
        sendMailDto.setReceiver(receiver);
        sendMailDto.setSubject(subject);
        sendMailDto.setContent(content);
        sendMailDto.setContentType("text/html;charset=UTF-8");
        
        this.sendMail(sendMailDto);
        return true;
    }

    /**
     * 전송할 이메일의 정보의 DTO를 생성하는 메소드 
     * @param senderName : 보내는 사람
     * @param sender    : 송신자 메일 주소
     * @param receiver  : 수신자 메일 주소, N개의 메일을 전송한다.
     * @param subject   : 메일 제목
     * @param content : 메일 내용
     * @param contextType : 메일내용의 ContentType 
     * @return
     */
    public  boolean getSendMailDto( String senderName, String sender, ArrayList<String> receiver, String subject, String content, String contextType ) throws Exception {
        
        SendMailDto sendMailDto = new SendMailDto();
        sendMailDto.setSender(sender);
        sendMailDto.setSenderName(senderName);
        sendMailDto.setReceiver(receiver);
        sendMailDto.setSubject(subject);
        sendMailDto.setContent(content);
        sendMailDto.setContentType(contextType);
        
        this.sendMail(sendMailDto);
        return true;
    }
    
    /**
     * 템플릿을 사용한 메일전송 ( 개발1팀 이글파트 김연근 )
     * @param senderName : 보내는 사람
     * @param sender    : 송신자 메일 주소
     * @param receiver  : 수신자 메일 주소, N개의 메일을 전송한다.
     * @param subject   : 메일 제목
     * @param templatePatten : 템플릿 패턴 
     * @param templateFilename : 템플릿 파일명 
     * @return
     */
    public boolean sendTemplate( String senderName, String sender, ArrayList<String> receiver,  String subject, HashMap<String,String> templatePatten, String templateFilename ) throws Exception {

        InputStream is = getClass().getResourceAsStream(templateFilename);
        String mailTemplateResource = FileUtil.getFileString(is);
        String afterResource = PatternUtil.messageReplaceMap( templatePatten, mailTemplateResource );
        
        SendMailDto mail = new SendMailDto();
        mail.setSender(sender);
        mail.setSenderName(senderName);
        mail.setReceiver(receiver);
        mail.setSubject(subject);
        mail.setContent(afterResource);
        mail.setContentType("text/html;charset=UTF-8");
        
        this.sendMail(mail);
        return true;
    }
    
    
    /**
     * @brief 전송할 이메일의 정보의 DTO를 생성하는 메소드 (비동기)
     * @details 전송할 이메일의 정보의 DTO를 생성하는 메소드 (비동기)
     * @param senderName : 보내는 사람
     * @param sender    : 송신자 메일 주소
     * @param receiver  : 수신자 메일 주소, N개의 메일을 전송한다.
     * @param subject   : 메일 제목
     * @param content : 메일 내용
     */
    public void sendAsyncMailDto(final String senderName, final String sender,
            final ArrayList<String> receiver, final String subject, final String content)
            throws Exception {
        Runnable task = new Runnable() {

            @Override
            public void run() {
                try {
                    SendMailDto sendMailDto = new SendMailDto();
                    sendMailDto.setSender(sender);
                    sendMailDto.setSenderName(senderName);
                    sendMailDto.setReceiver(receiver);
                    sendMailDto.setSubject(subject);
                    sendMailDto.setContent(content);
                    sendMailDto.setContentType("text/html;charset=UTF-8");

                    sendMail(sendMailDto);
                } catch (Exception ex) {
                    logger.error(ex.getMessage());
                }
            }
        };
        new Thread(task, "ServiceMailThread").start();

    }

    /**
     * @brief 전송할 이메일의 정보의 DTO를 생성하는 메소드 (비동기)
     * @details 전송할 이메일의 정보의 DTO를 생성하는 메소드 (비동기)
     * @param senderName : 보내는 사람
     * @param sender    : 송신자 메일 주소
     * @param receiver  : 수신자 메일 주소, N개의 메일을 전송한다.
     * @param subject   : 메일 제목
     * @param content : 메일 내용
     * @param contextType : 메일내용의 ContentType 
     */
    public void sendAsyncMailDto(final String senderName, final String sender,
            final ArrayList<String> receiver, final String subject,
            final String content, final String contextType) throws Exception {
        Runnable task = new Runnable() {

            @Override
            public void run() {
                try {
                    SendMailDto sendMailDto = new SendMailDto();
                    sendMailDto.setSender(sender);
                    sendMailDto.setSenderName(senderName);
                    sendMailDto.setReceiver(receiver);
                    sendMailDto.setSubject(subject);
                    sendMailDto.setContent(content);
                    sendMailDto.setContentType(contextType);

                    sendMail(sendMailDto);
                } catch (Exception ex) {
                    logger.error(ex.getMessage());
                }
            }
        };
        new Thread(task, "ServiceMailThread").start();
    }
    
    /**
     * @brief 템플릿을 사용한 메일전송 (비동기)
     * @details 템플릿을 사용한 메일전송 (비동기)
     * @param senderName : 보내는 사람
     * @param sender    : 송신자 메일 주소
     * @param receiver  : 수신자 메일 주소, N개의 메일을 전송한다.
     * @param subject   : 메일 제목
     * @param templatePatten : 템플릿 패턴 
     * @param templateFilename : 템플릿 파일명 
     */
    public void sendAsyncTemplate(final String senderName, final String sender,
            final ArrayList<String> receiver, final String subject,
            final HashMap<String, String> templatePatten, final String templateFilename)
            throws Exception {

        Runnable task = new Runnable() {

            @Override
            public void run() {
                try {
                    InputStream is = getClass().getResourceAsStream(
                            templateFilename);
                    String mailTemplateResource = FileUtil.getFileString(is);
                    String afterResource = PatternUtil.messageReplaceMap(
                            templatePatten, mailTemplateResource);

                    SendMailDto mail = new SendMailDto();
                    mail.setSender(sender);
                    mail.setSenderName(senderName);
                    mail.setReceiver(receiver);
                    mail.setSubject(subject);
                    mail.setContent(afterResource);
                    mail.setContentType("text/html;charset=UTF-8");

                    sendMail(mail);
                } catch (Exception ex) {
                    logger.error(ex.getMessage());
                }
            }
        };
        new Thread(task, "ServiceMailThread").start();
    }
    
}
