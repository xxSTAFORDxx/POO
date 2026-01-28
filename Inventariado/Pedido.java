package Inventariado;

public class Pedido {

	String dni;
	Producto prod;
	int cantidad;
	int codigoProducto;
	double importe;

	@Override
	public String toString() {
		return "Pedido [dni=" + dni + ", prod=" + prod + ", cantidad=" + cantidad + ", codigoProducto=" + codigoProducto
				+ ", importe=" + importe + "]";
	}

}
