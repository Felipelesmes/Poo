package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class fondo extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public fondo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(fondo.class.getResource("/imagenes/icono.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton JBsalir = new JButton("SALIR");
		JBsalir.setForeground(new Color(51, 0, 51));
		JBsalir.setBackground(Color.MAGENTA);
		JBsalir.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		JBsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton JBinstrucciones = new JButton("INSTRUCCIONES");
		JBinstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instrucciones Ventana = new instrucciones();
				Ventana.setVisible(true);
				dispose();
				
			}

			
		});
		JBinstrucciones.setForeground(new Color(51, 0, 51));
		JBinstrucciones.setBackground(Color.MAGENTA);
		JBinstrucciones.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		JBinstrucciones.setBounds(1050, 333, 195, 40);
		contentPane.add(JBinstrucciones);
		
		JButton JBiniciar = new JButton("INICIAR JUEGO");
		JBiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NombreJugador Ventana = new NombreJugador();
				Ventana.setVisible(true);
				dispose();
			}
		});
		JBiniciar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		JBiniciar.setForeground(new Color(51, 0, 51));
		JBiniciar.setBackground(Color.MAGENTA);
		JBiniciar.setBounds(1050, 229, 195, 40);
		contentPane.add(JBiniciar);
		
		JLabel JlabelLogo = new JLabel("");
		JlabelLogo.setIcon(new ImageIcon(fondo.class.getResource("/imagenes/logo.png")));
		JlabelLogo.setBounds(10, 39, 525, 347);
		contentPane.add(JlabelLogo);
		JBsalir.setBounds(1081, 432, 140, 40);
		contentPane.add(JBsalir);
		
		JLabel JlabelFondo = new JLabel("");
		JlabelFondo.setBounds(-22, -27, 1392, 778);
		JlabelFondo.setIcon(new ImageIcon(fondo.class.getResource("/imagenes/FondoCandy.png")));
		contentPane.add(JlabelFondo);
	}
}
