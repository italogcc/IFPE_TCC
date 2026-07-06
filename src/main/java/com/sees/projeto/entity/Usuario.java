package com.sees.projeto.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_tipo", nullable = false, length = 2)
    private UsuarioTipo usuarioTipo;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Usuario_PF usuarioPF;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Usuario_PJ usuarioPJ;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Usuario_F usuarioF;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Usuario_A usuarioA;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public UsuarioTipo getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    public Usuario_PF getUsuarioPF() {
        return usuarioPF;
    }

    public void setUsuarioPF(Usuario_PF usuarioPF) {
        this.usuarioPF = usuarioPF;
    }

    public Usuario_PJ getUsuarioPJ() {
        return usuarioPJ;
    }

    public void setUsuarioPJ(Usuario_PJ usuarioPJ) {
        this.usuarioPJ = usuarioPJ;
    }

    public Usuario_F getUsuarioF() {
        return usuarioF;
    }

    public void setUsuarioF(Usuario_F usuarioF) {
        this.usuarioF = usuarioF;
    }

    public Usuario_A getUsuarioA() {
        return usuarioA;
    }

    public void setUsuarioA(Usuario_A usuarioA) {
        this.usuarioA = usuarioA;
    }
}
