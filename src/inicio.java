import app.Aplicacion;
import app.ServiceLocator;
import servicios.AutenticacionServicio;
import servicios.UsuarioServicio;

public class inicio {
    public static void main(String[] args) {

        ServiceLocator servicios = new ServiceLocator();
        servicios.registrarServicio("auth", new AutenticacionServicio());

        Aplicacion app = new Aplicacion(servicios);
        app.iniciar();
    }
}
