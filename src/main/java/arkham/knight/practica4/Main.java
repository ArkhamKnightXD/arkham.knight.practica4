package arkham.knight.practica4;
import arkham.knight.practica4.path.Ruta;
import arkham.knight.practica4.service.BootStrapService;
import arkham.knight.practica4.service.DataBaseService;
import arkham.knight.practica4.service.UsuarioService;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            // Iniciando el servicio de Base de datos
            BootStrapService.startDb();

            // Prueba de conexión
            DataBaseService.getInstancia().testConexion();

            // Creando tablas de la Base de datos
            BootStrapService.crearTablas();

            // Creando el usario base
            UsuarioService serviciousuario = new UsuarioService();
            serviciousuario.crearUsuarioPorDefecto();

            Ruta.crearRutas();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


