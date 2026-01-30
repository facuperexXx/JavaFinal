package models;

public class Usuario {
    private int id;
    private String nombre;
    private String user;
    private String pass;
    private String perfil = "Cliente";

    public Usuario() { }

    public Usuario(int id, String nombre, String user, String pass, int perfil) {
        this.id = id;
        this.nombre = nombre;
        this.user = user;
        this.pass = pass;

        if(perfil == 1) this.perfil = "Empleado";
    }

    // GETTERS
    public String getPerfil() {
        return perfil;
    }

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    // SETTERS
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario [ " + id + " - " + nombre + " - Usuario: " + user + " - Pass: " + pass + " - Perfil: " + perfil + " ] ";
    }
}
