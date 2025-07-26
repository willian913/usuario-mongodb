package com.javanauta.usuario.business;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(String destinatario, String titulo, String mensagem, String rodape) {
        try {
            String corpo = gerarCorpoEmail(titulo, mensagem, rodape);

            MimeMessage email = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(email, true, "UTF-8");
            helper.setTo(destinatario);
            helper.setSubject(titulo);
            helper.setText(corpo, true);
            helper.setFrom("w.almeidadefarias15@gmail.com");

            mailSender.send(email);
            System.out.println("E-mail enviado com sucesso para: " + destinatario);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao enviar e-mail", e);
        }
    }

    private String gerarCorpoEmail(String titulo, String mensagem, String rodape) {
        String corpo = """
        <!DOCTYPE html>
        <html>
        <head>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    background-color: #f5f5f5;
                    margin: 0;
                    padding: 0;
                }
                .container {
                    max-width: 600px;
                    margin: auto;
                    background-color: #ffffff;
                    padding: 20px;
                    border-radius: 8px;
                    box-shadow: 0 0 10px rgba(0,0,0,0.1);
                }
                .header img {
                    width: 100%%;
                    border-radius: 8px;
                }
                h2 {
                    color: #333333;
                }
                p {
                    color: #555555;
                }
                .footer {
                    margin-top: 30px;
                    font-size: 12px;
                    color: #888888;
                    text-align: center;
                }
            </style>
        </head>
        <body>
            <div class="container">
                <div class="header">
                    <img src="https://i.imgur.com/NyU57c6.jpeg" alt="Banner">
                </div>
                <h2>%s</h2>
                <p>%s</p>
                <div class="footer">%s</div>
            </div>
        </body>
        </html>
        """;

        return String.format(corpo, titulo, mensagem, rodape);
    }
}