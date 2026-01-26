package contenedores;

import java.util.List;

public abstract class BaseContenedor<T> {

    /*
    Clase molde para contenedores
        - Obtener todos los registros
        - Agregar un elemento
        - Buscar por id
        - Eliminar por id
        - Modificar por id
        - Verificar existencia usando id
     */

    protected List<T> listado;

    protected abstract int datoClave(T ref);
    protected abstract void modificarRegistro(T registro, T datosNuevos);

    public List<T> allRegistros() {
        return this.listado;
    }

    public void agregar(T item) {
        if(verificarExistencia(datoClave(item)) != null) {
            listado.add(item);
        }
    }

    public T buscar(int clave) {
        T buscado = null;
        for(T e : listado) {
            if(datoClave(e) == clave) {
                buscado = e;
            }
        }
        return buscado;
    }

    public void eliminar(int clave) {
        T registro = buscar(clave);
        listado.remove(registro);
    }

    public T modificar(int clave, T datosNuevos) {
        if(verificarExistencia(clave) != null) {
            T registro = buscar(clave);

            modificarRegistro(registro, datosNuevos);
        }

        return buscar(clave);
    }

    public T verificarExistencia(int clave) {
        T registro = null;
        if (buscar(clave) != null) registro = buscar(clave);

        return registro;
    }
}
