package servicios;

import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;

import java.util.HashMap;

public class AutenticacionServicio implements Servicio<Peticion, Respuesta> {

    @Override
    public Respuesta ejecutar(Peticion peticion) {
        switch (peticion.getAccion()) {
            case "login": return this.autenticar(peticion.getParametros());
            case "logout": return this.cerrarSesion();

            default: throw new RuntimeException("Accion no disponible");
        }
    }

    private Respuesta cerrarSesion() {
        System.out.println("Cerrar sesion");
        return null;
    }

    private Respuesta autenticar(HashMap<String, String> parametros) {
        System.out.println("Autenticar");
        return null;
    }
}
