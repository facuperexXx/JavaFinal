import app.Aplicacion;
import app.ServiceLocator;
import servicios.UsuarioServicio;

public class inicio {
    public static void main(String[] args) {

        ServiceLocator servicios = new ServiceLocator();
        servicios.registrarServicio("usuarios", new UsuarioServicio());

        Aplicacion app = new Aplicacion(servicios);
        app.iniciar();
    }
}
