import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;


public class BD {
	final Logger LOG = Logger.getLogger("paquete.NombreClase");
	
	static HashMap<String,ArrayList<Coche>> mapaVentas;
	static HashMap<String,ArrayList<Coche>> mapaCompras;
	
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
			mapaCompras=new HashMap<String,ArrayList<Coche>>();
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
			mapaCompras.put(dni, new ArrayList<Coche>());
		}
	}
	public static HashMap<String, ArrayList<Coche>> getMapaVentas() {
		return mapaVentas;
	}

	public static void setMapaVentas(HashMap<String, ArrayList<Coche>> mapaVentas) {
		BD.mapaVentas = mapaVentas;
	}

	public static HashMap<String, ArrayList<Coche>> getMapaCompras() {
		return mapaCompras;
	}

	public static void setMapaCompras(HashMap<String, ArrayList<Coche>> mapaCompras) {
		BD.mapaCompras = mapaCompras;
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
		UsuarioRegular(con,"16097385F","2002/03/11","Asier","Teresa00","Getxo","src\\FOTOS\\74472.png",1);
		UsuarioRegular(con,"12034556S","2003/02/23","Markel","Askartza1","Bilbao","",0);
		UsuarioRegular(con,"13423436X","2005/10/09","Anton","112223344","Barakaldo","",0);
		UsuarioRegular(con,"13438430C","2002/04/17","Ane","2345435","Leioa","",0);
		UsuarioRegular(con,"12345678A", "01/01/1995", "Juan Pérez", "password1", "Madrid", "https://www.example.com/foto1.jpg", 0);
		UsuarioRegular(con,"87654321B", "02/02/1996", "María Rodríguez", "password2", "Barcelona", "https://www.example.com/foto2.jpg", 0);
		UsuarioRegular(con,"23456789C", "03/03/1997", "Pablo Martín", "password3", "Valencia", "https://www.example.com/foto3.jpg", 0);
		UsuarioRegular(con,"56789123D", "04/04/1998", "Sara Gómez", "password4", "Sevilla", "https://www.example.com/foto4.jpg", 0);
		UsuarioRegular(con,"89123456E", "05/05/1999", "Laura Sánchez", "password5", "Zaragoza", "https://www.example.com/foto5.jpg", 0);
		UsuarioRegular(con,"34567890F", "06/06/2000", "Carlos Moreno", "password6", "Málaga", "https://www.example.com/foto6.jpg", 0);
		UsuarioRegular(con,"67890ABC", "07/07/2001", "Alberto Jiménez", "password7", "Bilbao", "https://www.example.com/foto7.jpg", 0);
		UsuarioRegular(con,"90123CDE", "08/08/2002", "Ana Díaz", "password8", "Murcia", "https://www.example.com/foto8.jpg", 0);
		UsuarioRegular(con,"01234FGH", "09/09/2003", "Javier Ruiz", "password9", "Palma de Mallorca", "https://www.example.com/foto9.jpg", 0);
		UsuarioRegular(con,"56789IJK", "10/10/2004", "Elena Ortiz", "password10", "Las Palmas de Gran Canaria", "https://www.example.com/foto10.jpg", 0);
		
		
		insertarCoche(con,"R8","Tesla",2,0,2022,300,"src\\FOTOS\\tesla.jpg");
		insertarCoche(con,"R7","Audi",2,0,2022,200,"src\\FOTOS\\audi r8.jpg");
		insertarCoche(con,"Arona","Seat",4,1000,2022,120,"src\\FOTOS\\Seat-arona-red-line-e1657284471337-1200x676.jpg");
		insertarCoche(con,"Mazda 3", "Mazda", 4, 20000, 2018, 150, "https://www.mazda.com/content/dam/Mazda/global-site/cars/3/overview/3-hero-image-desktop.jpg");
		insertarCoche(con,"Toyota Camry", "Toyota", 4, 50000, 2020, 200, "https://www.toyota.com/content/toyota/en/vehicles/new/2020/camry/trims/xse.html/jcr:content/heroCarousel/hero/image.adaptive.full.jpg/1561130073907.jpg");
		insertarCoche(con,"Nissan Altima", "Nissan", 4, 30000, 2019, 180, "https://www.nissanusa.com/content/dam/nissan/vehicles/altima/2019/overview/Altima_2019_OVERVIEW_HERO_DESKTOP.jpg");
		insertarCoche(con,"Ford Fusion", "Ford", 4, 35000, 2017, 190, "https://www.ford.com/content/dam/ford-com/global/nameplate-assets/fusion/2019/overview/2019-Ford-Fusion-Overview-Hero.jpg");
		insertarCoche(con,"Hyundai Sonata", "Hyundai", 4, 40000, 2020, 160, "https://www.hyundaiusa.com/content/dam/hyundai/global/en/vehicles/2020/sonata/overview/2020-sonata-overview-hero-desktop.jpg");
		insertarCoche(con,"Subaru Legacy", "Subaru", 4, 25000, 2018, 170, "https://www.subaru.com/content/subaru/en/vehicles/legacy/2018/overview/overview.html/jcr:content/heroCarousel/hero/image.adaptive.full.jpg/1481919860260.jpg");
		insertarCoche(con,"Honda Civic", "Honda", 4, 45000, 2019, 140, "https://www.honda.com/content/dam/honda/vehicles/2019/civic/2019-civic-hero.jpg");
		insertarCoche(con,"Kia Optima", "Kia", 4, 30000, 2017, 180, "https://www.kia.com/content/dam/kwcms/us/en/index/index.desktop.new.image.image1.jpg/1587203378379.jpg");
		insertarCoche(con,"Chevrolet Malibu", "Chevrolet", 4, 40000, 2018, 150, "https://www.chevrolet.com/content/dam/chevrolet/northamerica/us/english/index/vehicles/cars/malibu/2019/overview/1920x1080/2019-malibu-overview-hero.jpg");
		insertarCoche(con,"BMW 3 Series", "BMW", 4, 50000, 2020, 250, "https://www.bmw.com/content/dam/bmw/common/all-models/3-series/sedan/2020/at-a-glance/3-series-at-a-glance.jpg");
		
		
		
		Venta(con,"16097385F","R8",0);
		Venta(con,"12034556S","R7",0);
		Venta(con,"16097385F","Arona",1000);
		Venta(con,"12345678A", "Mazda 3", 20000);
		Venta(con,"87654321B", "Toyota Camry", 50000);
		Venta(con,"23456789C", "Nissan Altima", 30000);
//		Venta(con,"56789123D", "Ford Fusion", 35000);
//		Venta(con,"89123456E", "Hyundai Sonata", 40000);
//		Venta(con,"34567890F", "Subaru Legacy", 25000);
//		Venta(con,"67890ABC", "Honda Civic", 45000);
//		Venta(con,"90123CDE", "Kia Optima", 30000);
//		Venta(con,"01234FGH", "Chevrolet Malibu", 40000);
//		Venta(con,"56789IJK", "BMW 3 Series", 50000);
	}
	public static Venta[] BDaMapa(Connection con) throws MalformedURLException {
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
			lista= new Venta[20];
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
	
		public static boolean esURL(String urlString) {
		    try {
		        URL url = new URL(urlString);
		        url.toURI();
		        return true;
		    } catch (MalformedURLException | URISyntaxException e) {
		        return false;
		    }
		}

}
	
	