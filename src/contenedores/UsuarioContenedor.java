package contenedores;

import data.UsuarioData;
import models.Usuario;

public class UsuarioContenedor extends BaseContenedor<Usuario> {

    public UsuarioContenedor() {
        listado = UsuarioData.cargaUsuarios();
    }

    @Override
    protected int datoClave(Usuario ref) {
        return ref.getId();
    }

    @Override
    protected void modificarRegistro(Usuario registro, Usuario datosNuevos) {
        registro.setNombre(datosNuevos.getNombre());
        registro.setUser(datosNuevos.getUser());
        registro.setPass(datosNuevos.getPass());
        registro.setPerfil(datosNuevos.getPerfil());
    }


}
