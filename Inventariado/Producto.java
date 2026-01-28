package Inventariado;

public class Producto {

	public int codigo;
	public String nombre;
	public double precio;
	public int stock;

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
}