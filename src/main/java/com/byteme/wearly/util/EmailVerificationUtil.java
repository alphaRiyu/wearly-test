package com.byteme.wearly.util;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 08, 2022 10:50 AM
 */

@RequiredArgsConstructor
@Service
public class EmailVerificationUtil {

    private final JavaMailSender mailSender;
    private String to = "wearlyph2022@gmail.com";
    private int code;

    public void setTo(String to) {
        this.to = to;
    }

    public int getCode() {
        return code;
    }

    public void send() {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(String.valueOf(new InternetAddress("wearlyph2022@gmail.com", "Wearly")));
            helper.setTo(to);
            helper.setSubject("Wearly Email Verification");
            code = verificationCode();
            helper.setText("" +
                    "<html>" +
                    "<body>" +
                    "<center>" +
                    "<img src='cid:wearlyimage123' alt='wearly image' width='200px'>" +
                    "<h3>Your verification code is </h3>" +
                    "<h1>" + code + "</h1>" +
                    "</center>" +
                    "</body>" +
                    "</html>" +
                    "", true);
            FileSystemResource resource = new FileSystemResource(new File("src/main/resources/static/Attach.png"));
            helper.addInline("wearlyimage123", resource);
            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e ) {
            e.printStackTrace();
        }
    }

    public int verificationCode() {
        return (int) Math.floor(100000 + Math.random() * 900000);
    }
}
