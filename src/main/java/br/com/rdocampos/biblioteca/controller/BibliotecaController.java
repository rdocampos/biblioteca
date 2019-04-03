package br.com.rdocampos.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BibliotecaController {


    @RequestMapping("/")
    public String visualizarIndex(Model model) {


        String mainContent = "/main-content/index";
        model.addAttribute("mainContent", mainContent);
        return "/pattern/model-page";
    }
}
