import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class BD {
	
	final Logger LOG = Logger.getLogger("paquete.NombreClase");
	public static ArrayList<Integer> precios;
	static HashMap<String,ArrayList<Coche>> mapaVentas;
	static HashMap<String,ArrayList<Coche>> mapaCompras;
	static HashMap<String,Usuario>mapaUsuarios;
	static int cont=0;
	/**
	 * MÃ©todo que realiza la conexiÃ³n con la base de datos
	 * @param nombreBD : Nombre de la base de datos a la que nos vamos a conectar
	 * @return Devuelve la conexiÃ³n a la base de datos
	 */
	public static Connection initBD(String nombreBD,boolean inicio) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
			if(inicio) {
			mapaVentas=new HashMap<String,ArrayList<Coche>>();
			mapaCompras=new HashMap<String,ArrayList<Coche>>();
			precios=new ArrayList<Integer>();
			}
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
		String sql1 = "CREATE TABLE IF NOT EXISTS Usuario (dni String,fechaNacimiento String,  nom String, con String, ciudad String, foto String,cartera Integer,admin Boolean)";
		String sql2 = "CREATE TABLE IF NOT EXISTS Coche ( modelo String,marca String, puertas Integer, kms Integer, anio Integer, potencia Integer,foto String)";
		String sql3 = "CREATE TABLE IF NOT EXISTS Venta (dni String,modelo String,kms Integer,precio Integer,vistas Integer)";
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
	
	public static void UsuarioRegular(Connection con, String dni, String fechaNacimiento, String nombre, String contraseña, String ciudad,String foto,int cartera,int admin) {
		String sql = "INSERT INTO Usuario VALUES('"+dni+"','"+fechaNacimiento+"','"+nombre+"','"+contraseña+"','"+ciudad+"','"+foto+"',"+cartera+","+admin+")";
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

	public static HashMap<String, Usuario> getMapaUsuarios() {
		return mapaUsuarios;
	}

	public static void setMapaUsuarios(HashMap<String, Usuario> mapaUsuarios) {
		BD.mapaUsuarios = mapaUsuarios;
	}
	public static void Venta(Connection con,String DNI,String Modelo,int kilometros,int dinero ,int vistas) {
		String sql = "INSERT INTO Venta VALUES('"+DNI+"','"+Modelo+"',"+kilometros+","+dinero+","+vistas+")";
		try {
			Logger.getGlobal().log(Level.INFO, sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		precios.add(dinero);
	}
	public static void rellenarTablas(Connection con) {
		UsuarioRegular(con,"16097385F","2002/03/11","Asier","Teresa00","Getxo","src\\FOTOS\\74472.png",1000000, 10000);
		UsuarioRegular(con,"12034556S","2003/02/23","Markel","Askartza1","Bilbao","",100000, 0);
		UsuarioRegular(con,"13423436X","2005/10/09","Anton","112223344","Barakaldo","",0, 0);
		UsuarioRegular(con,"13438430C","2002/04/17","Ane","2345435","Leioa","",0, 0);
		UsuarioRegular(con,"12345678A", "01/01/1995", "Juan Pérez", "password1", "Madrid", "https://www.example.com/foto1.jpg", 0, 0);
		UsuarioRegular(con,"87654321B", "02/02/1996", "María Rodríguez", "password2", "Barcelona", "https://www.example.com/foto2.jpg", 0, 0);
		UsuarioRegular(con,"23456789C", "03/03/1997", "Pablo Martín", "password3", "Valencia", "https://www.example.com/foto3.jpg", 0, 0);
		UsuarioRegular(con,"56789123D", "04/04/1998", "Sara Gómez", "password4", "Sevilla", "https://www.example.com/foto4.jpg", 0, 0);
		UsuarioRegular(con,"89123456E", "05/05/1999", "Laura Sánchez", "password5", "Zaragoza", "https://www.example.com/foto5.jpg", 0, 0);
		UsuarioRegular(con,"34567890F", "06/06/2000", "Carlos Moreno", "password6", "Málaga", "https://www.example.com/foto6.jpg", 0, 0);
		UsuarioRegular(con,"67890ABC", "07/07/2001", "Alberto Jiménez", "password7", "Bilbao", "https://www.example.com/foto7.jpg", 0, 0);
		UsuarioRegular(con,"90123CDE", "08/08/2002", "Ana Díaz", "password8", "Murcia", "https://www.example.com/foto8.jpg", 0, 0);
		UsuarioRegular(con,"01234FGH", "09/09/2003", "Javier Ruiz", "password9", "Palma de Mallorca", "https://www.example.com/foto9.jpg", 0, 0);
		UsuarioRegular(con,"56789IJK", "10/10/2004", "Elena Ortiz", "password10", "Las Palmas de Gran Canaria", "https://www.example.com/foto10.jpg", 0, 0);
		
		
		insertarCoche(con,"R8","Tesla",2,0,2022,300,"src\\FOTOS\\tesla.jpg");
		insertarCoche(con,"R7","Audi",2,0,2022,200,"src\\FOTOS\\audi r8.jpg");
		insertarCoche(con,"Arona","Seat",4,1000,2022,120,"src\\FOTOS\\Seat-arona-red-line-e1657284471337-1200x676.jpg");
		insertarCoche(con,"Mazda 3", "Mazda", 4, 20000, 2018, 150, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.mazda.es%2Fgama%2Fmazda3%2F&psig=AOvVaw3cPAM1HS9eAK5wIaUUcVqP&ust=1673093622534000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCKjahcr1svwCFQAAAAAdAAAAABAD");
		insertarCoche(con,"Toyota Camry", "Toyota", 4, 50000, 2020, 200, "https://upload.wikimedia.org/wikipedia/commons/b/bd/2022_Toyota_Camry_Hybrid_XLE_in_Midnight_Black_Metallic%2C_Front_Right%2C_12-25-2021.jpg");
		insertarCoche(con,"Nissan Altima", "Nissan", 4, 30000, 2019, 180, "https://cdn-images.motor.es/image/m/1280w/fotos-noticias/2022/06/nissan-altima-2023-202287661-1654970785_1.jpg");
		insertarCoche(con,"Ford Fusion", "Ford", 4, 35000, 2017, 190, "https://upload.wikimedia.org/wikipedia/commons/c/ca/2013_Ford_Fusion_Hybrid_trim.jpg");
		insertarCoche(con,"Hyundai Sonata", "Hyundai", 4, 40000, 2020, 160, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/2018_Hyundai_Sonata_%28LF4_MY18%29_Active_2.4_sedan_%282018-10-22%29_01.jpg/800px-2018_Hyundai_Sonata_%28LF4_MY18%29_Active_2.4_sedan_%282018-10-22%29_01.jpg");
		insertarCoche(con,"Subaru Legacy", "Subaru", 4, 25000, 2018, 170, "https://upload.wikimedia.org/wikipedia/commons/1/17/%2703-%2704_Subaru_Legacy_Sedan.JPG");
		insertarCoche(con,"Honda Civic", "Honda", 4, 45000, 2019, 140, "https://upload.wikimedia.org/wikipedia/commons/e/e1/2022_Honda_Civic_LX%2C_Front_Right%2C_06-20-2021.jpg");
		insertarCoche(con,"Kia Optima", "Kia", 4, 30000, 2017, 180, "https://upload.wikimedia.org/wikipedia/commons/1/1a/2018_Kia_Optima_2_CRDi_ISG_1.6_facelift_Front.jpg");
		insertarCoche(con,"Chevrolet Malibu", "Chevrolet", 4, 40000, 2018, 150, "https://upload.wikimedia.org/wikipedia/commons/0/01/2019_Chevrolet_Malibu_%28facelift%29_LT%2C_front_10.19.19.jpg");
		insertarCoche(con,"BMW 3 Series", "BMW", 4, 50000, 2020, 250, "https://upload.wikimedia.org/wikipedia/commons/7/7a/2020_BMW_530d_M_Sport_facelift.jpg");
		
		
		
		Venta(con,"16097385F","R8",0,15000, 0);
		Venta(con,"12034556S","R7",0,70000, 0);
		Venta(con,"16097385F","Arona",1000,40000, 0);
		Venta(con,"12345678A", "Mazda 3", 20000,30000, 0);
		Venta(con,"87654321B", "Toyota Camry", 50000,25000, 0);
		Venta(con,"23456789C", "Nissan Altima", 30000,20000, 0);
		Venta(con,"56789123D", "Ford Fusion", 35000,15000, 0);
		Venta(con,"89123456E", "Hyundai Sonata", 40000,14000, 0);
		Venta(con,"34567890F", "Subaru Legacy", 25000,16000, 0);
		Venta(con,"67890ABC", "Honda Civic", 45000,18000, 0);
		Venta(con,"90123CDE", "Kia Optima", 30000,15000, 0);
		Venta(con,"01234FGH", "Chevrolet Malibu", 40000,17000, 0);
		Venta(con,"56789IJK", "BMW 3 Series", 50000,50000, 0);
		Venta(con,"56789IJK","R8",0,15000, 0);
	}
	public static Venta[] BDaMapa(Connection con) throws MalformedURLException {
		Coche c;
		String sql="SELECT c.*,v.dni FROM Coche c,Venta v,Usuario u WHERE c.modelo=v.modelo AND c.kms=v.kms AND v.dni=u.dni";
		Venta[] lista = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery( sql );
			Logger.getGlobal().log( Level.INFO, "BD tipo buscado\t" + sql);
			while(rs.next()) {
				cont++;
				String modelo=rs.getString("modelo");
				String marca=rs.getString("marca");
				int puertas=rs.getInt("puertas");
				int kms=rs.getInt("kms");
				int anio=rs.getInt("anio");
				int potencia=rs.getInt("potencia");
				String foto=rs.getString("foto");
				String dni=rs.getString("dni");
				c=new Coche(modelo, marca, puertas, kms, anio, potencia, foto);
				
				
				for(String s: mapaVentas.keySet()) {
					if(s.equals(dni)) {
						ArrayList<Coche> co=mapaVentas.get(dni);
						co.add(c);	
						mapaVentas.replace(dni,co);
						
					
				}
				}
				}
				
			
			rs.close();
			st.close();

			int i=0;
			lista= new Venta[cont];
			for(String s: mapaVentas.keySet()) {
			ArrayList<Coche> ar=mapaVentas.get(s);
			Usuario us=UsuarioPorDni(con, s);
				for(Coche co: ar) {
					Venta v=new Venta(co, us, "",precios.get(i),0);
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
				int cartera=rs.getInt("cartera");
				Boolean admin=rs.getBoolean("admin");
				u=new Usuario(dni,fechaNacimiento,nom,cont,ciudad,foto,cartera,admin );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
	}
	public static void guardaCompras() {

		try {
			
			FileOutputStream fos=new FileOutputStream("DOCUMENTOS/compras.dat",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(mapaCompras);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void cargaCompras() throws FileNotFoundException {
		mapaCompras=new HashMap<String,ArrayList<Coche>>();
		FileInputStream f= new FileInputStream("DOCUMENTOS/compras.dat");
		try {
			ObjectInputStream ois= new ObjectInputStream(f);
			Object obj = ois.readObject();
			if (obj.getClass() == HashMap.class) {
			    HashMap<String, ArrayList<Coche>> map = (HashMap<String, ArrayList<Coche>>) obj;
			    BD.setMapaCompras(map);
			}
			ois.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void guardaUsuarios() {
		File f= new File("DOCUMENTOS/usuarios.txt");
		try {
			FileWriter fw=new FileWriter(f);
			fw.write("");
			for(Usuario u:mapaUsuarios.values()) {
				fw.write(u.getDni()+","+u.getFechaNacimiento()+","+u.getNombre() +","+u.getContrasenia()+","
				+u.getCiudad()+","+u.getFoto()+","+u.getCartera()+","+u.getAdmin()+"\n");
			}
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void cargaUsuarios() {
		mapaUsuarios=new HashMap<String,Usuario>();
		File f= new File("DOCUMENTOS/usuarios.txt");
		try {
			BufferedReader bf= new BufferedReader(new FileReader(f));
			String linea;
			while((linea = bf.readLine()) != null) {
				String[] us=linea.split(",");
				mapaUsuarios.putIfAbsent(us[0], new Usuario(us[0],us[1],us[2],us[3],us[4],us[5],Integer.parseInt(us[6]),Boolean.parseBoolean(us[7])));
				
			}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
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
	public static void ActualizarVistas(Connection con) {
		for(Venta v: MENU.getLista()) {
			Statement st;
			try {
				st = con.createStatement();
				String sql="UPDATE Venta SET vistas="+v.getVistas()+" WHERE dni='"+v.getU()+"' AND modelo='"+v.getC().getModelo()
						+"' AND kms="+v.getC().getKilometros();
				st.executeUpdate(sql);
				Logger.getGlobal().log( Level.INFO,sql);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	public static void borrarVenta(Connection con, Venta v) {
		String sql="DELETE FROM Venta WHERE dni='"+v.getU().getDni()+"' AND modelo='"+v.getC().getModelo()+"' AND kms="+v.getC().getKilometros();
		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			Logger.getGlobal().log( Level.INFO,sql);
			st.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void aniadirVenta(Connection con, Venta v){
		String sql="INSERT INTO Venta VALUES('"+v.getU().getDni()+"','"+v.getC().getModelo()+"',"+v.getC().getKilometros()+","+v.getDinero()+","+v.getVistas()+")";
		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			Logger.getGlobal().log( Level.INFO,sql);
			st.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
		public static boolean comprable(int dinero, boolean editable) {
			if(!editable) {
			if(MENU.getUactual().getCartera()>=dinero) {
				
				MENU.getUactual().setCartera(MENU.getUactual().getCartera()-dinero);
				MENU.Perfil.setText(MENU.getUactual().getCartera()+"€          "+MENU.getUactual().getNombre());
				return true;
				
			}else {
			JOptionPane.showMessageDialog(null, "No tienes suficiente dinero");
			return false;
			}
			}
			return false;
			
			
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
	
	