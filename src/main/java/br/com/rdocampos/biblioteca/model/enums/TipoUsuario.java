package br.com.rdocampos.biblioteca.model.enums;

public enum TipoUsuario {
    A("Admin"), U("User");

    private final String tipoUsuario;

    private TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getValor() {
        return this.toString();
    }

    public String getDescricao() {
        return tipoUsuario;
    }

    public static TipoUsuario[] getValores() {
        return values();
    }


}
