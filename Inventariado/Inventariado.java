package Inventariado;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventariado {

	public static ArrayList<Producto> productos = new ArrayList<>();
	public static ArrayList<Pedido> pedidos = new ArrayList<>();
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
		System.out.println("Escribe el código del producto (4 dígitos):");
		int comprobacionCodigo = sc.nextInt();
		sc.nextLine();
		int contadorCodigo = 0;
		if (comprobacionCodigo >= 1000 && comprobacionCodigo <= 9999) {
		} else {
			System.out.println("Error: El código debe tener exactamente 4 dígitos (1000-9999).");
			return;
		}
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).codigo == comprobacionCodigo) {
				contadorCodigo++;
			}

		}

		{
			if (contadorCodigo >= 1) {
				System.out.println("Error: Ya existe un producto con este código.");
				return;
			} else {
				p.codigo = comprobacionCodigo;
				System.out.println("Error: Codigo no repetido");
			}
		}
		System.out.println("Introduce el nombre del producto:");
		p.nombre = sc.nextLine();
		System.out.println("Introduce el precio del producto:");
		double comprobacionPrecio = sc.nextDouble();
		sc.nextLine();
		if (comprobacionPrecio > 0) {
			p.precio = comprobacionPrecio;
		} else {
			System.out.println("Error: El precio debe ser mayor que 0.");
			return;
		}
		sc.nextLine();
		System.out.println("Introduce el stock inicial:");
		int comprobacionStock = sc.nextInt();
		if (comprobacionStock >= 0) {
			p.stock = comprobacionStock;
		} else {
			System.out.println("Error: El stock inicial no puede ser negativo.");
			return;
		}
		sc.nextLine();
		productos.add(p);
		System.out.println("Producto añadido correctamente al inventario.");
	}

	public static void mostrarProducto() {
		System.out.println("--- LISTADO COMPLETO DE PEDIDOS ---");
		System.out.print(productos);
		System.out.println("-----------------------------------");
	}

	public static void modificarstock() {
		System.out.println("Introduce el código del producto a modificar:");
		int comprobacionCodigo = sc.nextInt();
		sc.nextLine();
		if (!(comprobacionCodigo >= 1000 && comprobacionCodigo <= 9999)) {
			System.out.println("Error: El codigo debe tener exactamente 4 dígitos (1000-9999).");
			return;
		}
		System.out.println("Introduce la cantidad (positiva para sumar, negativa para restar):");
		int modificarStock = sc.nextInt();
		sc.nextLine();
		boolean encontrado = false;
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).codigo == comprobacionCodigo) {
				encontrado = true;
				int stockNuevo = productos.get(i).stock + modificarStock;
				if (stockNuevo >= 0) {
					productos.get(i).stock = stockNuevo;
					System.out.println("Stock modificado con exito.");
				} else {
					System.out.println("Error: No hay suficiente stock disponible.");
				}
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Error: El producto con código " + comprobacionCodigo + " no existe.");
		}
	}

	public static void nuevoPedido() {
		Pedido p = new Pedido();

		System.out.println("-- Creando Nuevo Pedido --");
		System.out.println("DNI del cliente:");
		String dni = sc.nextLine();
		if (dni.length() == 9) {
			p.dni = dni;
		} else {
			System.out.println("Error: El DNI debe tener exactamente 9 caracteres.");
			return;
		}

		System.out.println("Código del producto a comprar:");
		int comprobacionCodigo = sc.nextInt();
		sc.nextLine();
		boolean productoencontrado = false;
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).codigo == comprobacionCodigo) {
				productoencontrado = true;
				System.out.println("Producto encontrado: " + productos.get(i).nombre);
				System.out.println("¿Cuántas unidades desea?");
				int cantidad = sc.nextInt();
				sc.nextLine();
				if (cantidad > 0 && productos.get(i).stock >= cantidad) {
					productos.get(i).stock-=cantidad;
				}
				System.out.println("Total a pagar:");
				System.out.println("--------------------------");
			}
			if (!productoencontrado) {
	            System.out.println("Error: El código de producto no existe.");
		}

	}}

	public static void verPedidoCliente() {
		System.out.println("Escribe el nombre del cliente para buscar sus pedidos:");
	}

	public static void verPedidos() {
		System.out.println("--- LISTADO COMPLETO DE PEDIDOS ---");
		System.out.println(pedidos);
		System.out.println("-----------------------------------");
	}

	public static void productoBajoMinimos() {
		boolean hayBajos = false;
		System.out.println("--- PRODUCTOS BAJO MÍNIMOS (Menos de 5 unidades) ---");
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).stock < 5) {
				System.out
						.println("Producto: " + productos.get(i).nombre + " | Stock actual: " + productos.get(i).stock);
				hayBajos = true;
			}
		}
		if (!hayBajos) {
			System.out.println("Todo en orden. No hay productos bajo mínimos.");
		}
		System.out.println("----------------------------------------------------");
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
		System.out.println("------------------------------------");
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
		System.out.println("-----------------------------");
		// Aquí pedirías el identificador del pedido

		System.out.println("Buscando pedido...");
		// Si se encuentra, podrías poner:
		System.out.println("¿Estás seguro de que deseas eliminar este pedido? (S/N):");
	}

}
