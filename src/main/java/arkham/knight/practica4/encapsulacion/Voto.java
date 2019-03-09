package arkham.knight.practica4.encapsulacion;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Voto implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String voto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    private Articulo articulo;

    public Voto() {

    }

    public Voto(String voto, Usuario usuario, Articulo articulo) {
        this.voto = voto;
        this.usuario = usuario;
        this.articulo = articulo;
    }

    public Voto(long id, String voto, Usuario usuario, Articulo articulo) {
        this.id = id;
        this.voto = voto;
        this.usuario = usuario;
        this.articulo = articulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
