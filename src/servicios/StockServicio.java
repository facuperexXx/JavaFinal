package servicios;

import contenedores.BaseContenedor;
import contenedores.StockContenedor;
import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;
import models.Articulo;

import java.util.ArrayList;
import java.util.List;

public class StockServicio implements Servicio<Peticion, Respuesta> {
    private BaseContenedor<Articulo> dataStock;

    public StockServicio() {
        dataStock = StockContenedor.getInstance();
    }

    @Override
    public Respuesta ejecutar(Peticion peticion) {
        switch (peticion.getAccion()) {
            case "todos": return this.todoStock();
            case "agregar": return null;
            case "eliminar": return null;
            case "definirStock": return null;
            case "buscarXid": return null;
            case "buscarXnombre": return null;

            default: throw new RuntimeException("Accion no disponible");
        }
    }

    private Respuesta todoStock() {
        String accion = "ver todos el stock disponible";
        String estado = "Ok";
        String mensaje = "";

        for(Articulo a : dataStock.allRegistros()) {
            mensaje += "\n" + a.toString();
        }

        return new Respuesta(accion, estado, mensaje);
    }
}
