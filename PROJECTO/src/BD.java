import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BD {
	final Logger LOG = Logger.getLogger("paquete.NombreClase");
	static HashMap<String,ArrayList<Coche>> mapaVentas;
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
			mapaVentas=new HashMap<String,ArrayList<Coche>>();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Logger.getGlobal().log(Level.INFO,"Conexión a base de datos");
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
		String sql1 = "CREATE TABLE IF NOT EXISTS Usuario (dni String,fechaNacimiento String,  nom String, con String, ciudad String, foto String,admin Boolean)";
		String sql2 = "CREATE TABLE IF NOT EXISTS Coche ( modelo String,marca String, puertas Integer, kms Integer, anio Integer, potencia Integer,foto String)";
		String sql3 = "CREATE TABLE IF NOT EXISTS Venta (dni String,modelo String,kms Integer)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void insertarCoche(Connection con,  String modelo,String marca, int puertas, int kilometros,int anio, int potencia, String foto) {
		String sql = "INSERT INTO Coche VALUES('"+modelo+"','"+marca+"',"+puertas+","+kilometros+","+anio+","+potencia+",'"+foto+"')";
		try {
			Logger.getGlobal().log(Level.INFO, sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void UsuarioRegular(Connection con, String dni, String fechaNacimiento, String nombre, String contraseña, String ciudad,String foto,int admin) {
		String sql = "INSERT INTO Usuario VALUES('"+dni+"','"+fechaNacimiento+"','"+nombre+"','"+contraseña+"','"+ciudad+"','"+foto+"',"+admin+")";
		try {
			Logger.getGlobal().log(Level.INFO, sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!mapaVentas.containsKey(dni)) {
			mapaVentas.put(dni, new ArrayList<Coche>());
		}
	}
	public static void Venta(Connection con,String DNI,String Modelo,int kilometros ) {
		String sql = "INSERT INTO Venta VALUES('"+DNI+"','"+Modelo+"',"+kilometros+")";
		try {
			Logger.getGlobal().log(Level.INFO, sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rellenarTablas(Connection con) {
		UsuarioRegular(con,"16097385F","2002/03/11","Asier","Teresa00","Getxo","",1);
		UsuarioRegular(con,"12034556S","2003/02/23","Markel","Askartza1","Bilbao","",0);
		UsuarioRegular(con,"13423436X","2005/10/09","Anton","112223344","Barakaldo","",0);
		UsuarioRegular(con,"13438430C","2002/04/17","Ane","2345435","Leioa","",0);
		
		
		insertarCoche(con,"R8","Tesla",2,0,2022,300,"src\\FOTOS\\tesla.jpg");
		insertarCoche(con,"R7","Audi",2,0,2022,200,"src\\FOTOS\\audi r8.jpg");
		insertarCoche(con,"Arona","Seat",4,1000,2022,120,"src\\FOTOS\\Seat-arona-red-line-e1657284471337-1200x676.jpg");
		
		Venta(con,"16097385F","R8",0);
		Venta(con,"12034556S","R7",0);
		Venta(con,"16097385F","Arona",1000);
		
	}
	public static Venta[] BDaMapa(Connection con) {
		Coche c;
		String sql="SELECT c.* FROM Coche c,Venta v WHERE c.modelo=v.modelo AND c.kms=v.kms";
		Venta[] lista = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery( sql );
			Logger.getGlobal().log( Level.INFO, "BD tipo buscado\t" + sql);
			while(rs.next()) {
				String modelo=rs.getString("modelo");
				String marca=rs.getString("marca");
				int puertas=rs.getInt("puertas");
				int kms=rs.getInt("kms");
				int anio=rs.getInt("anio");
				int potencia=rs.getInt("potencia");
				String foto=rs.getString("foto");
				c=new Coche(modelo, marca, puertas, kms, anio, potencia, foto);
				Statement st1 = con.createStatement();
				String sql1="SELECT * FROM Venta WHERE modelo='"+modelo+"' and kms="+kms;
				Logger.getGlobal().log( Level.INFO,sql1);
				ResultSet rs1 = st1.executeQuery( sql1 );
				if(rs1.next()) {
				String dni=rs1.getString(1);
				for(String s: mapaVentas.keySet()) {
					if(s.equals(dni)) {
						ArrayList<Coche> co=mapaVentas.get(dni);
						co.add(c);	
						mapaVentas.replace(dni,co);
						
					
				}
				}
				}
				rs1.close();
				st1.close();
			}
			rs.close();
			st.close();

			int i=0;
			lista= new Venta[3];
			for(String s: mapaVentas.keySet()) {
			ArrayList<Coche> ar=mapaVentas.get(s);
			Usuario us=UsuarioPorDni(con, s);
			
				for(Coche co: ar) {
					Venta v=new Venta(co, us, "");
					lista[i]=v;
					i++;
			}
			}
			

			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
		
	}
	public static Usuario UsuarioPorDni(Connection con,String dni) {
		Usuario u=null;
		try {
			Statement st=con.createStatement();
			String sql="SELECT * FROM Usuario WHERE dni='"+dni+"'";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				String nom=rs.getString("nom");
				String fechaNacimiento=rs.getString("fechaNacimiento");
				String cont=rs.getString("con");
				String ciudad=rs.getString("ciudad");
				String foto=rs.getString("foto");
				Boolean admin=rs.getBoolean("admin");
				u=new Usuario(dni,fechaNacimiento,nom,cont,ciudad,foto,admin );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
	}
	public static void borrarTabla(Connection con,String nombreTabla) {
		String sql="DROP TABLE IF EXISTS "+nombreTabla;

		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
	
	