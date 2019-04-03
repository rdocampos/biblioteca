package br.com.rdocampos.biblioteca.controller;

import br.com.rdocampos.biblioteca.model.Usuario;
import br.com.rdocampos.biblioteca.repository.UsuarioRepository;
import br.com.rdocampos.biblioteca.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String visualizarLogin(HttpSession session) {

        return "login";
    }

    @RequestMapping(value = "/validar-login", method = RequestMethod.POST)
    public String efetuarLogin(HttpSession session, @RequestParam(value = "email") String email, @RequestParam(value = "senha") String senha) {
        Usuario usuario = usuarioRepository.getByEmail(email);
        if (usuario.getSenha().equals(loginService.gerarHash(senha))) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/deslogar")
    public String deslogarUsuario(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
