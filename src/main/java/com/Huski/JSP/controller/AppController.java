package com.Huski.JSP.controller;

import com.Huski.JSP.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    private final UsuarioService usuarioService;

    public AppController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model){
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestParam String correo, @RequestParam String password, Model model){
        boolean encontrado = usuarioService.validarCredenciales(correo, password);
        
        if (encontrado) {
            return "redirect:/landing";
        } else {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/landing")
    public String home(){
        return "home";
    }
}
