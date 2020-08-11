package candycrush;

public class CandyCrush {

	private Jugador jugador;
	private Candy [] candies;
	//private int [] valorPuntos;
	private String [][] tablero;
	public int size = 9;


	// Constructor

	public CandyCrush(String nombreJugador, int vidasJugador, int movJugador) {

		jugador = new Jugador(nombreJugador, vidasJugador, movJugador);

		candies = new Candy [5];
		candies[0] = new Candy("A", "Verde","/dulces/Dulce1.png");
		candies[1] = new Candy("B", "Azul","/dulces/Dulce2.png");
		candies[2] = new Candy("C", "Rojo","/dulces/Dulce3.png");
		candies[3] = new Candy("D", "Amarillo","/dulces/Dulce4.png");
		candies[4] = new Candy("E", "Negro","/dulces/Dulce5.png");
		//candies[5] = new Candy("F", "Rosa","/dulces/icono.png");

		//valorPuntos = new int [] {50, 100, 200};

		generarTablero();
	}

	// Funciones

	/* Generar un tablero aleatorio */
	public void generarTablero() {
		int aux = 0; 
		int dado=0;
		this.tablero = new String [9][9];
		for(int i=0;i<tablero.length;i++){ 
			for(int j=0;j<tablero[0].length;j++){
				aux = (int) (Math.random()*4); 
				dado=(int) Math.floor(Math.random()*4);
				switch (dado) {
				case 1:
					tablero[i][j]=candies[0].getImagen();
					break;
				case 2:
					tablero[i][j]=candies[1].getImagen();
					break;
				case 3:
					tablero[i][j]=candies[2].getImagen();
					break;
				case 4:
					tablero[i][j]=candies[3].getImagen();
					break;
				//case 5:
				//	tablero[i][j]=candies[4].getImagen();
				//	break;
				default:
					tablero[i][j]=candies[4].getImagen();
					break;
				}
				while(tablero[0][j]==tablero[1][j] ||tablero[2][j]==tablero[1][j]){
					aux = (int) (Math.random()*4+1); 
					tablero[1][j]=this.candies[aux].getImagen();

				}
				while(tablero[3][j]==tablero[4][j] || tablero[5][j]==tablero[4][j]){
					aux = (int) (Math.random()*4+1); 
					tablero[4][j]=this.candies[aux].getImagen();

				}
				while(tablero[6][j]==tablero[7][j] || tablero[8][j]==tablero[7][j]){
					aux = (int) (Math.random()*4+1); 
					tablero[7][j]=this.candies[aux].getImagen();

				}
				while(tablero[i][0]==tablero[i][1] || tablero[i][2]==tablero[i][1]){
					aux = (int) (Math.random()*4+1); 
					tablero[i][1]=this.candies[aux].getImagen();

				}
				while(tablero[i][3]==tablero[i][4] || tablero[i][5]==tablero[i][4]){
					aux = (int) (Math.random()*4+1); 
					tablero[i][4]=this.candies[aux].getImagen();

				}
				while(tablero[i][6]==tablero[i][7] || tablero[i][8]==tablero[i][7]){
					aux = (int) (Math.random()*4+1); 
					tablero[i][7]=this.candies[aux].getImagen();

				}
			}
		}
	}

	public String[][] getTablero() {
		return tablero;
	}    

	/* Validar rango de posiciones ingresadas */
	boolean validarRangoMovimiento(int iOrigen, int jOrigen, int iDestino, int jDestino) {
		return (iOrigen >= 0 && iOrigen <= 8 && jOrigen >= 0 && jOrigen <= 8 && iDestino >= 0 && iDestino <= 8 && jDestino >= 0 && jDestino <= 8);
	}

	/* Realizar un movimiento*/
	public boolean mover(int iOrigen, int jOrigen, int iDestino, int jDestino) {
		String aux2 = tablero[iOrigen][jOrigen];
		String aux3 = tablero[iDestino][jDestino];
		if (validarRangoMovimiento(iOrigen, jOrigen, iDestino, jDestino)) {
			if(iDestino==iOrigen||jDestino==jOrigen) {
				if(iDestino == iOrigen-1 || iDestino == iOrigen+1 ||jDestino == jOrigen-1 ||jDestino == jOrigen+1) {
					String aux = tablero[iDestino][jDestino];
					tablero[iDestino][jDestino] = tablero[iOrigen][jOrigen];
					tablero[iOrigen][jOrigen] = aux;
					if(puntos( iDestino, jDestino)==true) {
						//puntos( iDestino, jDestino);
						moverAbajo();
						llenarVacios();
						verificarTab();
						jugador.lessMovimientos();
						jugador.lessVidas();
						return true;
					}else
					tablero[iDestino][jDestino] = aux3;
					tablero[iOrigen][jOrigen] = aux2;
					jugador.lessMovimientos();
					jugador.lessVidas();
					return false;
				}
			}
		}
		jugador.lessMovimientos();
		jugador.lessVidas();
		return false;
	}

	//elimina y suma puntos
	public boolean puntos( int iDestino, int jDestino) {
		String aux= " ";
		//verificacion a la derecha


		while(jDestino<=6) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+2]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino+1]= aux;
				tablero[iDestino][jDestino+2]= aux;
				jugador.addPuntos(50);
				return true;

			} 
			break;
		} 
		while(jDestino<=5) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+2]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+3]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino+1]= aux;
				tablero[iDestino][jDestino+2]= aux;
				tablero[iDestino][jDestino+3]= aux;
				jugador.addPuntos(100);
				return true;

			} 
			break;
		}
		while(jDestino<=4) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+2]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+3]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+4])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino+1]= aux;
				tablero[iDestino][jDestino+2]= aux;
				tablero[iDestino][jDestino+3]= aux;
				tablero[iDestino][jDestino+4]= aux;
				jugador.addPuntos(200);
				return true;

			} 
			break;
		}
		while(jDestino<=3) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+2]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+3]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+4]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+5])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino+1]= aux;
				tablero[iDestino][jDestino+2]= aux;
				tablero[iDestino][jDestino+3]= aux;
				tablero[iDestino][jDestino+4]= aux;
				tablero[iDestino][jDestino+5]= aux;
				jugador.addPuntos(400);
				return true;

			} 
			break;
		}



		//verificacion a la izquierda
		while(jDestino<=8 && jDestino>=2) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-2]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino-1]= aux;
				tablero[iDestino][jDestino-2]= aux;
				jugador.addPuntos(50);
				return true;

			} 
			break;
		}
		while(jDestino<=8 && jDestino>=3) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-2]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-3]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino-1]= aux;
				tablero[iDestino][jDestino-2]= aux;
				tablero[iDestino][jDestino-3]= aux;
				jugador.addPuntos(100);
				return true;

			} 
			break;
		}
		while(jDestino<=8 && jDestino>=4) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-2]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-3]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-4])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino-1]= aux;
				tablero[iDestino][jDestino-2]= aux;
				tablero[iDestino][jDestino-3]= aux;
				tablero[iDestino][jDestino-4]= aux;
				jugador.addPuntos(200);
				return true;

			} 
			break;
		}
		while(jDestino<=8 && jDestino>=5) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-2]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-3]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-4]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-5])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino-1]= aux;
				tablero[iDestino][jDestino-2]= aux;
				tablero[iDestino][jDestino-3]= aux;
				tablero[iDestino][jDestino-4]= aux;
				tablero[iDestino][jDestino-5]= aux;
				jugador.addPuntos(400);
				return true;

			} 
			break;
		}

		//verificacion para abajo
		while(iDestino<=6) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino+1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+2][jDestino]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				jugador.addPuntos(50);
				return true;

			} 
			break;
		}
		while(iDestino<=5) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino+1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+2][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+3][jDestino]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				tablero[iDestino+2][jDestino]= aux;
				tablero[iDestino+3][jDestino]= aux;
				jugador.addPuntos(100);
				return true;

			} 
			break;
		}
		while(iDestino<=4) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino+1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+2][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+3][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+4][jDestino])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				tablero[iDestino+2][jDestino]= aux;
				tablero[iDestino+3][jDestino]= aux;
				tablero[iDestino+4][jDestino]= aux;
				jugador.addPuntos(200);
				return true;

			} 
			break;
		}
		while(iDestino<=3) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino+1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+2][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+3][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+4][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+5][jDestino])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				tablero[iDestino+2][jDestino]= aux;
				tablero[iDestino+3][jDestino]= aux;
				tablero[iDestino+4][jDestino]= aux;
				tablero[iDestino+5][jDestino]= aux;
				jugador.addPuntos(400);
				return true;

			} 
			break;
		}



		//verificacion para arriba
		while(iDestino<=8 && iDestino>=2) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino-1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-2][jDestino]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino-1][jDestino]= aux;
				tablero[iDestino-2][jDestino]= aux;
				jugador.addPuntos(50);
				return true;

			} 
			break;
		}
		while(iDestino<=8 && iDestino>=3) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino-1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-2][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-3][jDestino]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino-1][jDestino]= aux;
				tablero[iDestino-2][jDestino]= aux;
				tablero[iDestino-3][jDestino]= aux;
				jugador.addPuntos(100);
				return true;

			} 
			break;
		}
		while(iDestino<=8 && iDestino>=4) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino-1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-2][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-3][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-4][jDestino])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino-1][jDestino]= aux;
				tablero[iDestino-2][jDestino]= aux;
				tablero[iDestino-3][jDestino]= aux;
				tablero[iDestino-4][jDestino]= aux;
				jugador.addPuntos(200);
				return true;

			} 
			break;
		}
		while(iDestino<=8 && iDestino>=5) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino-1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-2][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-3][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-4][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-5][jDestino])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino-1][jDestino]= aux;
				tablero[iDestino-2][jDestino]= aux;
				tablero[iDestino-3][jDestino]= aux;
				tablero[iDestino-4][jDestino]= aux;
				tablero[iDestino-5][jDestino]= aux;
				jugador.addPuntos(400);
				return true;

			} 
			break;
		}



		//verificar si es centro 
		//jugada por abajo(+1) y arriba(-1)

		while(iDestino>=1 && iDestino<=7) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino-1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+1][jDestino]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino-1][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				jugador.addPuntos(50);
				return true;

			} 
			break;
		}
		//jugada por abajo(+2) y arriba(-2)
		while(iDestino>=2 && iDestino<=6) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino-2][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+2][jDestino])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino-2][jDestino]= aux;
				tablero[iDestino-1][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				tablero[iDestino+2][jDestino]= aux;
				jugador.addPuntos(200);
				return true;

			} 
			break;
		}
		//jugada por abajo(+2) y arriba(-1)
		while(iDestino<=6 && iDestino>=1) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino-1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+1][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino+2][jDestino]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino-1][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				tablero[iDestino+2][jDestino]= aux;
				jugador.addPuntos(100);
				return true;

			} 
			break;
		}
		//jugada por abajo(+1) y arriba(-2)
		while(iDestino<=7 && iDestino>=2) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino-2][jDestino]) && tablero[iDestino][jDestino].equals(tablero[iDestino-1][jDestino])&& tablero[iDestino][jDestino].equals(tablero[iDestino+1][jDestino]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino-1][jDestino]= aux;
				tablero[iDestino-2][jDestino]= aux;
				tablero[iDestino+1][jDestino]= aux;
				jugador.addPuntos(100);
				return true;

			} 
			break;
		}
		//verificar si es centro 
		//jugada por derecha(+1) e izquierda(-1)
		while(jDestino>=1 && jDestino<=7) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+1]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino-1]= aux;
				tablero[iDestino][jDestino+1]= aux;
				jugador.addPuntos(50);
				return true;

			} 
			break;
		}
		//jugada por derecha(+2) e izquierda(-2)
		while(jDestino>=2 && jDestino<=6) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-2]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+2])){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino-2]= aux;
				tablero[iDestino][jDestino-1]= aux;
				tablero[iDestino][jDestino+1]= aux;
				tablero[iDestino][jDestino+2]= aux;
				jugador.addPuntos(200);
				return true;

			} 
			break;
		}
		//jugada por derecha(+2) e izquierda(-1)
		while(jDestino<=6 && jDestino>=1) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+1]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+2]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino-1]= aux;
				tablero[iDestino][jDestino+1]= aux;
				tablero[iDestino][jDestino+2]= aux;
				jugador.addPuntos(100);
				return true;

			} 
			break;
		}
		//jugada por derecha(+1) e izquierda(-2)
		while(jDestino<=7 && jDestino>=2) {
			if(tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-2]) && tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino-1])&& tablero[iDestino][jDestino].equals(tablero[iDestino][jDestino+1]) ){
				tablero[iDestino][jDestino]= aux;
				tablero[iDestino][jDestino-1]= aux;
				tablero[iDestino][jDestino-2]= aux;
				tablero[iDestino][jDestino+1]= aux;
				jugador.addPuntos(100);
				return true;

			} 
			break;
		}


		return false;


	}
	// poner piezas abajo despues de eliminarlas
	public void moverAbajo(){
		for(int i=0;i<tablero.length;i++){
			for(int j=0;j<tablero[0].length;j++){
				while(i!=8 && this.tablero[i+1][j]==" " && this.tablero[i][j]!=" "){
					this.tablero[i+1][j]=this.tablero[i][j];
					this.tablero[i][j]=" ";
					i=0;
					j=0;
				}
			}
		}            
	}    
	//verificar tablero
    public void verificarTab() {
    	for(int i=0; i< 9; i++) {
    		for(int j=0; j<9;j++) {
    			puntos(i,j);
    			moverAbajo();
    			llenarVacios();
    		}
    	}
    	
    }


	// despues de mover todo abajo, esto llena los vacios que queden 
	public void llenarVacios(){
		for(int i=0;i<tablero.length;i++){
			for(int j=0;j<tablero[0].length;j++){
				if(this.tablero[i][j]==" "){                        
					int aux = (int) (Math.random()*4+1); 
					int dado=(int) Math.floor(Math.random()*4+1);
					switch (dado) {
					case 1:
						tablero[i][j]=candies[0].getImagen();
						break;
					case 2:
						tablero[i][j]=candies[1].getImagen();
						break;
					case 3:
						tablero[i][j]=candies[2].getImagen();
						break;
					case 4:
						tablero[i][j]=candies[3].getImagen();
						break;
					default:
						tablero[i][j]=candies[4].getImagen();
						break;
					}

					this.tablero[i][j]=this.candies[aux].getImagen();

				}

			}

		}
	}

/* Validar si seguir o no el juego*/

public boolean ganar() {
		boolean a;
		if(jugador.getVidas()>=0&&jugador.getPuntos()>=1000) { 
			a= true;
		}else
			a= true;
		return a;
	}
	public boolean perder() {
		if(jugador.getVidas()==0 && jugador.getMovimientos()==0&&jugador.getPuntos()<1000) { 
			
				return true;
		}else	
		
		return false;
	}
	public Jugador getJugador () {
		return this.jugador;
	}


	
	

	/* Imprimir resultado del juego*/
	public void resultado() {
		System.out.println("\n................RESULTADOS.................");
		System.out.println("Jugador: " + jugador.getNombre());
		System.out.println("Puntaje: " + jugador.getPuntos());
		System.out.println("Vidas: " + jugador.getVidas());
		System.out.println("Movimientos restantes: " + jugador.getMovimientos());
		System.out.println("...........................................\n");

	}

	/* Imprimir tablero y estado del juego*/
	public void printTablero() {
		System.out.println("\n...........................................\n");
		System.out.println("     0   1   2   3   4   5   6   7   8");
		System.out.println("   -------------------------------------");
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(" " + i + " | ");
			for (int j = 0; j < tablero[0].length; j++) {
				System.out.print(tablero[i][j] + " | ");
			}
			System.out.println();
			System.out.println("   -------------------------------------");
		}
		System.out.println("\nJugador: " + jugador.getNombre());
		System.out.println("Puntaje: " + jugador.getPuntos());
		System.out.println("Vidas: " + jugador.getVidas());
		System.out.println("Movimientos restantes: " + jugador.getMovimientos());
		System.out.println("...........................................\n");
	}
}
