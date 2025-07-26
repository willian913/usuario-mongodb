package com.javanauta.usuario.infrastructure.repository;

import com.javanauta.usuario.domain.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;
import java.util.List;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    List<Funcionario> findByDataVencimentoAsoBetween(LocalDate inicio, LocalDate fim);
}