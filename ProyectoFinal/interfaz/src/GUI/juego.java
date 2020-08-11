package GUI;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;

import candycrush.CandyCrush;
import candycrush.Jugador;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingUtilities;

public class juego extends JFrame {

	private JPanel contentPane;
	private CandyCrush logica;
	private int pos1=9, pos2=9, pos3, pos4;
	private JButton[][] botones;
	private JPanel tablero;
	private JLabel labelPuntos;
	private JLabel labelMovimientos;
	private JLabel labelVidas;
	private int puntosG=1000;

	/**
	 * Create the frame.
	 */
	public juego(String nombre) {
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(juego.class.getResource("/imagenes/icono.png")));
		logica=new CandyCrush(nombre,5,50);
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
				NombreJugador VentanaNombre = new NombreJugador();
				VentanaNombre.setVisible(true);
				dispose();
			}
		});

		JButton botonSalir = new JButton("SALIR");
		botonSalir.setForeground(new Color(51, 0, 51));
		botonSalir.setBackground(Color.PINK);
		botonAtras.setForeground(new Color(51, 0, 51));
		botonAtras.setBackground(Color.PINK);
		botonAtras.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		labelMovimientos = new JLabel("MOV. RESTANTES: " + logica.getJugador().getMovimientos());
		labelMovimientos.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		labelMovimientos.setBounds(522, 137, 280, 52);
		contentPane.add(labelMovimientos);

		labelPuntos = new JLabel("PUNTOS: " + logica.getJugador().getPuntos());
		labelPuntos.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		labelPuntos.setBounds(522, 83, 280, 43);
		contentPane.add(labelPuntos);
		
		
		labelVidas = new JLabel("VIDAS: " + logica.getJugador().getVidas());
		labelVidas.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		labelVidas.setBounds(522, 24, 280, 43);
		contentPane.add(labelVidas);
		
		botonSalir.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		botonSalir.setBounds(1148, 110, 141, 52);
		contentPane.add(botonSalir);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(juego.class.getResource("/imagenes/logo.png")));
		logo.setBounds(0, 11, 512, 349);
		contentPane.add(logo);

		JLabel nombreJug = new JLabel(logica.getJugador().getNombre());
		nombreJug.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 28));
		nombreJug.setBounds(154, 385, 349, 56);
		contentPane.add(nombreJug);

		JLabel textoJug = new JLabel("JUGADOR:");
		textoJug.setBounds(0, 385, 150, 56);
		contentPane.add(textoJug);
		textoJug.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		tablero = new JPanel();
		GridLayout gl = new GridLayout(logica.size, logica.size);
		tablero.setLayout(gl);

		tablero.setBounds(513, 210, 512, 512);

		contentPane.add(tablero);


		botonAtras.setBounds(1148, 47, 141, 52);
		contentPane.add(botonAtras);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(juego.class.getResource("/imagenes/fondojugar.jpg")));
		fondo.setBounds(0, 0, 1360, 733);
		contentPane.add(fondo);

		botones = new JButton[logica.size][logica.size];

		for(int i = 0;i<botones.length;i++){
			for(int j = 0;j<botones[i].length;j++){
				botones[i][j]=new JButton();
				botones[i][j].setIcon(new ImageIcon(juego.class.getResource(logica.getTablero()[i][j])));
				//botones[i][j].addActionListener(l);
				tablero.add(botones[i][j]);
			}
		}
		
		
		//verifica clickeo
		for(int i =0; i< botones.length; i++){
			for(int j =0; j< botones.length; j++){
				botones[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent ev) {
						if (SwingUtilities.isLeftMouseButton(ev)) {	
							System.out.println("primer click"); 
							for (int k = 0; k < botones.length; k++) {
								for (int l = 0; l < botones.length; l++) {
									if(botones[k][l]==ev.getSource()) {
										//System.out.println("posision : "+k+ " "+l);
										setPosLeftClick(k, l);
										//pos1 = k;
										//pos2 = l;
										break;
									}

								}

							}  
						} else if (SwingUtilities.isRightMouseButton(ev)) {
							System.out.println("segundo click");
							for (int m = 0; m < botones.length; m++) {
								for (int n = 0; n < botones.length; n++) {
									if(botones[m][n]==ev.getSource()) {
										//System.out.println("posision : "+m+ " "+n);
										//pos3 = m;
										//pos4 = n;
										setPosRightClick(m, n);
										break;
									}
								}
							}

						}
					}

				});
			}
		}
		
	}
	public void mover(int p1,int p2,int p3,int p4){
		logica.mover(p1, p2, p3, p4);
		for(int i = 0;i<botones.length;i++){
			for(int j = 0;j<botones[i].length;j++){
				//botones[i][j]=new JButton();
				//botones[i][j].setIcon(new ImageIcon(juego.class.getResource(logica.getTablero()[i][j])));
				tablero.remove(botones[i][j]);
			}
		}
		for(int i = 0;i<botones.length;i++){
			for(int j = 0;j<botones[i].length;j++){
				//botones[i][j]=new JButton();
				botones[i][j].setIcon(new ImageIcon(juego.class.getResource(logica.getTablero()[i][j])));
				tablero.add(botones[i][j]);
			}
		}
		labelMovimientos.setText("MOV. RESTANTES: " + logica.getJugador().getMovimientos());
		labelVidas.setText("VIDAS: " + logica.getJugador().getVidas());
		labelPuntos.setText("PUNTOS: " + logica.getJugador().getPuntos());
		
		tablero.updateUI();
		contentPane.updateUI();
		//System.out.println(logica.getJugador().getPuntos());
		if(logica.getJugador().getPuntos()>=puntosG) {
			Ganar partida = new Ganar(logica.getJugador().getNombre());
			partida.setVisible(true);
			dispose();
		}
		if(logica.getJugador().getVidas()==0) {
			Perder partida = new Perder(logica.getJugador().getNombre());
			partida.setVisible(true);
			dispose();
		}
		
	}

	public void setPosLeftClick(int p1, int p2){
		pos1=p1;
		pos2=p2;
	}
	public void setPosRightClick(int p1, int p2){
		pos3=p1;
		pos4=p2;
		if(pos1!=9&&pos2!=9)
			mover(pos1,pos2,pos3,pos4);
	}
	

	/*public void debug() {
		contentPane.updateUI();
		Jugador j = logica.getJugador();
		System.out.println("DEBUG:");
		System.out.println("Nombre: " + j.getNombre());
		System.out.println("Movimientos restantes: " + j.getMovimientos());
		System.out.println("Puntos: " + j.getPuntos());
		System.out.println("Vidas: " + j.getVidas());
		System.out.println();
	}*/
	
}
