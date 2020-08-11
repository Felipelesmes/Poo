package candycrush;


public class Candy {
	private String dulce;
	private String color;
    private String imagen;
	
	// Constructor
	
	Candy (String dulce, String color, String imagen) {
		this.dulce  = dulce;
		this.color  = color;
        this.imagen = imagen;
	}

	// Getters y Setters
	
	public String getDulce() {
		return dulce;
	}

	public void setDulce(String dulce) {
		this.dulce = dulce;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
        
}