package vn.iotstar.service.utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import vn.iotstar.models.UserModel;
import javax.mail.Transport;
import javax.mail.internet. InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	
	//Hàm mã code ngau nhien
	public String getRandom() {
	Random rnd = new Random();
	int number = rnd.nextInt(999999);
	return String.format("%06d", number);
	}
	
	public boolean sendEmail(UserModel user) {
	    boolean test = false;

	    String toEmail = user.getEmail();
	    String fromEmail = "phuongtrinhdangthuc@gmail.com";
	    String password = "123";

	    try {
	        // Your host email SMTP server details
	        Properties pr = configEmail(new Properties());
	        
	        // Get session to authenticate the host email address and password
	        Session session = Session.getInstance(pr, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        });

	      //set email message details
	        Message mess = new MimeMessage(session);
	        mess.setHeader("Content-Type", "text/plain; charset=UTF-8");
	        //set from email address
	        mess.setFrom(new InternetAddress(fromEmail));
	        //set to email address or destination email address
	        mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

	        //set email subject
	        mess.setSubject("Confirm Code");

	        //set message text
	        mess.setText("Your is code: " +user.getCode());
	        //send the message
	        Transport.send(mess);

	        test=true;
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return test;
	    
	}

	// Example configEmail method
	private Properties configEmail(Properties properties) {
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "587");
	    return properties;
	}

	public boolean EmailSend(UserModel user) {
		 boolean test = false;

		    String toEmail = user.getEmail();
		    String fromEmail = "phuongtrinhdangthuc@gmail.com";
		    String password = "kfbq ycvg qpga ydob";

		    try {
		        // Your host email SMTP server details
		        Properties pr = configEmail(new Properties());
		        
		        // Get session to authenticate the host email address and password
		        Session session = Session.getInstance(pr, new Authenticator() {
		            @Override
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(fromEmail, password);
		            }
		        });

		      //set email message details
		        Message mess = new MimeMessage(session);
		        mess.setHeader("Content-Type", "text/plain; charset=UTF-8");
		        //set from email address
		        mess.setFrom(new InternetAddress(fromEmail));
		        //set to email address or destination email address
		        mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

		        //set email subject
		        mess.setSubject("Confirm Code");

		        //set message text
		        mess.setText("Your pass is: " +user.getPassword());
		        //send the message
		        Transport.send(mess);

		        test=true;
		    }catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    return test;
		    
	}

}
