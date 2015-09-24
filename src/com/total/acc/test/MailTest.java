/**
 * 
 */
package com.total.acc.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Sirimongkol
 *
 */
public class MailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        final String username = "noreply@acc-billing.net";
        final String password = "Giwm392$";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.acc-billing.net");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.ssl.trust", "mail.acc-billing.net");
//        props.put("mail.smtp.ssl.trust", "true");
//        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sirimongkol.pan@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
