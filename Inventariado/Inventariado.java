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
			System.out.println("12. Salir del programa.");
			System.out.println("-----------");
			System.out.println("-----------");
			System.out.println("Elige una opcion:");
			int opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
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
			}
		}
		System.out.println("Introduce el nombre del producto:");
		p.nombre = sc.nextLine();
		System.out.println("Introduce el precio del producto:");
		double comprobacionPrecio = sc.nextDouble();
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
		double precioTotal = 0;
		boolean productoencontrado = false;
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).codigo == comprobacionCodigo) {
				productoencontrado = true;
				System.out.println("Producto encontrado: " + productos.get(i).nombre);
				System.out.println("¿Cuántas unidades desea?");
				int cantidad = sc.nextInt();
				sc.nextLine();
				if (cantidad > 0 && productos.get(i).stock >= cantidad) {
					productos.get(i).stock -= cantidad;
				}
				precioTotal = cantidad * productos.get(i).precio;
				System.out.println("Total a pagar:" + precioTotal + "€");
				System.out.println("--------------------------");
			}
			if (!productoencontrado) {
				System.out.println("Error: El código de producto no existe.");
			}

		}
	}

	public static void verPedidoCliente() {
		System.out.println("Escribe el DNI para buscar sus pedidos:");
		String comprobacionDNI = sc.nextLine();
		if (comprobacionDNI.length() != 9) {
			System.out.println("Error: El DNI debe tener 9 caracteres.");
			return;
		}
		System.out.println("--- LISTADO COMPLETO DE PEDIDOS DE " + comprobacionDNI + " ---");
		boolean encontrado = false;
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).dni.equals(comprobacionDNI)) {
				System.out.println(pedidos.get(i));
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No se han encontrado pedidos para este cliente.");
		}
	}

	public static void verPedidos() {
		System.out.println("--- LISTADO COMPLETO DE PEDIDOS ---");
		if (pedidos.isEmpty()) {
			System.out.println("No hay ningún pedido registrado todavía.");
		} else {
			for (int i = 0; i < pedidos.size(); i++) {
				System.out.println((i + 1) + ". " + pedidos.get(i));
			}
		}
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
		System.out.println("--- BALANCE DE INGRESOS ---");
		double totalVentas = 0;
		if (pedidos.isEmpty()) {
			System.out.println("Todavía no se han realizado ventas.");
		} else {
			for (int i = 0; i < pedidos.size(); i++) {
				totalVentas += pedidos.get(i).importe;
			}
			System.out.println("El total vendido acumulado es: " + totalVentas + "€");
		}
		System.out.println("---------------------------");
	}

	public static void productoMasVendido() {
		int uMasVendida = 0;
		String pMasVendido = "";

		if (pedidos.isEmpty()) {
			System.out.println("No hay ventas registradas todavía.");
			return;
		}

		for (int i = 0; i < productos.size(); i++) {
			int sumaVentas = 0;
			int codigo = productos.get(i).codigo;

			for (int j = 0; j < pedidos.size(); j++) {
				if (pedidos.get(j).codigoProducto == codigo) {
					sumaVentas += pedidos.get(j).cantidad;
				}
			}

			if (sumaVentas > uMasVendida) {
				uMasVendida = sumaVentas;
				pMasVendido = productos.get(i).nombre;
			}
		}
		if (uMasVendida > 0) {
			System.out.println("El producto más vendido es: " + pMasVendido);
			System.out.println("Total unidades vendidas: " + uMasVendida);
		} else {
			System.out.println("No se han vendido unidades todavía.");
		}
	}

	public static void añadirDescuento() {
		System.out.println("--- APLICAR DESCUENTO A PRODUCTO ---");
		int codigo = sc.nextInt();
		sc.nextLine();
		boolean descuento = false;
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).cantidad > 5 && pedidos.get(i).codigoProducto == codigo) {
				double importeActual = pedidos.get(i).importe;
				double totalDescuento = importeActual * 0.95;
				pedidos.get(i).importe = totalDescuento;

				System.out.println("Pedido de cliente " + pedidos.get(i).dni + " actualizado. Nuevo total: "
						+ totalDescuento + "€");
				descuento = true;
			}
		}
		if (!descuento) {
			System.out.println("No se han encontrado pedidos que superen las 5 unidades.");
		} else {
			System.out.println("¡Proceso de descuentos completado!");
			System.out.println("------------------------------------");
		}
	}

	public static void informeCliente() {
		System.out.println("--- GENERANDO INFORME DE CLIENTES VIP ---");
		System.out.println("Criterio: Clientes con compras superiores a 1000€");
		ArrayList<String> dnisComprobados = new ArrayList<>();
		boolean hayVips = false;
		for (int i = 0; i < pedidos.size(); i++) {
			String dni = pedidos.get(i).dni;
			if (!dnisComprobados.contains(dni)) {
				double gastoTotal = 0;
				for (int j = 0; j < pedidos.size(); j++) {
					if (pedidos.get(j).dni.equals(dni)) {
						gastoTotal += pedidos.get(j).importe;
					}
				}
				if (gastoTotal > 1000) {
					System.out.println("Cliente DNI: " + dni + " | Gasto Total: " + gastoTotal + "€");
					hayVips = true;
				}

			}
			dnisComprobados.add(dni);
		}
		if (!hayVips)

		{
			System.out.println("No hay clientes que superen los 1000€ de gasto.");
		}
		System.out.println("-------------------------------------------");
	}

}