package arkham.knight.practica4.encapsulacion;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Valoracion implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String valoracion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    private Comentario comentario;

    public Valoracion() {

    }

    public Valoracion(String valoracion, Usuario usuario, Comentario comentario) {
        this.valoracion = valoracion;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}

