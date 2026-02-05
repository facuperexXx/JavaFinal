package contenedores;

import models.Articulo;

public class StockContenedor extends BaseContenedor<Articulo>{

    private static StockContenedor singleton;

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
        registro.setNombre(datosNuevos.getNombre());
        registro.setCantidad(datosNuevos.getCantidad());
        registro.setPrecio(datosNuevos.getPrecio());
    }
}
