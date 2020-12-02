
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

public class envio1 {

    public static void main(String[] args) {

        try {
            String username = "jpalominos@unprg.edu.pe";
            String password = "";
            String recipient = "rdiazp@unprg.edu.pe";

            Properties props = new Properties();

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.setProperty("mail.debug", "true");

            Session session = Session.getInstance(props, null);

            MimeMessage msg = new MimeMessage(session);
            msg.setRecipients(Message.RecipientType.TO, recipient);
            msg.setSubject("hola");  //titulo
            msg.setSentDate(new Date());
            msg.setText("correcto"); //mensaje

            Transport transport = session.getTransport("smtp");

            transport.connect(username, password);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        } catch (AddressException ex) {
            Logger.getLogger(envio1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(envio1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
