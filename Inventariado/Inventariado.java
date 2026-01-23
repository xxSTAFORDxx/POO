package Inventariado;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventariado {

	public static ArrayList<Producto> lista = new ArrayList<>();
	public static ArrayList<Pedido> lista2 = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("INVENTARIADO");

		boolean sortir = false;
		while (!sortir) {
			System.out.println("                                 ");
			System.out.println("1. Añadir producto.");
			System.out.println("2. Mostrar todos los productos.");
			System.out.println("3. Modificar stock.");
			System.out.println("4. Nuevo pedido.");
			System.out.println("5. Ver pedidos de un cliente.");
			System.out.println("6. Ver todos los pedidos.");
			System.out.println("7. Productos bajo minimos.");
			System.out.println("8. Mostrar el total de ventas.");
			System.out.println("9. Mostrar el producto mas vendido.");
			System.out.println("10. Añadir descuento.");
			System.out.println("11. Mostrar informe cliente VIP.");
			System.out.println("12. Cancelar pedido.");
			System.out.println("13. Sortir del programa.");
			System.out.println("-----------");
			System.out.println("-----------");
			System.out.println("Escull una opcio:");
			int opcio = sc.nextInt();
			sc.nextLine();
			switch (opcio) {
			case 1:
				añadirProducto();
				break;
			case 2:
				mostrarProducto();
				break;
			case 3:
				modificarstock();
				break;
			case 4:
				nuevoPedido();
				break;
			case 5:
				verPedidoCliente();
				break;
			case 6:
				verPedidos();
				break;
			case 7:
				productoBajoMinimos();
				break;
			case 8:
				mostrarTotalVentas();
				break;
			case 9:
				productoMasVendido();
				break;
			case 10:
				añadirDescuento();
				break;
			case 11:
				informeCliente();
				break;
			case 12:
				cancelarPedido();
				break;
			case 13:
				sortir = true;
				break;
			}
		}
	}

	public static void añadirProducto() {
		Producto p = new Producto();
		System.out.println("Escribe el codigo del producto");
		int comprobacionCodigo =sc.nextInt();
		if(lista.codigo.contains(comprobacionCodigo))
		p.codigo = sc.nextInt(); // contains aq
		sc.nextLine();
		System.out.println("Escribe el nombre del producto");
		p.nombre = sc.nextLine();
		System.out.println("Escribe el precio del producto");
		double comprobacionPrecio = sc.nextDouble();
		if (comprobacionPrecio > 0) {
			p.precio = comprobacionPrecio;
		} else {
			System.out.println("Introduce un numero mas grande que 0");
		}
		sc.nextLine();
		System.out.println("Escribe el stock del producto");
		int comprobacionStock = sc.nextInt();
		if (comprobacionStock > 0) {
			p.stock = comprobacionStock;
		} else {
			System.out.println("Introduce un stock mas grande que 0");
		}
		sc.nextLine();
		lista.add(p);
	}

	public static void mostrarProducto() {
		System.out.print(lista);
	}

	public static void modificarstock() {
		System.out.println("Introduce el código del producto a modificar:");
		// ... leer código ...
		System.out.println("Introduce la cantidad (positiva para sumar, negativa para restar):");
		// ... leer cantidad ...
	}

	public static void nuevoPedido() {
		System.out.println("-- Creando Nuevo Pedido --");
		System.out.println("Nombre del cliente:");
		System.out.println("Código del producto a comprar:");
		System.out.println("Cantidad de unidades:");
	}

	public static void verPedidoCliente() {
		System.out.println("Escribe el nombre del cliente para buscar sus pedidos:");
	}

	public static void verPedidos() {
		System.out.println("--- LISTADO COMPLETO DE PEDIDOS ---");
	}

	public static void productoBajoMinimos() {
		boolean hayBajos = false;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).stock < 5) {
				System.out.println(lista.get(i).nombre + " " + lista.get(i).stock);
			}
		}
		if (!hayBajos) {
			System.out.println("No hay productos bajo minimos.");
		}
	}

	public static void mostrarTotalVentas() {
		System.out.println("Calculando el total de ingresos por ventas...");
		System.out.print("El total vendido es: ");
	}

	public static void productoMasVendido() {
		System.out.println("El producto más vendido hasta ahora es:");
	}

	public static void añadirDescuento() {
		System.out.println("--- APLICAR DESCUENTO A PRODUCTO ---");
	    System.out.print("Introduce el código del producto: ");
	 // Aquí pedirías el código
	    System.out.print("Introduce el porcentaje de descuento (ej: 10 para 10%): ");
	 // Aquí pedirías el descuento
	    System.out.println("Calculando nuevo precio...");
	}

	public static void informeCliente() {
		System.out.println("--- GENERANDO INFORME DE CLIENTES VIP ---");
	    System.out.println("Criterio: Clientes con compras superiores a 500€");
	    System.out.println("-------------------------------------------------");
	    System.out.println("CLIENTE\t\tTOTAL GASTADO\tPEDIDOS REALIZADOS");
	 // Aquí iría el bucle para mostrar los datos
	}

	public static void cancelarPedido() {
		System.out.println("--- CANCELACIÓN DE PEDIDO ---");
	    System.out.print("Introduce el ID o número del pedido que deseas cancelar: ");
	    // Aquí pedirías el identificador del pedido
	    
	    System.out.println("Buscando pedido...");
	    // Si se encuentra, podrías poner:
	    System.out.println("¿Estás seguro de que deseas eliminar este pedido? (S/N):");
	}

}
