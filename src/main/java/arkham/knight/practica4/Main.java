package arkham.knight.practica4;
import arkham.knight.practica4.encapsulacion.Usuario;
import arkham.knight.practica4.path.Ruta;
import arkham.knight.practica4.service.BootStrapService;
import arkham.knight.practica4.service.DataBaseService;
import arkham.knight.practica4.service.UsuarioService;

public class Main {
    public static void main(String[] args) {
        // Iniciando el servicio de Base de datos por medio de Hibernate y H2.
        try {
            BootStrapService.getInstancia().startDB();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insertando el usuario por defecto (administrador).
        if (UsuarioService.getInstancia().find(new Long(1)) == null) {
            UsuarioService.getInstancia().crear(new Usuario(new Long(1), "Administrador", "admin", "1234", true, true, null));
        }

        // Creando las rutas.
        Ruta.crearRutas();
    }
}


