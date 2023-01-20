import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class VentanaInicioSesion extends JFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	    private JLabel labelUsername;
	    private JLabel labelPassword;
	    private JTextField textUsername;
	    private JPasswordField textPassword;
	    private JButton buttonLogin;
	    private JButton buttonCancel;
	    private JLabel linkLabel;
	    
	    public VentanaInicioSesion() {
	        // Configurar la ventana
	        setTitle("Inicio de sesi�n");
	        setSize(400, 300);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Crear panel
	        panel = new JPanel();
	        panel.setLayout(null);

	        // Crear etiquetas
	        labelUsername = new JLabel("Nombre de usuario:");
	        labelUsername.setBounds(30, 50, 150, 25);
	        labelPassword = new JLabel("Contrase�a:");
	        labelPassword.setBounds(30, 100, 150, 25);
	        linkLabel = new JLabel("<html><a href=''>Haz clic aqu� para ir a otra pesta�a</a></html>");
	        linkLabel.setBounds(30, 200, 350, 25);
	        
	        // Crear campos de texto
	        textUsername = new JTextField();
	        textUsername.setBounds(200, 50, 150, 25);
	        textPassword = new JPasswordField();
	        textPassword.setBounds(200, 100, 150, 25);

	     // Crear botones
	     buttonLogin = new JButton("Iniciar sesi�n");
	     buttonLogin.setBounds(100, 150, 120, 30);
	     buttonCancel = new JButton("Cancelar");
	     buttonCancel.setBounds(240, 150, 120, 30);

	     // A�adir evento al bot�n de iniciar sesi�n
	     buttonLogin.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             String username = textUsername.getText();
	             String password = new String(textPassword.getPassword());
	             // Aqu� puedes a�adir c�digo para verificar las credenciales de inicio de sesi�n
	             System.out.println("Nombre de usuario: " + username);
	             System.out.println("Contrase�a: " + password);
	         }
	     });

	     // A�adir evento al bot�n de cancelar
	     buttonCancel.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             System.exit(0);
	         }
	     });
	     
	    
	        linkLabel.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    // Establecer la direcci�n URL del enlace
	                    URI link = new URI("https://www.example.com");
	                    // Abrir el enlace en el navegador por defecto
	                    Desktop.getDesktop().browse(link);
	                } catch (URISyntaxException | IOException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	     
	     // A�adir componentes al panel
	     panel.add(labelUsername);
	     panel.add(labelPassword);
	     panel.add(textUsername);
	     panel.add(textPassword);
	     panel.add(linkLabel);
	     panel.add(buttonLogin);
	     panel.add(buttonCancel);

	     // A�adir panel a la ventana
	     add(panel);

	     // Mostrar ventana
	     setVisible(true);
	     }

	     public static void main(String[] args) {
	         SwingUtilities.invokeLater(new Runnable() {
	             public void run() {
	                 new VentanaInicioSesion();
	             }
	         });
	     }
	     
}

