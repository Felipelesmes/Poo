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

public class Perder extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Perder(String nombre) {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Perder.class.getResource("/imagenes/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonMenu = new JButton("MENU PRINCIPAL");
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondo Ventana = new fondo();
				Ventana.setVisible(true);
				dispose();
			}
		});
		botonMenu.setForeground(Color.BLACK);
		botonMenu.setBackground(Color.PINK);
		botonMenu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		botonMenu.setBounds(1035, 520, 211, 57);
		contentPane.add(botonMenu);
		
		JButton botonNewIntento = new JButton("VOLVER A INTENTAR");
		botonNewIntento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego Ventana=new juego(nombre);
				Ventana.setVisible(true);
				dispose();
			}
		});
		botonNewIntento.setBackground(Color.PINK);
		botonNewIntento.setForeground(Color.BLACK);
		botonNewIntento.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		botonNewIntento.setBounds(202, 520, 243, 57);
		contentPane.add(botonNewIntento);
		
		JLabel JLabelGato = new JLabel("");
		JLabelGato.setIcon(new ImageIcon(Perder.class.getResource("/imagenes/gato.png")));
		JLabelGato.setBounds(612, 457, 243, 132);
		contentPane.add(JLabelGato);
		
		JLabel JLabelLose = new JLabel("");
		JLabelLose.setIcon(new ImageIcon(Perder.class.getResource("/imagenes/lose.png")));
		JLabelLose.setBounds(372, 84, 756, 324);
		contentPane.add(JLabelLose);
		
		JLabel JLabelFondo = new JLabel("");
		JLabelFondo.setIcon(new ImageIcon(Perder.class.getResource("/imagenes/fondoPG.jpg")));
		JLabelFondo.setBounds(0, 0, 1370, 733);
		contentPane.add(JLabelFondo);
	}

}
