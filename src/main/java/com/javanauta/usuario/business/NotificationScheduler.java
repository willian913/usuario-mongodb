package com.javanauta.usuario.business;



import com.javanauta.usuario.domain.Funcionario;
import com.javanauta.usuario.infrastructure.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class NotificationScheduler {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 8 * * *") // 8h todo dia
    public void verificarASOs() {
        LocalDate hoje = LocalDate.now();
        LocalDate limite = hoje.plusDays(30);

        List<Funcionario> funcionarios = funcionarioRepository.findByDataVencimentoAsoBetween(hoje, limite);

        for (Funcionario f : funcionarios) {
            String msg = String.format("O ASO de %s (ID Petrobras: %s) vence em %s",
                    f.getNome(), f.getIdPetrobras(), f.getDataVencimentoAso());

            emailService.enviarEmail(
                    "destinatario@exemplo.com",
                    "Alerta de vencimento de ASO",
                    msg,
                    "Equipe de Saúde Ocupacional"
            );
        }
    }
}

