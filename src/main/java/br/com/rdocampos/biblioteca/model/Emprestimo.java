package br.com.rdocampos.biblioteca.model;

import br.com.rdocampos.biblioteca.model.enums.StatusEmprestimo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimo", schema = "biblioteca")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmprestimo;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDevolucaoPrevista;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDevolucao;
    private Long idUsuario;
    @ManyToOne
    @JoinColumn
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;
}
