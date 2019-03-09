package arkham.knight.practica4.encapsulacion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Comentario implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Articulo articulo;

    @OneToMany(mappedBy = "comentario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Valoracion> valoraciones;

    @Transient
    private List<Valoracion> meGusta;

    @Transient
    private List<Valoracion> meEncanta;

    @Transient
    private List<Valoracion> meh;

    @Transient
    private List<Valoracion> meDisgusta;

    @Transient
    private List<Valoracion> meIndigna;


    public Comentario() {

    }

    public Comentario(String comentario, Usuario autor, Articulo articulo, Set<Valoracion> valoraciones) {
        this.comentario = comentario;
        this.autor = autor;
        this.articulo = articulo;
        this.valoraciones = valoraciones;
    }

    public long getCantidadMeGusta() {
        return this.meGusta == null ? 0 : this.meGusta.size();
    }

    public long getCantidadMeEncanta() {
        return this.meEncanta == null ? 0 : this.meEncanta.size();
    }

    public long getCantidadMeh() {
        return this.meh == null ? 0 : this.meh.size();
    }

    public long getCantidadMeDisgusta() {
        return this.meDisgusta == null ? 0 : this.meDisgusta.size();
    }

    public long getCantidadMeIndigna() {
        return this.meIndigna == null ? 0 : this.meIndigna.size();
    }

    public List<Valoracion> getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(List<Valoracion> meGusta) {
        this.meGusta = meGusta;
    }

    public List<Valoracion> getMeEncanta() {
        return meEncanta;
    }

    public void setMeEncanta(List<Valoracion> meEncanta) {
        this.meEncanta = meEncanta;
    }

    public List<Valoracion> getMeh() {
        return meh;
    }

    public void setMeh(List<Valoracion> meh) {
        this.meh = meh;
    }

    public List<Valoracion> getMeDisgusta() {
        return meDisgusta;
    }

    public void setMeDisgusta(List<Valoracion> meDisgusta) {
        this.meDisgusta = meDisgusta;
    }

    public List<Valoracion> getMeIndigna() {
        return meIndigna;
    }

    public void setMeIndigna(List<Valoracion> meIndigna) {
        this.meIndigna = meIndigna;
    }

    public Set<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(Set<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
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
}
