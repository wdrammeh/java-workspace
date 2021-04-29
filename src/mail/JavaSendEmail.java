package mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * <strong>This example uses the java API</strong>
 */
public class JavaSendEmail {

    public static void main(String [] args){
        String from = "email@example.com";
        String to = "another-email@example.com";
        String host = "localhost";//or IP address

        //Get the session object
        final Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try{
            final MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Send Mail Test");
            message.setText("Hello, this is example of sending email using java API.");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
