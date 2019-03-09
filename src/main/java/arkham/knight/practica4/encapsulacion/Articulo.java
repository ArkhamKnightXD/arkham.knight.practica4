package arkham.knight.practica4.encapsulacion;


import java.util.Date;
import java.util.List;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Articulo implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String titulo;

    @Column(name = "cuerpo", columnDefinition = "TEXT")
    private String cuerpo;

    @OneToOne
    private Usuario autor;

    private Date fecha;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Comentario> listaComentarios;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Etiqueta> listaEtiquetas;

    @Transient
    private String pagina;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Voto> votos;

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public Set<Voto> getVotos() {
        return votos;
    }

    public void setVotos(Set<Voto> votos) {
        this.votos = votos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public Set<Etiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public void setListaEtiquetas(Set<Etiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }

    public String getCuerpoCorto() {
        String cuerpoCorto = "";

        for (int i = 0; i < 70; i++) {
            if (i >= this.getCuerpo().length())
                break;

            cuerpoCorto += this.getCuerpo().charAt(i);
        }

        return cuerpoCorto;
    }

    public Articulo() {

    }

    public Articulo(String titulo, String cuerpo, Usuario autor, Date fecha, List<Comentario> listaComentarios, Set<Etiqueta> listaEtiquetas, String pagina, Set<Voto> votos) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
        this.listaComentarios = listaComentarios;
        this.listaEtiquetas = listaEtiquetas;
        this.pagina = pagina;
        this.votos = votos;
    }
}
