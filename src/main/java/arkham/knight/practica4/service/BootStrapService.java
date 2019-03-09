package arkham.knight.practica4.service;

import org.h2.tools.Server;
import java.sql.SQLException;

public class BootStrapService {
    private static BootStrapService instancia;

    public static BootStrapService getInstancia() {
        if (instancia == null) {
            instancia = new BootStrapService();
        }
        return instancia;
    }

    /**
     * Iniciar la base de datos
     *
     * @throws SQLException
     */
    public static void startDB() throws SQLException {
        Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
    }

    /**
     * Para detener la base de datos
     *
     * @throws SQLException
     */
    public static void stopDB() throws SQLException {
        Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
    }
}
