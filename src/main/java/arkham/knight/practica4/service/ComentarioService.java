package arkham.knight.practica4.service;

import java.util.List;

import arkham.knight.practica4.encapsulacion.Comentario;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ComentarioService extends DataBaseService<Comentario> {
    private static ComentarioService instancia;

    private ComentarioService() {
        super(Comentario.class);
    }

    public static ComentarioService getInstancia() {
        if (instancia == null) {
            instancia = new ComentarioService();
        }
        return instancia;
    }

    public List<Comentario> encontrarComentario(long articuloID) {
        EntityManager em = getEntityManager();

        try {
            Query query = em.createQuery(
                    "from Comentario comentario where comentario.articulo.id = :comentario_articuloID order by id asc"
            );
            query.setParameter("comentario_articuloID", articuloID);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
