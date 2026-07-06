package com.sees.projeto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class PessoaFisicaDados {

    @Column(nullable = false, length = 100)
    protected String nome;

    @Column(nullable = false, length = 100)
    protected String sobrenome;

    @Column(nullable = false, length = 14)
    protected String cpf;

    @Column(length = 30)
    protected String rg;

    @Column(name = "data_nascimento")
    protected LocalDate dataNascimento;

    @Column(length = 150)
    protected String logradouro;

    @Column(name = "log_numero", length = 20)
    protected String logNumero;

    @Column(length = 100)
    protected String complemento;

    @Column(length = 100)
    protected String cidade;

    @Column(length = 2)
    protected String estado;

    @Column(length = 10)
    protected String cep;

    @Column(length = 20)
    protected String telefone1;

    @Column(length = 20)
    protected String telefone2;

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogNumero() {
        return logNumero;
    }

    public void setLogNumero(String logNumero) {
        this.logNumero = logNumero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
    
    
    
}
