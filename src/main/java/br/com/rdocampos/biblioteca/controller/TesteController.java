package br.com.rdocampos.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteController {

    @RequestMapping("/")
    public String visualizarTeste(){

        return "teste.html";
    }
}
