package com.sees.projeto.controller;

import com.sees.projeto.dto.RegistroUsuarioDTO;
import com.sees.projeto.entity.UsuarioTipo;
import com.sees.projeto.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registrar")
    public String escolherTipo() {
        return "registro-tipo";
    }

    @GetMapping("/registrar/formulario")
    public String formulario(@RequestParam UsuarioTipo tipo, Model model) {
        model.addAttribute("tipo", tipo);
        return "registro-form";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute RegistroUsuarioDTO dto, Model model) {
        try {
            usuarioService.registrar(dto);
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("tipo", dto.getTipo());
            return "registro-form";
        }
    }
}
