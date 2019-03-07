package utilities;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	public void SendMailSSL(String filepath) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("seerapulds3","03g55a0204");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("seerapulds3@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse("seerapu.prasad@outlook.com"));
			//message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse("seerapu.prasad@yahoo.in"));
			message.setSubject("OnlineOrder Test Results");
			/*message.setText("Dear Prasad," +
					"\n\n How r u doing this is the test report");*/
			
			// Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("These are the results of OnlineOrder Test Results test cases");
				
			// Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         //String file = "filepath;
	         String filename = filepath;
	         DataSource source = new FileDataSource(filepath);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

			Transport.send(message);

			System.out.println("Message sent successfully .............");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}