package arkham.knight.practica3.encapsulacion;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Articulo {

    private long id;
    private String titulo;
    private String cuerpo;
    private Date fecha;
    private Usuario autor;
    private List<Comentario> listaComentarios;
    private List<Etiqueta> listaEtiquetas;

    public Articulo(long id, String titulo, String cuerpo, Usuario autor, Date fecha, ArrayList<Comentario> listaComentarios, ArrayList<Etiqueta> listaEtiquetas) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
        this.listaComentarios = listaComentarios;
        this.listaEtiquetas = listaEtiquetas;
    }

    public Articulo() {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public List<Etiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public void setListaEtiquetas(List<Etiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }


    public String getCuerpoCorto() {
        String cuerpoCorto = "";

        for(int i = 0; i < 70; i++) {
            if(i >= this.getCuerpo().length())
                break;

            cuerpoCorto += this.getCuerpo().charAt(i);
        }

        return cuerpoCorto;
    }

}
