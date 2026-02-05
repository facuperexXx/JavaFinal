package models;

public class Articulo {
    private int codigo;
    private String nombre;
    private int precio;
    private int stock;

    public Articulo() {}

    public Articulo(int codigo, String nombre, int precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Articulo [ " + codigo + " - " + nombre + " - Precio: $" + precio + " - Stock: " + stock + " ]";
    }
}
