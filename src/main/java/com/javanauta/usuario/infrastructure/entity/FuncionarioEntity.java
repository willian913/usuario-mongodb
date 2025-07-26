package com.javanauta.usuario.infrastructure.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Document(collection = "funcionarios")
@Data
public class FuncionarioEntity {

    private String nome;
    private String cpf;
    private String idPetrobras;
    private LocalDate dataVencimentoAso;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdPetrobras() {
        return idPetrobras;
    }

    public LocalDate getDataVencimentoAso() {
        return dataVencimentoAso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdPetrobras(String idPetrobras) {
        this.idPetrobras = idPetrobras;
    }

    public void setDataVencimentoAso(LocalDate dataVencimentoAso) {
        this.dataVencimentoAso = dataVencimentoAso;
    }
}

