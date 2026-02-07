package app;

import dto.Peticion;
import dto.Respuesta;
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

        Peticion op = lector.leerCadena("stock agregar nombre=bajonero,precio=8");

        Servicio servicio = servicios.buscarServicio(op.getServicio());

        Respuesta resultado = (Respuesta) servicio.ejecutar(op);

        System.out.println(resultado.toString());
    }
}
