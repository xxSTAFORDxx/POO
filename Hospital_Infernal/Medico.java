package Hospital_Infernal;

public class Medico {

	String nombre;
	int añosTrabajados;
	double sueldo;
	String departamento;

	  public Medico() {
	        this.nombre = "Sin definir";
	        this.añosTrabajados = 0;
	        this.sueldo = 1000.0;
	        this.departamento ="Sin departamento";
	    }
	  public Medico(String nom) {
		  this.nombre = nom;
		  this.añosTrabajados = 0;
	        this.sueldo = 1000.0;
	        this.departamento="Sin departamento";
	    }
	    
	    public Medico(String nombre, int añosTrabajados) {
	        this(nombre);
	        for (int i = 0; i < añosTrabajados; i++) {
	            this.augmentarAñosTrabajados();
	        }
	    }
	
	public void diElNombre() {

		System.out.println(this.nombre);
	}
	public void augmentarAñosTrabajados() {
		this.añosTrabajados++;
		this.sueldo *=1.02;
		if (this.sueldo% 6 ==0) {
			this.sueldo *=1.05;
		}
		
	}
}