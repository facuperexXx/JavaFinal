package builders;

import contenedores.BaseContenedor;
import contenedores.UsuarioContenedor;
import models.Usuario;

public class UsuarioBuilder {
    private int id;
    private String nombre;
    private String user;
    private String pass;
    private int perfil;

    private BaseContenedor<Usuario> data;

    public UsuarioBuilder() {
        data = UsuarioContenedor.getInstance();
    }

    public UsuarioBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder setUser(String user) {
        this.user = user;
        return this;
    }

    public UsuarioBuilder setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public UsuarioBuilder setPerfil(int perfil) {
        this.perfil = perfil;
        return this;
    }

    public Usuario build() {
        this.id = (data.allRegistros().size()) + 1;
        return new Usuario(id, nombre, user, pass, perfil);
    }
}
