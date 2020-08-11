package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Ganar extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Ganar(String nombre) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ganar.class.getResource("/imagenes/icono.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonMenu = new JButton("MENU PRINCIPAL");
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondo Ventana=new fondo();
				Ventana.setVisible(true);
				dispose();
			}
		});
		
		//JLabel JLabelNombre = new JLabel(logica.getJugador().getNombre());
		JLabel JLabelNombre = new JLabel(nombre);
		JLabelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelNombre.setForeground(Color.WHITE);
		JLabelNombre.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 31));
		JLabelNombre.setBounds(468, 328, 476, 59);
		contentPane.add(JLabelNombre);
		
		botonMenu.setForeground(Color.BLACK);
		botonMenu.setBackground(Color.PINK);
		botonMenu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		botonMenu.setBounds(1053, 533, 212, 42);
		contentPane.add(botonMenu);
		
		JButton botonNewJuego = new JButton("NUEVO JUEGO");
		botonNewJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NombreJugador Ventana=new NombreJugador();
				Ventana.setVisible(true);
				dispose();
			}
		});
		botonNewJuego.setBackground(Color.PINK);
		botonNewJuego.setForeground(Color.BLACK);
		botonNewJuego.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		botonNewJuego.setBounds(214, 533, 184, 42);
		contentPane.add(botonNewJuego);
		
		JLabel JLabelGanaste = new JLabel("");
		JLabelGanaste.setIcon(new ImageIcon(Ganar.class.getResource("/imagenes/Ganaste.png")));
		JLabelGanaste.setBounds(527, 441, 436, 292);
		contentPane.add(JLabelGanaste);
		
		JLabel JLabelFelicidades = new JLabel("");
		JLabelFelicidades.setIcon(new ImageIcon(Ganar.class.getResource("/imagenes/Felicidades.png")));
		JLabelFelicidades.setBounds(351, 57, 781, 428);
		contentPane.add(JLabelFelicidades);
		
		JLabel JLabelFondo = new JLabel("");
		JLabelFondo.setIcon(new ImageIcon(Ganar.class.getResource("/imagenes/fondoPG.jpg")));
		JLabelFondo.setBounds(0, 0, 1370, 733);
		contentPane.add(JLabelFondo);
	}
}
