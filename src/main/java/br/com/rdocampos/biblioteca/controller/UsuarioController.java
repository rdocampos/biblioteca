package br.com.rdocampos.biblioteca.controller;

import br.com.rdocampos.biblioteca.model.Usuario;
import br.com.rdocampos.biblioteca.model.enums.TipoUsuario;
import br.com.rdocampos.biblioteca.repository.UsuarioRepository;
import br.com.rdocampos.biblioteca.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String visualizarLogin() {

        return "/content/login";
    }

    @RequestMapping(value = "/validar-login", method = RequestMethod.POST)
    public String efetuarLogin(HttpSession session, @RequestParam(value = "email") String email, @RequestParam(value = "senha") String senha) {
        Usuario usuario = usuarioRepository.getByEmail(email);
        if (usuario.getSenha().equals(loginService.gerarHash(senha))) {
            session.setAttribute("usuarioLogado", usuario.getIdUsuario());
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

    @RequestMapping("/cadastrar-usuario")
    public String visualizarCadastroUsuario(Model model) {
        model.addAttribute("admin", false);
        return "/content/cadastrarUsuario";
    }

    @RequestMapping(value = "/realizar-cadastro-usuario", method = RequestMethod.POST)
    public String realizarCadastroUsuario(@RequestParam(value = "email", required = false) String email,
                                          @RequestParam(value = "nome", required = false) String nome,
                                          @RequestParam(value = "cpf", required = false) String cpf,
                                          @RequestParam(value = "telefone", required = false) String telefone, Model model) {
        Usuario usuario;
        String erro = "";
        try {
            usuario = new Usuario(nome, cpf, email, telefone, TipoUsuario.U);
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            usuario = null;
            erro = "Algum dado faltante ou email/CPF já cadastrado";
        }
        model.addAttribute("erro", erro);
        model.addAttribute("usuario", usuario);
        return "/alert/respostaCadastro";
    }

    @RequestMapping("/cadastrar-admin")
    public String visualizarCadastroAdmin(Model model) {

        model.addAttribute("admin", true);
        return "/content/cadastrarUsuario";
    }

    @RequestMapping(value = "/realizar-cadastro-admin", method = RequestMethod.POST)
    public String realizarCadastroAdmin(@RequestParam(value = "email", required = false) String email, @RequestParam(value = "senha", required = false) String senha,
                                        @RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "confirmaSenha", required = false) String confirmaSenha,
                                        @RequestParam(value = "cpf", required = false) String cpf, @RequestParam(value = "telefone", required = false) String telefone, Model model) {
        Usuario usuario = null;
        String erro = "";
        if (loginService.validaConfirmaSenha(senha, confirmaSenha) && !senha.equals("")) {
            try {
                usuario = new Usuario(nome, cpf, email, telefone, TipoUsuario.A, loginService.gerarHash(senha));
                usuarioRepository.save(usuario);
            } catch (Exception e) {
                e.printStackTrace();
                usuario = null;
                erro = "Algum dado faltante ou email/CPF já cadastrado";
            }
        } else {
            erro = "Confirma senha não confere";
        }
        model.addAttribute("erro", erro);
        model.addAttribute("usuario", usuario);
        return "/alert/respostaCadastro";
    }

    @RequestMapping("/alterar-cadastro-usuario")
    public String visualizarAlteraCadastroUsuario(HttpSession session, Model model, @RequestParam(value = "idUsuario", required = false) Long idUsuario) {
        Usuario usuario;
        if (idUsuario == null) {
            idUsuario = (Long) session.getAttribute("usuarioLogado");
        }
        usuario = usuarioRepository.getUsuarioByIdUsuario(idUsuario);

        model.addAttribute("usuario", usuario);
        return "/content/alterarCadastro";
    }

    @RequestMapping(value = "/realizar-altera-cadastro-usuario", method = RequestMethod.POST)
    public String realizarAlteraCadastroUsuario(@RequestParam(value = "email", required = false) String email, @RequestParam(value = "idUsuario") Long idUsuario,
                                                @RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "cpf", required = false) String cpf,
                                                @RequestParam(value = "telefone", required = false) String telefone, Model model) {
        Usuario usuario = usuarioRepository.getUsuarioByIdUsuario(idUsuario);
        String erro = "";

        try {
            usuario.setEmail(email);
            usuario.setNome(nome);
            usuario.setCpf(cpf);
            usuario.setTelefone(telefone);
            usuario = usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            usuario = null;
            erro = "Algum dado faltante ou email/CPF já cadastrado";
        }
        model.addAttribute("atualizar", "true");
        model.addAttribute("erro", erro);
        model.addAttribute("usuario", usuario);
        return "/alert/respostaCadastro";
    }

    @RequestMapping("/realizar-altera-senha-usuario")
    public String alterarSenhaUsuario(@RequestParam(value = "senhaAtual", required = false) String senhaAtual, @RequestParam(value = "novaSenha", required = false) String novaSenha,
                                      @RequestParam(value = "confirmaSenha", required = false) String confirmaSenha, @RequestParam(value = "idUsuario") Long idUsuario, Model model) {
        Usuario usuario = usuarioRepository.getUsuarioByIdUsuario(idUsuario);
        String erro = "";
        if (loginService.gerarHash(senhaAtual).equals(usuario.getSenha())) {
            if (loginService.validaConfirmaSenha(novaSenha, confirmaSenha)) {
                try {
                    usuario.setSenha(loginService.gerarHash(novaSenha));
                    usuario = usuarioRepository.save(usuario);
                } catch (Exception e) {
                    e.printStackTrace();
                    usuario = null;
                    erro = "Erro ao salvar no bando de dados";
                }
            } else {
                usuario = null;
                erro = "Confirma senha divergente da nova senha";
            }
        } else {
            usuario = null;
            erro = "Senha atual errada";
        }
        model.addAttribute("atualizar", "true");
        model.addAttribute("erro", erro);
        model.addAttribute("usuario", usuario);
        return "/alert/respostaCadastro";

    }
}
