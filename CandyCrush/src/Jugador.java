import java.util.Scanner;
public class Jugador {
	private String nombre;
    private int NumMovimientos;
    private int NumVidas;
    
    public Jugador(String nuevoNombre)
    {
        nombre = nuevoNombre; //Se le da un nombre
    }
    public String getNombre()//Método para obtener el nombre del animal
    {
    	Scanner nom = new Scanner (System.in); //Creación de un objeto Scanner
    	nombre = nom.nextLine (); //Invocamos un método sobre un objeto Scanner
    	System.out.println ("Entrada recibida por teclado es: \"" + nombre +"\"");
        return nombre;
    }
    public void setNumVidas(int nuevoNumVidas)
    {
        NumVidas = nuevoNumVidas;
    }
    public void setNumMovimientos(int nuevoNumMovimientos)
    {
    	NumMovimientos = nuevoNumMovimientos;
    }
}
