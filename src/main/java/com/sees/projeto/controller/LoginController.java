package com.sees.projeto.controller;

import com.sees.projeto.entity.Usuario;
import com.sees.projeto.service.FaturaEnergiaService;
import com.sees.projeto.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;
    private final FaturaEnergiaService faturaEnergiaService;

    public LoginController(
            UsuarioService usuarioService,
            FaturaEnergiaService faturaEnergiaService
    ) {
        this.usuarioService = usuarioService;
        this.faturaEnergiaService = faturaEnergiaService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String autenticar(
            @RequestParam String email,
            @RequestParam String senha,
            HttpSession session,
            Model model
    ) {
        try {
            Usuario usuario = usuarioService.autenticar(email, senha);
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/painel";
        } catch (RuntimeException e) {
            model.addAttribute("erro", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/painel")
    public String painel(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario == null) {
            return "redirect:/login";
        }

        String nome = usuarioService.obterNomeExibicao(usuario);
        boolean temFaturas = faturaEnergiaService.usuarioTemFaturas(usuario.getUsuarioId());

        model.addAttribute("nome", nome);
        model.addAttribute("temFaturas", temFaturas);

        return "painel";
    }
}
