// EmailController.java
package com.javanauta.usuario.api;

import com.javanauta.usuario.api.request.EmailRequest;
import com.javanauta.usuario.business.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarEmail(@RequestBody EmailRequest request) {
        emailService.enviarEmail(
                request.getDestinatario(),
                request.getTitulo(),
                request.getMensagem(),
                request.getRodape()
        );
        return ResponseEntity.ok("E-mail enviado para: " + request.getDestinatario());
    }
}
