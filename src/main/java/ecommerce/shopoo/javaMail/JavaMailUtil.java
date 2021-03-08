package ecommerce.shopoo.javaMail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {

    public static void sendMailTo(String recepient) throws Exception {

        final String fromMail = "aodaivietnam000@gmail.com";
        final String passwordFromMail = "nsnbnjxajiljpvws";
        
        System.out.println("Prepare to send message");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromMail, passwordFromMail);
            }
        });

        Message message = prepareMessage(session, fromMail, recepient);

        Transport.send(message);
        System.out.println("Message was sent successfully");
    }

    private static Message prepareMessage(Session session, String fromMail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("My first message from java");
            message.setText("Hi there, \n look my email");
            //String htmlCode = "<h1> Send message from java </h1>";
            //message.setContent("", "text/html");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
