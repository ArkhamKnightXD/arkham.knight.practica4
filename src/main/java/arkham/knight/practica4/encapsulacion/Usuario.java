package arkham.knight.practica3.encapsulacion;

public class Usuario {
    private long id;
    private String username;
    private String password;
    private boolean administrador;
    private boolean autor;

    public Usuario(long id, String username, String password, boolean administrador, boolean autor) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.administrador = administrador;
        this.autor = autor;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        String mensaje="El username del usuario es: "+username;
        return mensaje;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isAutor() {
        return autor;
    }

    public void setAutor(boolean autor) {
        this.autor = autor;
    }


}
