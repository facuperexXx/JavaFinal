package models;

public class Articulo {
    private int codigo;
    private String nombre;
    private int precio;
    private int stock;

    public Articulo() {}

    public Articulo(String nombre, int precio, int stock) {
        this.stock = stock;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Articulo(int codigo, String nombre, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // GETTERS
    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return stock;
    }

    public int getCodigo() {
        return codigo;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Articulo [ " + codigo + " - " + nombre + " - Precio: $" + precio + " - Stock: " + stock + " ]";
    }
}
