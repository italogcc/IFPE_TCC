package com.sees.projeto.controller;

import com.sees.projeto.entity.Usuario;
import com.sees.projeto.service.FaturaEnergiaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faturas")
public class FaturaController {

    private final FaturaEnergiaService service;

    public FaturaController(FaturaEnergiaService service) {
        this.service = service;
    }

    @GetMapping("/novo")
    public String novo(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario == null) {
            return "redirect:/login";
        }

        return "faturas-form";
    }

    @PostMapping("/salvar")
    public String salvar(
            @RequestParam("mesAno") String[] meses,
            @RequestParam("kwh") String[] kwhs,
            @RequestParam("valorPago") String[] valores,
            HttpSession session
    ) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario == null) {
            return "redirect:/login";
        }

        service.salvarDozeFaturas(usuario, meses, kwhs, valores);

        return "redirect:/painel";
    }
}
