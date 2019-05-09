package Demo;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;    
import javax.mail.internet.*;    
class MailConfiguration{  
    public static void send(final String from,final String password,String to,String sub,String msg,String destination){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub); 
           
           
      MimeBodyPart messageBodyPart1 = new MimeBodyPart();
       	messageBodyPart1.setText("screenshot");
           MimeBodyPart messageBodyPart2 = new MimeBodyPart();
           //DataSource fds = new FileDataSource(
        		 //  "/Users/sivaranjani/Downloads/check.jpeg");
           DataSource fds = new FileDataSource(
        		  destination);
           messageBodyPart2.setDataHandler(new DataHandler(fds));
    
   	Multipart multipart = new MimeMultipart();
   	multipart.addBodyPart(messageBodyPart1);
   	multipart.addBodyPart(messageBodyPart2);
   	message.setContent(multipart);
    
           
        		  //message.setHeader("Content-ID", "FailedImage");
          
           
           
           //message.setText(msg);    
           //send message  
           Transport.send(message);    
          // System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
            
    }
          public static void main(String[] args)
          {
        	  //send("sivaranjanidx@gmail.com","Ranjani@91","sivaranjanidx@gmail.com","Login failed","nn");
        	  System.out.println("message sent successfully");    
          }
      
}  
