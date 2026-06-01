package com.Movies.watchwise_backend.service;

import com.sendgrid.SendGrid;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.Method;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Content;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${SENDGRID_API_KEY}")
    private String apiKey;

    // ================= OTP EMAIL =================
    public void sendOtpEmail(String toEmail, String otp) {

        try {

            Email from = new Email(
                    "kishoreamurthupally@gmail.com",
                    "WatchWise");

            Email to = new Email(toEmail);

            String subject = "WatchWise Verification Code";

            String htmlContent =
                    "<div style='font-family:Arial,sans-serif;padding:20px;'>"
                            + "<h2 style='color:#1e88e5;'>🎬 WatchWise Email Verification</h2>"
                            + "<p>Hello,</p>"
                            + "<p>Your verification code is:</p>"
                            + "<h1 style='color:#e53935;letter-spacing:5px;'>"
                            + otp
                            + "</h1>"
                            + "<p>This OTP is valid for 5 minutes.</p>"
                            + "<p>If you did not request this code, please ignore this email.</p>"
                            + "<br>"
                            + "<p>Thanks,<br><b>WatchWise Team</b></p>"
                            + "</div>";

            Content content = new Content("text/html", htmlContent);

            Mail mail = new Mail(from, subject, to, content);

            SendGrid sendGrid = new SendGrid(apiKey);

            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);

            System.out.println("OTP Status Code : " + response.getStatusCode());
            System.out.println("OTP Response : " + response.getBody());

            if (response.getStatusCode() != 202) {
                throw new RuntimeException("Failed to send OTP email");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send OTP");
        }
    }

    // ================= WELCOME EMAIL =================
    public void sendWelcomeEmail(String toEmail, String username) {

        try {

            Email from = new Email(
                    "kishoreamurthupally@gmail.com",
                    "WatchWise");

            Email to = new Email(toEmail);

            String subject = "Welcome To WatchWise 🎉";

            String htmlContent =
                    "<div style='font-family:Arial,sans-serif;padding:20px;'>"
                            + "<h2 style='color:#1e88e5;'>🎬 Welcome To WatchWise</h2>"
                            + "<p>Hi <b>" + username + "</b>,</p>"
                            + "<p>Thank you for joining WatchWise.</p>"
                            + "<p>Discover movies, ratings, reviews and recommendations.</p>"
                            + "<br>"
                            + "<p>Enjoy your journey!</p>"
                            + "<p><b>WatchWise Team</b></p>"
                            + "</div>";

            Content content = new Content("text/html", htmlContent);

            Mail mail = new Mail(from, subject, to, content);

            SendGrid sendGrid = new SendGrid(apiKey);

            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);

            System.out.println("Welcome Status Code : "
                    + response.getStatusCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
