import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerTodoCoches {
    private static final Logger LOGGER = Logger.getLogger(LoggerTodoCoches.class.getName());
    public static void configurarLogger(){
        try {
            FileHandler fileHandler = new FileHandler("logUsuario.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void logInicioSesion(Usuario user){
        LOGGER.info("El usuario: "+user.getNombre()+" con dni "+user.getDni()+" ha iniciado sesion");
    }
    public static void logCreacionUsuario(Usuario user) {
        LOGGER.info("El usuario: "+user.getNombre()+" con dni "+user.getDni()+" se ha registrado");
    }
    public static void logVenta(Venta ven, Usuario user) {
         LOGGER.info("El usuario: "+ven.getU()+" con dni "+user.getDni()+" ha comprado el coche "+ven.getC()+" por un total de "+ven.getDinero()+" euros");
    }

}