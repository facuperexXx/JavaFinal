package dto;

import java.util.HashMap;

public class Peticion {
    private String servicio;
    private String accion;
    private HashMap<String, String> parametros;

    public Peticion(String servicio, String accion, HashMap<String, String> params) {
        this.servicio = servicio;
        this.accion = accion;
        this.parametros = params;
    }

    public HashMap<String, String> getParametros() {
        return parametros;
    }

    public String getServicio() {
        return servicio;
    }

    public String getAccion() {
        return accion;
    }
}
