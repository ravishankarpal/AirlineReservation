package com.airline.reservation.system.AirlineReservationSystem.util;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    public  void sendEmailWithAttachment(EmailDetails emailDetails, String filePath)  {
        log.info("trying to send email message to passengers");
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
             // Setting multipart as true for attachments to
             // be send
             messageHelper = new MimeMessageHelper(mailMessage, true);
             messageHelper.setFrom(sender);
             messageHelper.setTo(emailDetails.getRecipient());
             messageHelper.setText(emailDetails.getMsgBody());
             messageHelper.setSubject(emailDetails.getSubject());
             messageHelper.addAttachment("Ticket", new File(filePath));
             log.info("Email has been sent successfully!");
        }
        catch (jakarta.mail.MessagingException e){
            log.info("Exception while sending email", e);
        }



    }
}
