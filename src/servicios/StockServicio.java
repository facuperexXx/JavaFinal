package servicios;

import contenedores.BaseContenedor;
import contenedores.StockContenedor;
import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;
import models.Articulo;

import java.util.ArrayList;
import java.util.HashMap;
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
            case "eliminar": return this.eliminarStock(peticion.getParametros());
            case "stockear": return this.stockear(peticion.getParametros());
            case "buscarXid": return this.buscarXid(peticion.getParametros());
            case "buscarXnombre": return this.buscarXnombre(peticion.getParametros());

            default: throw new RuntimeException("Accion no disponible");
        }
    }

    private Respuesta stockear(HashMap<String, String> parametros) {
        String accion = "Actualizar stock";
        String estado = "Ok";

        int id = Integer.parseInt(parametros.get("id"));
        int stock = Integer.parseInt(parametros.get("stock"));

        Articulo articuloBuscado = dataStock.buscar(id);

        articuloBuscado.setCantidad(stock);

        String mensaje = articuloBuscado.toString();

        return new Respuesta(accion, estado, mensaje);
    }

    private Respuesta buscarXnombre(HashMap<String, String> parametros) {
        String accion = "Buscar por nombre";
        String estado = "Ok";
        String mensaje = "";

        String nombreBuscado = parametros.get("nombre");
        List<Articulo> listado = dataStock.allRegistros();

        Articulo artBuscado;

        for(Articulo a : listado) {
            if(a.getNombre().equalsIgnoreCase(nombreBuscado)) {
                artBuscado = a;
                mensaje = a.toString();
            }
            break;
        }

        return new Respuesta(accion, estado, mensaje);
    }

    private Respuesta buscarXid(HashMap<String, String> parametros) {
        String accion = "Buscar por id";
        String estado = "Ok";

        int idBuscado = Integer.parseInt(parametros.get("id"));
        Articulo artBuscado = dataStock.buscar(idBuscado);

        String mensaje = artBuscado.toString();

        return new Respuesta(accion, estado, mensaje);
    }

    private Respuesta eliminarStock(HashMap<String, String> parametros) {
        String accion = "Eliminar stock";

        int idBuscado = Integer.parseInt(parametros.get("id"));

        dataStock.eliminar(idBuscado);

        String estado = "Ok";
        String mensaje = "";

        List<Articulo> listado = dataStock.allRegistros();
        for(Articulo a : listado) {
            mensaje += "\n" + a.toString();
        }

        return new Respuesta(accion, estado, mensaje);
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
