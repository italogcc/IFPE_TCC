package com.sees.projeto.service;

import com.sees.projeto.dto.RegistroUsuarioDTO;
import com.sees.projeto.entity.*;
import com.sees.projeto.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario registrar(RegistroUsuarioDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setDataCadastro(LocalDateTime.now());
        usuario.setUsuarioTipo(dto.getTipo());

        if (dto.getTipo() == UsuarioTipo.PF) {
            Usuario_PF pf = new Usuario_PF();
            pf.setUsuario(usuario);
            pf.setNome(dto.getNome());
            usuario.setUsuarioPF(pf);
        }

        if (dto.getTipo() == UsuarioTipo.A) {
            Usuario_A admin = new Usuario_A();
            admin.setUsuario(usuario);
            admin.setNome(dto.getNome());
            usuario.setUsuarioA(admin);
        }

        if (dto.getTipo() == UsuarioTipo.PJ) {
            Usuario_PJ pj = new Usuario_PJ();
            pj.setUsuario(usuario);
            pj.setRazaoSocial(dto.getRazaoSocial());
            usuario.setUsuarioPJ(pj);
        }

        if (dto.getTipo() == UsuarioTipo.F) {
            Usuario_F fornecedor = new Usuario_F();
            fornecedor.setUsuario(usuario);
            fornecedor.setRazaoSocial(dto.getRazaoSocial());
            usuario.setUsuarioF(fornecedor);
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario autenticar(String email, String senhaDigitada) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (!passwordEncoder.matches(senhaDigitada, usuario.getSenha())) {
            throw new RuntimeException("Senha inválida.");
        }

        return usuario;
    }

    public String obterNomeExibicao(Usuario usuario) {
        if (usuario.getUsuarioTipo() == UsuarioTipo.PF && usuario.getUsuarioPF() != null) {
            return usuario.getUsuarioPF().getNome();
        }

        if (usuario.getUsuarioTipo() == UsuarioTipo.A && usuario.getUsuarioA() != null) {
            return usuario.getUsuarioA().getNome();
        }

        if (usuario.getUsuarioTipo() == UsuarioTipo.PJ && usuario.getUsuarioPJ() != null) {
            return usuario.getUsuarioPJ().getNomeExibicao();
        }

        if (usuario.getUsuarioTipo() == UsuarioTipo.F && usuario.getUsuarioF() != null) {
            return usuario.getUsuarioF().getNomeExibicao();
        }

        return usuario.getEmail();
    }
}
