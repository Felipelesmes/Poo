package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class NombreJugador extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldnombre;

	/**
	 * Create the frame.
	 */
	public NombreJugador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NombreJugador.class.getResource("/imagenes/icono.png")));

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldnombre = new JTextField();
		textFieldnombre.setBounds(601, 359, 217, 42);
		contentPane.add(textFieldnombre);
		textFieldnombre.setColumns(10);

		JLabel nombretitulo = new JLabel("NOMBRE DE JUGADOR:");
		nombretitulo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		nombretitulo.setBounds(601, 296, 242, 52);
		contentPane.add(nombretitulo);

		JButton botonAtras = new JButton("ATRAS");
		botonAtras.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		botonAtras.setForeground(new Color(51, 0, 51));
		botonAtras.setBackground(Color.PINK);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fondo Ventana = new fondo();
				Ventana.setVisible(true);
				dispose();
			}
		});
		botonAtras.setBounds(729, 428, 89, 34);
		contentPane.add(botonAtras);

		JButton botonConti = new JButton("CONTINUAR");
		botonConti.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 10));
		botonConti.setForeground(new Color(51, 0, 51));
		botonConti.setBackground(Color.PINK);
		botonConti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre= textFieldnombre.getText().toString();
				juego Ventana = new juego(nombre);
				Ventana.setVisible(true);
				dispose();
			}
		});
		botonConti.setBounds(601, 428, 106, 34);
		contentPane.add(botonConti);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(NombreJugador.class.getResource("/imagenes/logo.png")));
		logo.setBounds(448, -49, 470, 334);
		contentPane.add(logo);

		JLabel fondo2 = new JLabel("");
		fondo2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		fondo2.setIcon(new ImageIcon(NombreJugador.class.getResource("/imagenes/fondoNomjug.jpg")));
		fondo2.setBounds(403, 0, 564, 733);
		contentPane.add(fondo2);

		JLabel fondo1 = new JLabel("");
		fondo1.setIcon(new ImageIcon(NombreJugador.class.getResource("/imagenes/fondojugar.jpg")));
		fondo1.setBounds(0, 0, 1370, 733);
		contentPane.add(fondo1);
	}
}
