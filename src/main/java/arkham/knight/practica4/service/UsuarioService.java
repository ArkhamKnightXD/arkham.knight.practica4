package arkham.knight.practica4.service;

import arkham.knight.practica4.encapsulacion.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioService extends DataBaseService<Usuario>{
    private static UsuarioService instancia;

    private UsuarioService() {
        super(Usuario.class);
    }

    public static UsuarioService getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioService();
        }
        return instancia;
    }

    public Object encontrarUsuarioSesion(String sesion) {
        EntityManager em = getEntityManager();

        try {
            Query query = em.createQuery("from Usuario user where user.sesion = :user_sesion");
            query.setParameter("user_sesion", sesion);
            return query.getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public Object encontrarUsuario(String username, String password) {
        EntityManager em = getEntityManager();

        try {
            Query query = em.createQuery("from Usuario user where user.username = :user_username and user.password = :user_password");
            query.setParameter("user_username", username);
            query.setParameter("user_password", password);
            return query.getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

}
