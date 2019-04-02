package br.com.rdocampos.biblioteca.model.enums;

public enum StatusEmprestimo {

    D("Disponível"), E("Emprestado"), N("Danificado");

    private final String statusEmprestimo;

    private StatusEmprestimo(String statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

    public String getValor() {
        return this.toString();
    }

    public String getDescricao() {
        return statusEmprestimo;
    }

    public static StatusEmprestimo[] getValores() {
        return values();
    }
}