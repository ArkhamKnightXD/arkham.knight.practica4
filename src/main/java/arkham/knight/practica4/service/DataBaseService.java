package arkham.knight.practica3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseService {

    public static DataBaseService instancia;
    private String URL = "jdbc:h2:tcp://localhost/~/arkhamknightXD"; //Modo Server...

    /**
     *Implementando el patron Singleton
     */
    public DataBaseService(){
        registrarDriver();
    }

    /**
     * Retornando la instancia.
     * @return
     */
    public static DataBaseService getInstancia(){
        if(instancia==null){
            instancia = new DataBaseService();
        }
        return instancia;
    }

    /**
     * Metodo para el registro de driver de conexión.
     */
    private void registrarDriver() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        Connection conexion= null;
        try {
            conexion = DriverManager.getConnection(URL, "sa", "");
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public void testConexion() {
        try {
            getConexion().close();
            System.out.println("Conexion exitosa...");
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
