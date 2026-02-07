package contenedores;

import data.UsuarioData;
import models.Usuario;

public class UsuarioContenedor extends BaseContenedor<Usuario> {

    private static UsuarioContenedor singleton;

    private UsuarioContenedor() {
        listado = UsuarioData.cargaUsuarios();
    }

    public static UsuarioContenedor getInstance() {
        if (singleton == null) return new UsuarioContenedor();
        else return singleton;
    }

    @Override
    protected int datoClave(Usuario ref) {
        return ref.getId();
    }

    @Override
    protected void modificarRegistro(Usuario registro, Usuario datosNuevos) {
        if(datosNuevos.getNombre() != null) registro.setNombre(datosNuevos.getNombre());
        if(datosNuevos.getUser() != null) registro.setUser(datosNuevos.getUser());
        if(datosNuevos.getPass() != null) registro.setPass(datosNuevos.getPass());
        if(datosNuevos.getPerfil() != null) registro.setPerfil(datosNuevos.getPerfil());
    }
}
