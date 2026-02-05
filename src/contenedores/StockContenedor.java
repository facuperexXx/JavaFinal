package contenedores;

import data.StockData;
import models.Articulo;

public class StockContenedor extends BaseContenedor<Articulo>{

    private static StockContenedor singleton;

    private StockContenedor() {
        listado = StockData.cargarArticulos();
    }

    public static StockContenedor getInstance() {
        if(singleton == null) return new StockContenedor();
        else return singleton;
    }

    @Override
    protected int datoClave(Articulo ref) {
        return ref.getCodigo();
    }

    @Override
    protected void modificarRegistro(Articulo registro, Articulo datosNuevos) {
        if(datosNuevos.getNombre() != null) registro.setNombre(datosNuevos.getNombre());
        if(datosNuevos.getCantidad() != 0) registro.setCantidad(datosNuevos.getCantidad());
        if(datosNuevos.getPrecio() != 0) registro.setPrecio(datosNuevos.getPrecio());
    }
}
