package arkham.knight.practica4.encapsulacion;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Etiqueta implements Serializable {

    @Id
    private long id;
    private String etiqueta;


    public Etiqueta(long id, String etiqueta) {
        this.id = id;
        this.etiqueta = etiqueta;
    }

    public Etiqueta() {
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

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

}
