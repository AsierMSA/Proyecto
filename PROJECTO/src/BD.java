import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BD {
	
	/**
	 * MÃ©todo que realiza la conexiÃ³n con la base de datos
	 * @param nombreBD : Nombre de la base de datos a la que nos vamos a conectar
	 * @return Devuelve la conexiÃ³n a la base de datos
	 */
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void crearTablas(Connection con) {
		String sql1 = "CREATE TABLE IF NOT EXISTS Usuario (dni String, nom String, con String, fechaNacimiento String, ciudad String)";
		String sql2 = "CREATE TABLE IF NOT EXISTS Coche (marca String, modelo String, puertas Integer, kms Integer, anio Integer, potencia Integer)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void insertarCoche(Connection con, String modelo, String marca, int puertas, int kilometros, int potencia, String foto) {
		String sql = "INSERT INTO Coche VALUES('"+modelo+"','"+marca+"','"+puertas+"','"+kilometros+"','"+potencia+"','"+foto+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void UsuarioRegular(Connection con, String dni, String fechaNacimiento, String nombre, String contraseña, String ciudad) {
		String sql = "INSERT INTO Usuario VALUES('"+dni+"','"+fechaNacimineto+"','"+nombre+"','"+contraseña+"','"+ciudad+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
	
	