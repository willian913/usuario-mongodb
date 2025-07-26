package com.javanauta.usuario.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "funcionarios")
public class Funcionario {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private String idPetrobras;
    private LocalDate dataVencimentoAso;

    // Getters
    public String getId() {
        return id;
    }

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

    // Setters (se necessário)
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