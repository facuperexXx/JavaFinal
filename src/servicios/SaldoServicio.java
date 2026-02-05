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
            case "red": return disminuirSaldo(peticion.getParametros());
            case "transf": return transferirSaldo(peticion.getParametros());

            default: throw new RuntimeException("Accion no disponible");
        }
    }

    private Respuesta transferirSaldo(HashMap<String, String> parametros) {
        String accion = "Transferencia de saldo";

        int idOrigen = Integer.parseInt(parametros.get("idOrigen"));
        int idDestino = Integer.parseInt(parametros.get("idDestino"));
        int monto = Integer.parseInt(parametros.get("monto"));

        Usuario usOrigen = dataUsuario.buscar(idOrigen);
        Usuario usDestino = dataUsuario.buscar(idDestino);

        String estado = "";
        String mensaje = "";

        if(usOrigen.getSaldo() < monto) {
            estado = "Advertencia";
            mensaje = "Saldo no disponible para la operacion";
        } else {
            usDestino.setSaldo(usDestino.getSaldo() + monto);
            usOrigen.setSaldo(usOrigen.getSaldo() - monto);

            estado = "Ok";
            mensaje = usDestino.toString();
        }

        return new Respuesta(accion, estado, mensaje);
    }

    private Respuesta disminuirSaldo(HashMap<String, String> parametros) {
        String accion = "Reducir sueldo";

        int id = Integer.parseInt(parametros.get("id"));
        int monto = Integer.parseInt(parametros.get("monto"));

        Usuario usuarioBuscado = dataUsuario.buscar(id);

        if(usuarioBuscado.getSaldo() > monto) usuarioBuscado.setSaldo(usuarioBuscado.getSaldo() - monto);
        else usuarioBuscado.setSaldo(0);

        String estado = "Ok";

        String mensaje = usuarioBuscado.toString();

        return new Respuesta(accion, estado, mensaje);
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
