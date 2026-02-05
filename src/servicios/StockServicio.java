package servicios;

import contenedores.BaseContenedor;
import contenedores.StockContenedor;
import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;
import models.Articulo;

public class StockServicio implements Servicio<Peticion, Respuesta> {
    private BaseContenedor<Articulo> dataStock;

    public StockServicio() {
        dataStock = StockContenedor.getInstance();
    }

    @Override
    public Respuesta ejecutar(Peticion peticion) {
        return null;
    }
}
