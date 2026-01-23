package Inventariado;

public class Producto {

	int codigo;
	String nombre;
	double precio;
	int stock;
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
}