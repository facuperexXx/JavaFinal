package models;

public class Item {
    private Articulo art;
    private int cantidad;

    public Item() {}

    public Item(Articulo art, int cantidad) {
        this.art = art;
        this.cantidad = cantidad;
    }

    // GETTERS
    public Articulo getArt() {
        return art;
    }

    public int getCantidad() {
        return cantidad;
    }

    // SETTERS

    public void setArt(Articulo art) {
        this.art = art;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int obtenerSubtotal() {
        return cantidad * art.getPrecio();
    }

    @Override
    public String toString() {
        return "Item [ " + art.getCodigo() + " - " + art.getNombre() + " - Precio x unidad: " + art.getPrecio() +
                " - Cantidad: " + art.getCantidad() + " - Subtotal: " + obtenerSubtotal() + " ] ";
    }
}
