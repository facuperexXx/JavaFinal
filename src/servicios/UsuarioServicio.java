package servicios;

import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;

import java.util.HashMap;

public class UsuariosServicio implements Servicio<Peticion, Respuesta> {

    @Override
    public Respuesta ejecutar(Peticion peticion) {
        switch (peticion.getAccion()) {
            case "login": return this.loguearse(peticion.getParametros());

            default: throw new RuntimeException("Accion no disponible");
        }
    }

    private Respuesta loguearse(HashMap<String, String> parametros) {
        
        System.out.println("Servicio usuarios");
        return new Respuesta();
    }


}
