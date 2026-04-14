package com.Movies.watchwise_backend.service;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${SENDGRID_API_KEY}")
    private String apiKey;

    public void sendOtpEmail(String toEmail, String otp) {
        try {
            Email from = new Email("kishoreamurthupally@gmail.com"); // verified email
            String subject = "WatchWise OTP Verification";
            Email to = new Email(toEmail);
            Content content = new Content("text/plain",
                    "Your OTP is: " + otp + "\nValid for 5 minutes.");

            Mail mail = new Mail(from, subject, to, content);

            SendGrid sg = new SendGrid(apiKey);
            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sg.api(request);

            System.out.println("SendGrid Status: " + response.getStatusCode());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send OTP");
        }
    }

    public void sendWelcomeEmail(String toEmail, String username) {
        try {
            Email from = new Email("kishoreamurthupally@gmail.com");
            String subject = "Welcome to WatchWise!";
            Email to = new Email(toEmail);
            Content content = new Content("text/plain",
                    "Hi " + username + ", Welcome to WatchWise!");

            Mail mail = new Mail(from, subject, to, content);

            SendGrid sg = new SendGrid(apiKey);
            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            sg.api(request);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
