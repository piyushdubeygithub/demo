package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Users;
import com.example.demo.service.UserService;
import com.example.demo.utilities.SMTPMailSender;


@RestController
public class MainController {

	@Autowired
	UserService userService;
	
	@Autowired
	SMTPMailSender smtpMailSender;
	
	 @RequestMapping(value="/getuser", method=RequestMethod.POST)
	public 	Map<String, Object> getUser(@RequestBody Users usermap) {
			Map<String, Object> result = userService.createUser(usermap);
		return result;
	}

	@RequestMapping(value="/sendMail")
	public void sendMail() {
		
	 	try {
			smtpMailSender.send("vikash.patwal@oodlestechnologies.com", "JavaMail", "Hi test mail");

	 		/*
			
		final String userName = "piyush.dubey@oodlestechnologies.com";
		final String password = "piyush@oodles1";
	 	Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);
		boolean isStartTLSEnable = true; 
		if(isStartTLSEnable) props.put("mail.smtp.starttls.enable", isStartTLSEnable);			
		if(!isStartTLSEnable) props.put("mail.smtp.socketFactory.port", 465);
		if(!isStartTLSEnable) props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		if(!isStartTLSEnable) props.put("mail.smtp.socketFactory.fallback", false);
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName,password);
			}
		  });

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("piyush.dubey@oodlestechnologies.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("amit.gupta@oodlestechnologies.com"));
//			if(cc != null)message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
//			if(bcc != null)message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
			message.setSubject("hi hello love you");
			message.setText("jsdddddddsadkjakjdjsjjfkkjsajkfkkg");

//			MimeBodyPart messageBodyPart = new MimeBodyPart();
//            Multipart multipart = new MimeMultipart();
//            for (File file : files) {
//            	messageBodyPart.attachFile(file);
//            	DataSource source = new FileDataSource(file);
//                messageBodyPart.setDataHandler(new DataHandler(source));
//                messageBodyPart.setFileName(file.getName());
//                multipart.addBodyPart(messageBodyPart);
//			}
//            message.setContent(multipart);
			
//            BodyPart htmlBodyPart = new MimeBodyPart();
//            htmlBodyPart.setContent(body , "text/html");
//            multipart.addBodyPart(htmlBodyPart);
//            message.setContent(multipart);
            
            Transport.send(message);
			
		*/}  catch (Exception ge) {
			ge.printStackTrace();
		}
	}
}
