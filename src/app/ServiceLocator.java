package app;

import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;

import java.util.HashMap;

public class ServiceLocator {
    private HashMap<String, Servicio> listadoServicios;

    public ServiceLocator() {
        listadoServicios = new HashMap<>();
    }

    public void registrarServicio(String clave, Servicio<Peticion, Respuesta> servicio) {
        listadoServicios.put(clave, servicio);
    }

    public Servicio buscarServicio(String buscado) {
        Servicio encontrado = listadoServicios.get(buscado);
        return encontrado;
    }
}
