package com.ckx.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * Created by Administrator on 2020/10/21.
 */
public class MailUtils {

    public static void sendMail(String address,String subject, String emailMsg) throws AddressException, MessagingException {

        Properties prop = new Properties();
        prop.put("mail.host", "smtp.163.com");
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");

        // 使用java发送邮件5步骤
        // 1.创建sesssion
        Session session = Session.getInstance(prop);
        // 开启session的调试模式，可以查看当前邮件发送状态
        session.setDebug(true);

        Transport ts;
        // 2.通过session获取Transport对象（发送邮件的核心API）
        ts = session.getTransport();
        // 3.通过邮件用户名密码链接
        ts.connect("15688595296@163.com", "GJZKGIOYUGWDZMUF");
        // 4.创建邮件
        Message msg = createSimpleMail(session,address,subject,emailMsg);
        // 5.发送电子邮件
        ts.sendMessage(msg, msg.getAllRecipients());

    }
    public static MimeMessage createSimpleMail(Session session, String address,String subject, String emailMsg) throws AddressException, MessagingException {
        // 创建邮件对象
        MimeMessage mm = new MimeMessage(session);
        // 设置发件人
        mm.setFrom(new InternetAddress("15688595296@163.com"));
        // 设置收件人
        mm.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
        // 设置抄送人
        //mm.setRecipient(Message.RecipientType.CC, new InternetAddress(
        //      "用户名@163.com"));

        //设置邮件主题
        mm.setSubject(subject);

        //设置邮件内容
        mm.setContent(emailMsg, "text/html;charset=utf-8");


        return mm;
    }

    public static void main(String[] args) throws AddressException, MessagingException {
        MailUtils.sendMail("1291407533@qq.com","测试" ,"abcdefg");
    }
}

