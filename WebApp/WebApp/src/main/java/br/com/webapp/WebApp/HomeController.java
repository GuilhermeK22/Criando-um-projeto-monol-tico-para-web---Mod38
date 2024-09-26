package br.com.webapp.WebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public String index(Model model) {
        List<Usuario> usuarios = service.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

    @PostMapping("/usuarios")
    public String salvar(@RequestBody Usuario usuario) {
        service.salvar(usuario);
        return "redirect:/";
    }
}
