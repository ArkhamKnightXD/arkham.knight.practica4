package arkham.knight.practica4.encapsulacion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Etiqueta implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String etiqueta;

    public Etiqueta() {

    }

    public Etiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Etiqueta(long id, String etiqueta) {
        this.id = id;
        this.etiqueta = etiqueta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}
