package br.com.rdocampos.biblioteca.model;

import br.com.rdocampos.biblioteca.model.enums.TipoUsuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario", schema = "biblioteca")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotNull
    private String nome;
    @NotNull
    @Length(min = 11, max = 11)
    private String cpf;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String telefone;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    private String senha;
    @NotNull
    private LocalDateTime dataCadastro;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String email, String telefone, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.cpf = cpf.replaceAll("[^0-9]*","");
        this.email = email.toLowerCase();
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.dataCadastro = LocalDateTime.now();
    }

    public Usuario(String nome, String cpf, String email, String telefone, TipoUsuario tipoUsuario, String senha) {
        this.nome = nome;
        this.cpf = cpf.replaceAll("[^0-9]*","");
        this.email = email.toLowerCase();
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
    }


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("[^0-9]*","");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
