package com.sees.projeto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PessoaJuridicaDados {

    @Column(name = "razao_social", nullable = false, length = 150)
    protected String razaoSocial;

    @Column(name = "nome_fantasia", length = 150)
    protected String nomeFantasia;

    @Column(nullable = false, length = 18)
    protected String cnpj;

    @Column(name = "inscricao_estadual", length = 50)
    protected String inscricaoEstadual;

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

    public String getNomeExibicao() {
        if (nomeFantasia != null && !nomeFantasia.isBlank()) {
            return nomeFantasia;
        }

        return razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
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
