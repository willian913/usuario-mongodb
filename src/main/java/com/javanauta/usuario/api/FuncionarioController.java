package com.javanauta.usuario.api;

import com.javanauta.usuario.domain.Funcionario;
import com.javanauta.usuario.infrastructure.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public List<Funcionario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario f) {
        return repository.save(f);
    }
}