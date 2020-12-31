package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMailBySite {

    public static void main(String[] args) {
        final String host = "mail.javatpoint.com";
        final String user = "wakadrammeh@gmail.com";
        final String password = "wdrammeh20";
        final String to = "md21712494@utg.edu.gm";

        //Get the session object
        final Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        final Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            final MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Dashboard Mail Test");
            message.setText("This is simple program of sending email using a site: "+host);

            //send it
            Transport.send(message);
            System.out.println("Message sent successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
