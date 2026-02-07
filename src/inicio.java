import app.Aplicacion;
import app.ServiceLocator;
import contenedores.BaseContenedor;
import contenedores.StockContenedor;
import data.StockData;
import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;
import models.Articulo;
import models.Item;
import servicios.AutenticacionServicio;
import servicios.SaldoServicio;
import servicios.StockServicio;
import servicios.UsuarioServicio;

import java.util.List;

public class inicio {
    public static void main(String[] args) {

        ServiceLocator servicios = new ServiceLocator();
        servicios.registrarServicio("auth", new AutenticacionServicio());
        servicios.registrarServicio("usuario" , new UsuarioServicio());
        servicios.registrarServicio("saldo", new SaldoServicio());
        servicios.registrarServicio("stock", new StockServicio());

        Aplicacion app = new Aplicacion(servicios);
        app.iniciar();
    }
}
