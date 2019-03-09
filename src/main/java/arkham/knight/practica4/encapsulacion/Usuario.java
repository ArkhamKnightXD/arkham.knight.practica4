package arkham.knight.practica4.encapsulacion;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {
    @Id
    private Long id;
    private String nombre;
    private String username;
    private String password;
    private boolean administrator;
    private boolean autor;
    private String sesion;

    public Usuario() {

    }

    public Usuario(String nombre, String username, String password, boolean administrator, boolean autor, String sesion) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.administrator = administrator;
        this.autor = autor;
        this.sesion = sesion;
    }

    public Usuario(Long id, String nombre, String username, String password, boolean administrator, boolean autor, String sesion) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.administrator = administrator;
        this.autor = autor;
        this.sesion = sesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isAdminstrator() {
        return administrator;
    }

    public void setAdminstrator(boolean adminstrator) {
        this.administrator = adminstrator;
    }

    public boolean isAutor() {
        return autor;
    }

    public void setAutor(boolean autor) {
        this.autor = autor;
    }
}
