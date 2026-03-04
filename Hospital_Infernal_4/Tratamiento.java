package Hospital_Infernal_4;

public class Tratamiento {

	private String nom;
	private int cantidad;

	public Tratamiento(String nom) {
	this.nom =nom;
	this.cantidad = 1;
	
	}
	public String getNom() {
		return nom;
	}

	public int getCantidad() {
		return cantidad;
	}
}
