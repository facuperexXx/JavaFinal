package data;

import models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioData {

    public static List<Usuario> cargaUsuarios() {
        Usuario u1 = new Usuario(1, "Facundo Perez", "facu", "123", 1);
        Usuario u2 = new Usuario(2, "Maximo Perez",  "maxi", "123", 2);

        List<Usuario> lista = new ArrayList<>();

        lista.add(u1);
        lista.add(u2);

        return lista;
    }
}
