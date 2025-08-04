package com;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {

	public static void sendmail(String to, String sub, String msg) {

		final String username = "shivshanji1432@gmail.com";
		final String password = "bfcd cdbp blgn nsvw"; // Use App Password, not your main Gmail password

		// Gmail SMTP server configuration
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Create session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);

			// Set From: header field
			message.setFrom(new InternetAddress(username));

			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject and Body
			message.setSubject(sub);
			message.setText(msg);

			// Send message
			Transport.send(message);
			System.out.println("Email sent successfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		EmailSender.sendmail("shivshanji1432@gmail.com", "test", "Testing");

	}

}
