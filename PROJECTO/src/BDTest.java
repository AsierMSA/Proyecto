import static org.junit.Assert.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

public class BDTest {
    @Test
    public void testInitBD() {
        Connection con = BD.initBD("testDB", true);
        assertNotNull(con);
        assertNotNull(BD.mapaVentas);
        assertNotNull(BD.mapaCompras);
        assertNotNull(BD.precios);
    }

    @Test
    public void testCloseBD() {
        Connection con = BD.initBD("testDB", true);
        BD.closeBD(con);
        assertNull(con);
    }

    @Test
    public void testCrearTablas() {
        Connection con = BD.initBD("testDB", true);
        BD.crearTablas(con);
        assertTrue(con);
    }

    @Test
    public void testInsertarCoche() {
        Connection con = BD.initBD("testDB", true);
        BD.crearTablas(con);
        BD.insertarCoche(con, "modelo", "marca", 4, 10000, 2020, 150, "foto");
        assertTrue(con);
    }
    @Test
    public void testRellenarTablas() {
        Connection con = BD.initBD("testDB", true);
        BD.crearTablas(con);
        BD.rellenarTablas(con);
        assertTrue(con);
    }
    
   

    
    
}
