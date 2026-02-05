package data;

import models.Articulo;

import java.util.ArrayList;
import java.util.List;

public class StockData {
    public static List<Articulo> cargarArticulos() {
        Articulo a1 = new Articulo("AD23", "Oreo", 5, 4);
        Articulo a2 = new Articulo("YX43", "Kiwi", 9, 2);
        Articulo a3 = new Articulo("IC87", "Fideos", 3, 6);
        Articulo a4 = new Articulo("OE92", "Guiso", 7, 3);

        List<Articulo> listado = new ArrayList<>();

        listado.add(a1);
        listado.add(a2);
        listado.add(a3);
        listado.add(a4);

        return listado;
    }
}
