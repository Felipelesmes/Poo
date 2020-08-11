package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class instrucciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public instrucciones() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(instrucciones.class.getResource("/imagenes/icono.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonAtras = new JButton("ATRAS");
		botonAtras.setForeground(new Color(51, 0, 51));
		botonAtras.setBackground(Color.PINK);
		botonAtras.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondo Ventana = new fondo();
				Ventana.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(instrucciones.class.getResource("/imagenes/Textoins.png")));
		lblNewLabel.setBounds(682, 108, 663, 479);
		contentPane.add(lblNewLabel);
		botonAtras.setBounds(935, 605, 140, 40);
		contentPane.add(botonAtras);
		
		JLabel Jlabelfondo = new JLabel("");
		Jlabelfondo.setIcon(new ImageIcon(instrucciones.class.getResource("/imagenes/FondoIns.jpg")));
		Jlabelfondo.setBounds(-26, -26, 1395, 759);
		contentPane.add(Jlabelfondo);
	}
}
