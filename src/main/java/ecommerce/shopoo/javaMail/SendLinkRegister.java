package ecommerce.shopoo.javaMail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendLinkRegister {

    public static void sendMailTo(String recepientMail, long id) throws Exception {

        final String fromMail = "aodaivietnam000@gmail.com";
        final String passwordFromMail = "nsnbnjxajiljpvws";

        System.out.println("Prepare to send message");
        //Cach 1: Via TLS ==============================================================
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); 
        
        //Cach 2: Via SSL ==============================================================
        //properties.put("mail.smtp.host", "smtp.gmail.com");
        //properties.put("mail.smtp.port", "465");
        //properties.put("mail.smtp.auth", "true");
        //properties.put("mail.smtp.socketFactory.port", "465");
        //properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromMail, passwordFromMail);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepientMail));
            message.setSubject("Java Mail - Via TLS");
            //Cach 1:
            //message.setText("This message was sent from Java, \n\n Please do not spam my email!");
            //Cach 2:
            String htmlCode = "<h1> Send message from java </h1> "
                    + "<h2>"
                    + "<a href='http://localhost:8080/e_Commerce_Shopoo/setEnableTrue?id=" + id + "'> "
                    + "Click into link to set Enable=True</a>"
                    + "</h2> ";                               
            message.setContent(htmlCode, "text/html"); 
            
            //==================================================================
//            Multipart emailContent = new MimeMultipart();
//            
//            MimeBodyPart textBodyPart = new MimeBodyPart();
//            textBodyPart.setText("My multipart text");
//           
//            MimeBodyPart imgAttachment = new MimeBodyPart();
//            imgAttachment.attachFile("C:\\Users\\Bong Ma\\Desktop\\e_Commerce_Shopoo\\src\\main\\webapp\\resources\\img\\review-3.jpg");
//            
//            emailContent.addBodyPart(textBodyPart);
//            emailContent.addBodyPart(imgAttachment);
//            
//            message.setContent(emailContent);
            
            
            Transport.send(message);
            System.out.println("Sent message successfully!");
        } catch (Exception e) {}
    }
}