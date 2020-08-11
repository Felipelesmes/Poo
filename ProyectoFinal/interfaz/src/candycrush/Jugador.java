package candycrush;

public class Jugador {

	private String nombre;
	private int puntos;
	private int vidas;
	private int movimientos;

	// Constructor

	public Jugador (String nombre, int vidas, int movimientos) {
		this.nombre = nombre;
		this.vidas = vidas;
		this.movimientos = movimientos;
		this.puntos=0;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}

	// Funciones



	/* Restar una vida al jugador*/
	public void lessVidas() {
		if (movimientos == 0) {
			vidas--;
			movimientos=50;
		}
	}

	 //Agregar puntos al jugador
	public void addPuntos(int puntos) {
		this.puntos += puntos;
	}
	/*public void lessPuntos() {
		if(puntos==0) puntos++;
	}*/

	/* Restar movimientos al jugador*/
	public void lessMovimientos() {
		if (movimientos > 0) movimientos--;
		
	}
}
