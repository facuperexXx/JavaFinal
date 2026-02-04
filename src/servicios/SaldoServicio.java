package servicios;

import contenedores.BaseContenedor;
import contenedores.UsuarioContenedor;
import dto.Peticion;
import dto.Respuesta;
import interfaces.Servicio;
import models.Usuario;

import java.util.HashMap;

public class SaldoServicio implements Servicio<Peticion, Respuesta> {

    private BaseContenedor<Usuario> dataUsuario;

    public SaldoServicio() {
        dataUsuario = UsuarioContenedor.getInstance();
    }

    @Override
    public Respuesta ejecutar(Peticion peticion) {
        switch (peticion.getAccion()) {
            case "aum": return aumentarSaldo(peticion.getParametros());
            case "red": return null;
            case "trans": return null;

            default: throw new RuntimeException("Accion no disponible");
        }
    }

    private Respuesta aumentarSaldo(HashMap<String, String> parametros) {
        String accion = "Aumentar sueldo";

        int id = Integer.parseInt(parametros.get("id"));
        int monto = Integer.parseInt(parametros.get("monto"));

        Usuario usuarioBuscado = dataUsuario.buscar(id);
        usuarioBuscado.setSaldo(usuarioBuscado.getSaldo() + monto);

        String estado = "Ok";

        String mensaje = usuarioBuscado.toString();

        return new Respuesta(accion, estado, mensaje);
    }
}
