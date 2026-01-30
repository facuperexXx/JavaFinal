package dto;

public class Respuesta {
    private String accion;
    private String estado;
    private String mensaje;

    public Respuesta(String accion, String estado, String mensaje) {
        this.accion = accion;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public String getAccion() {
        return accion;
    }

    public String getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Pedido: " + accion +
                "\nEstado: " + estado +
                "\nMensaje: " + mensaje;
    }
}
