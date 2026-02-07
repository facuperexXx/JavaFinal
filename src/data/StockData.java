package data;

import models.Articulo;

import java.util.ArrayList;
import java.util.List;

public class StockData {
    public static List<Articulo> cargarArticulos() {
        Articulo a1 = new Articulo(1, "Oreo", 5);
        Articulo a2 = new Articulo(2, "Kiwi", 9);
        Articulo a3 = new Articulo(3, "Fideos", 3);
        Articulo a4 = new Articulo(4, "Guiso", 7);

        a1.setCantidad(4);
        a2.setCantidad(6);
        a3.setCantidad(3);
        a4.setCantidad(9);

        List<Articulo> listado = new ArrayList<>();

        listado.add(a1);
        listado.add(a2);
        listado.add(a3);
        listado.add(a4);

        return listado;
    }
}
