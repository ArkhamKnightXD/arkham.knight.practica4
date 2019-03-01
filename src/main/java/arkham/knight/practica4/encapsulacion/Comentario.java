package arkham.knight.practica4.encapsulacion;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comentario implements Serializable {

    @Id
    private long id;
    private String comentario;
    private Usuario autor;
    private Articulo articulo;

    public Comentario(long id, String comentario, Usuario autor, Articulo articulo) {
        this.id = id;
        this.comentario = comentario;
        this.autor = autor;
        this.articulo = articulo;
    }

    public Comentario() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
