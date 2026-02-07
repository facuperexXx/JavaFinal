package builders;

import contenedores.BaseContenedor;
import contenedores.StockContenedor;
import models.Articulo;

public class ArticuloBuilder {
    private int id;
    private String nombre;
    private int precio;

    private BaseContenedor<Articulo> data;

    public ArticuloBuilder() {
        data = StockContenedor.getInstance();
    }

    public ArticuloBuilder setPrecio(int precio) {
        this.precio = precio;
        return this;
    }

    public ArticuloBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Articulo build() {
        this.id = (data.allRegistros().size()) + 1;
        return new Articulo(id, nombre, precio);
    }
}
