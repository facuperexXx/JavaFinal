package app;

import dto.Peticion;
import interfaces.BaseParser;
import interfaces.Servicio;
import parseadores.PeticionParser;

public class Aplicacion {
    private ServiceLocator servicios;
    private BaseParser<Peticion> lector;

    public Aplicacion(ServiceLocator servicios) {
        this.servicios = servicios;
        this.lector = new PeticionParser();
    }

    public void iniciar() {

        Peticion op = lector.leerCadena("usuarios login user=facu,pass=1234");

        Servicio servicio = servicios.buscarServicio(op.getServicio());

        servicio.ejecutar(op);
    }
}
