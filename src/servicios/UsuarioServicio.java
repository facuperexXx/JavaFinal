package servicios;

import contenedores.BaseContenedor;
import contenedores.UsuarioContenedor;
import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;
import models.Usuario;

import java.util.HashMap;
import java.util.List;

public class UsuarioServicio implements Servicio<Peticion, Respuesta> {

    private BaseContenedor<Usuario> data;

    public UsuarioServicio() {
        data = UsuarioContenedor.getInstance();
    }

    @Override
    public Respuesta ejecutar(Peticion peticion) {
        switch (peticion.getAccion()) {
            case "buscar": return this.buscarPorId(peticion.getParametros());

            default: throw new RuntimeException("Accion no disponible");
        }
    }

    private Respuesta buscarPorId(HashMap<String, String> parametros) {
        String accion = "Busqueda de registro por id";
        int idBuscado = Integer.parseInt(parametros.get("id"));

        Usuario buscado = data.buscar(idBuscado);


        String estado = "Ok";
        String mensaje = buscado.toString();

        return new Respuesta(accion, estado, mensaje);
    }
}
