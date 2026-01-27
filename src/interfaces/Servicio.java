package interfaces;

public interface Servicio<T, R> {
    public R ejecutar(T peticion);
}
