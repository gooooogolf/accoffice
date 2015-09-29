/**
 * 
 */
package com.total.acc.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author Sirimongkol
 *
 */
public class MailUtil {
	
	public static boolean sendFromHostMail(String host, String port, final String user, final String pass, String[] to, String subject, String body) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
          });
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Done");
            return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

	
	 public static void sendEmailWithAttachments(String host, String port, final String userName, final String password, String[] to, String subject, String message, String[] attachFiles) throws AddressException, MessagingException {
	        // sets SMTP server properties
	        Properties properties = new Properties();
//	        properties.put("mail.smtp.host", host);
//	        properties.put("mail.smtp.port", port);
//	        properties.put("mail.smtp.auth", "true");
//	        properties.put("mail.smtp.starttls.enable", "true");
//	        properties.put("mail.user", userName);
//	        properties.put("mail.password", password);
//	        properties.put("mail.smtp.ssl.trust", host);
	        
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.debug", "true");
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.ssl.trust", host);
	        
	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        Session session = Session.getInstance(properties, auth);
	 
	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);
	 
	        msg.setFrom(new InternetAddress(userName));
//	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
//	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            msg.setRecipients(Message.RecipientType.TO, toAddress);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	 
	        // creates message part
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent(message, "text/html; charset=utf-8");
	 
	        // creates multi-part
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	 
	        // adds attachments
	        if (attachFiles != null && attachFiles.length > 0) {
	            for (String filePath : attachFiles) {
	                MimeBodyPart attachPart = new MimeBodyPart();
	 
	                try {
	                    attachPart.attachFile(filePath);
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	 
	                multipart.addBodyPart(attachPart);
	            }
	        }
	 
	        // sets the multi-part as e-mail's content
	        msg.setContent(multipart);
	 
	        // sends the e-mail
	        Transport.send(msg);
	 
	    }
	 
		public static boolean sendFromGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	            return true;
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	            return false;
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	            return false;
	        }
	    }
}
