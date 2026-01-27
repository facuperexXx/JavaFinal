package builders;

import dto.Peticion;

import java.util.HashMap;

public class PeticionBuilder {
    private String servicio;
    private String accion;
    private HashMap<String, String> parametros;

    public PeticionBuilder() {
        parametros = new HashMap<>();
    }

    public PeticionBuilder setServicio(String servicio) {
        this.servicio = servicio;
        return this;
    }

    public PeticionBuilder setAccion(String accion) {
        this.accion = accion;
        return this;
    }

    public PeticionBuilder setParametro(String clave, String valor) {
        parametros.put(clave, valor);
        return this;
    }

    public Peticion build() {
        return new Peticion(servicio, accion, parametros);
    }

}
