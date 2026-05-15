using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;
using System;
using System.Collections.Generic;
using System.Numerics;
using System.Text;
using Wikigacha;
using static System.Runtime.InteropServices.JavaScript.JSType;
//namespace es com el package
namespace WikiGacha
{
    //el program es com el Test a l'hospital
    public class Program
    {
        //EL PROGRAM ES LA UNICA CLASSE QUE TINDRA MAIN
        static void Main(string[] args)
        {

            //AQUI FEM UN NOU CONTEXT
            using (var ctx = new WikiGachaContext())
            {
                CartaService cartaService = new CartaService(ctx);
                UsuarioService usuarioService = new UsuarioService(ctx);


                //Borra la BD. Aquesta linea es util quan esteu fent proves
                ctx.Database.EnsureDeleted();

                //Crea la BD. Aquesta linea hauria d'estar SEMPRE
                ctx.Database.EnsureCreated();

                // 2. CREACIÓN DE USUARIOS
                Console.WriteLine("Cargando usuarios iniciales...");
                Usuario arnau = new Usuario { Nombre = "Arnau", Nivel = 5, Monedas = 1000 };
                Usuario laia = new Usuario { Nombre = "Laia", Nivel = 12, Monedas = 2500 };
                Usuario pol = new Usuario { Nombre = "Pol", Nivel = 1, Monedas = 500 };

                ctx.Usuario.AddRange(arnau, laia, pol);

                // 3. CREACIÓN DE CARTAS
                Carta germanCuisine = new Carta()
                {
                    Nombre = "German cuisine",
                    Rareza = "Legendary",
                    Idioma = "EN",
                    Ataque = 8500,
                    Defensa = 7200,
                    Descripción = "German cuisine varies greatly depending on the region."
                };
                Carta gatPersa = new Carta()
                {
                    Nombre = "Gat persa",
                    Rareza = "Rara",
                    Idioma = "CA",
                    Ataque = 3200,
                    Defensa = 4100,
                    Descripción = "Raça de gat domèstic de pèl llarg."
                };
                Carta battleOfMidway = new Carta()
                {
                    Nombre = "Battle of Midway",
                    Rareza = "Epic",
                    Idioma = "EN",
                    Ataque = 6700,
                    Defensa = 5500,
                    Descripción = "Decisive naval battle of the Pacific."
                };
                Carta programacio = new Carta()
                {
                    Nombre = "Programació",
                    Rareza = "poc comú",
                    Idioma = "CA",
                    Ataque = 2100,
                    Defensa = 1800,
                    Descripción = null
                };
                Carta tablaPeriodica = new Carta()
                {
                    Nombre = "Tabla Periódica",
                    Rareza = "Rara",
                    Idioma = "SPA",
                    Ataque = 4000,
                    Defensa = 6200,
                    Descripción = "Los elementos químicos ordenados."
                };
                Carta castellers = new Carta()
                {
                    Nombre = "Castellers",
                    Rareza = "Èpica",
                    Idioma = "CA",
                    Ataque = 5800,
                    Defensa = 7100,
                    Descripción = "Tradició cultural catalana."
                };
                Carta gatPersa2 = new Carta()
                {
                    Nombre = "Gat persa",
                    Rareza = "Rara",
                    Idioma = "CA",
                    Ataque = 3200,
                    Defensa = 4100,
                    Descripción = "Raça de gat domèstic de pèl llarg.",
                    Repetida = true
                };
                Carta cargolDeMar = new Carta()
                {
                    Nombre = "Castellers",
                    Rareza = "Èpica",
                    Idioma = "CA",
                    Ataque = 5800,
                    Defensa = 7100
                };
                Carta mountEverest = new Carta()
                {
                    Nombre = "Castellers",
                    Rareza = "Èpica",
                    Idioma = "CA",
                    Ataque = 5800,
                    Defensa = 7100
                };
                Carta revolucionFrancesa = new Carta()
                {
                    Nombre = "Revolución Francesa",
                    Rareza = "Epica",
                    Idioma = "SPA",
                    Ataque = 5800,
                    Defensa = 7100
                };
                Carta formiga = new Carta()
                {
                    Nombre = "Formiga",
                    Rareza = "Comú",
                    Idioma = "CA",
                    Ataque = 500,
                    Defensa = 900
                };

                //Es fa un insert en la DB
                ctx.Carta.Add(germanCuisine);
                ctx.Carta.Add(gatPersa);
                ctx.Carta.Add(battleOfMidway);
                ctx.Carta.Add(tablaPeriodica);
                ctx.Carta.Add(programacio);
                ctx.Carta.Add(castellers);
                ctx.Carta.Add(gatPersa2);
                ctx.Carta.Add(cargolDeMar);
                ctx.Carta.Add(mountEverest);
                ctx.Carta.Add(revolucionFrancesa);
                ctx.Carta.Add(formiga);

                // 2.3 — Crear Sobres i assignar-los

                // --- SOBRES DE ARNAU ---
                Sobre sobreNormalArnau = new Sobre { Nombre = "Sobre Normal", Rareza = RarezaSobre.Normal, NumCartas = 3, Precio = 100, Usuario = arnau };
                sobreNormalArnau.Cartas.Add(tablaPeriodica);
                sobreNormalArnau.Cartas.Add(cargolDeMar);
                sobreNormalArnau.Cartas.Add(formiga);

                Sobre sobreDoradoArnau = new Sobre { Nombre = "Sobre Dorado", Rareza = RarezaSobre.Dorado, NumCartas = 3, Precio = 300, Usuario = arnau };
                sobreDoradoArnau.Cartas.Add(gatPersa);
                sobreDoradoArnau.Cartas.Add(programacio);
                sobreDoradoArnau.Cartas.Add(castellers);

                // --- SOBRES DE LAIA ---
                Sobre sobreGeografiaLaia = new Sobre { Nombre = "Sobre de Geografia", Rareza = RarezaSobre.Normal, NumCartas = 3, Precio = 100, Usuario = laia };
                sobreGeografiaLaia.Cartas.Add(mountEverest);
                sobreGeografiaLaia.Cartas.Add(cargolDeMar);
                sobreGeografiaLaia.Cartas.Add(formiga);

                Sobre sobreArcoirisLaia = new Sobre { Nombre = "Sobre Arcoiris", Rareza = RarezaSobre.Arcoiris, NumCartas = 2, Precio = 500, Usuario = laia };
                sobreArcoirisLaia.Cartas.Add(germanCuisine);
                sobreArcoirisLaia.Cartas.Add(battleOfMidway);

                // --- SOBRES DE POL ---
                Sobre sobreInicialPol = new Sobre { Nombre = "Sobre Inicial", Rareza = RarezaSobre.Normal, NumCartas = 2, Precio = 0, Usuario = pol };
                sobreInicialPol.Cartas.Add(formiga);
                sobreInicialPol.Cartas.Add(programacio);

                // Añadimos los sobres al contexto
                ctx.Sobre.AddRange(sobreNormalArnau, sobreDoradoArnau, sobreGeografiaLaia, sobreArcoirisLaia, sobreInicialPol);

                // IMPORTANTE: Un solo SaveChanges al final de toda la configuración guardará 
                // los usuarios, las cartas, los sobres y todas sus relaciones (tablas intermedias).
                ctx.SaveChanges();

                Console.WriteLine("Base de datos inicializada con Usuarios, Sobres y Cartas.");


                // --- PUNTO 2: Limpieza de pantalla al inicio de cada ciclo ---
                // Esto borra el menú anterior y los resultados de la operación pasada
                Console.Clear(); // Descomenta esta línea si quieres que el menú siempre esté arriba del todo

                string opcionPrincipal = "";
                while (opcionPrincipal != "0")
                {
                    Console.Clear();
                    Console.WriteLine("==========================================");
                    Console.WriteLine("       WIKIGACHA - SISTEMA CENTRAL        ");
                    Console.WriteLine("==========================================");
                    Console.WriteLine("1. Centro de usuario. (Usuarios y Colecciones)");
                    Console.WriteLine("2. Tienda. (Comprar y Abrir sobres)");
                    Console.WriteLine("3. Rankings y estadísticas.");
                    Console.WriteLine("4. Administración. (Gestión CRUD de Cartas)");
                    Console.WriteLine("0. Salir.");
                    Console.WriteLine("------------------------------------------");
                    Console.Write("Selecciona una sección: ");
                    opcionPrincipal = Console.ReadLine();

                    switch (opcionPrincipal)
                    {
                        case "1": MenuPerfil(ctx, usuarioService); break;
                        case "2": MenuTienda(usuarioService); break;
                        case "3": MenuRankings(usuarioService, cartaService); break;
                        case "4": MenuGestionCartas(cartaService); break;
                        case "0": Console.WriteLine("Saliendo del programa..."); break;
                        default:
                            Console.WriteLine("Opción no válida. Presiona una tecla...");
                            Console.ReadKey();
                            break;
                    }
                }
            }
        }

        // ==========================================
        // SUBMENÚ 1: PERFIL
        // ==========================================
        static void MenuPerfil(WikiGachaContext ctx, UsuarioService usuarioService)
        {
            string sub = "";
            while (sub != "0")
            {
                Console.Clear();
                Console.WriteLine("=== CENTRO DE USUARIO ===");
                Console.WriteLine("1. Mostrar todos los usuarios.");
                Console.WriteLine("2. Mostrar sobres de un usuario.");
                Console.WriteLine("3. Mostrar colección de un usuario.");
                Console.WriteLine("0. Volver al menú principal.");
                Console.Write("\nSelecciona: ");
                sub = Console.ReadLine().ToLower();

                switch (sub)
                {
                    case "1":
                        usuarioService.MostrarTodosLosUsuarios();
                        break;
                    case "2":
                        Console.Write("Introduce el nombre del usuario: ");
                        string nom = Console.ReadLine();
                        usuarioService.MostrarSobresUsuario(nom);
                        break;
                    case "3":
                        Console.Write("Introduce el nombre del usuario: ");
                        string nomCol = Console.ReadLine();
                        usuarioService.MostrarColeccion(nomCol);
                        break;
                }
                if (sub != "0") { Console.WriteLine("\nPresiona una tecla para volver atras"); Console.ReadKey(); }
            }
        }

        // ==========================================
        // SUBMENÚ 2: TIENDA
        // ==========================================
        static void MenuTienda(UsuarioService usuarioService)
        {
            string sub = "";
            while (sub != "0")
            {
                Console.Clear();
                Console.WriteLine("=== TIENDA ===");
                Console.WriteLine("1. Abrir un sobre. (por ID)");
                Console.WriteLine("2. Comprar un sobre. (por ID y Rareza)");
                Console.WriteLine("3. Mostrar sobres sin abrir.");
                Console.WriteLine("0. Volver al menú principal.");
                Console.Write("\nSelecciona: ");
                sub = Console.ReadLine().ToLower();

                switch (sub)
                {
                    case "1":
                        Console.Write("Introduce el ID del sobre a abrir: ");
                        if (int.TryParse(Console.ReadLine(), out int idSobre))
                            usuarioService.AbrirSobre(idSobre);
                        else Console.WriteLine("ID no válido.");
                        break;
                    case "2":
                        Console.Write("Introduce el ID del usuario: ");
                        string usuarioID = Console.ReadLine();
                        Console.Write("Rareza deseada (Normal, Dorado, Arcoiris): ");
                        string rareza = Console.ReadLine();

                        bool comprobacionID = int.TryParse(usuarioID, out int usuarioIDFinal);
                        bool comprobacionRareza = Enum.TryParse(rareza, true, out RarezaSobre rarezafinal);

                        if (comprobacionID && comprobacionRareza)
                        {
                            bool exito = usuarioService.ComprarSobre(usuarioIDFinal, rarezafinal);
                            if (exito) Console.WriteLine("✨ ¡Compra completada con éxito!");
                            else Console.WriteLine("❌ La compra falló (¿Saldo insuficiente?).");
                        }
                        else
                        {
                            Console.WriteLine("Error: ID o Rareza incorrectos.");
                        }
                        break;
                    case "3":
                        usuarioService.SobresSinAbrir();
                        break;
                }
                if (sub != "0") { Console.WriteLine("\nPresiona una tecla para volver atras"); Console.ReadKey(); }
            }
        }

        // ==========================================
        // SUBMENÚ 3: RANKINGS
        // ==========================================
        static void MenuRankings(UsuarioService usuarioService, CartaService cartaService)
        {
            string sub = "";
            while (sub != "0")
            {
                Console.Clear();
                Console.WriteLine("=== RANKINGS Y ESTADÍSTICAS ===");
                Console.WriteLine("1. Usuario con más cartas.");
                Console.WriteLine("2. Valor total de una colección.");
                Console.WriteLine("3. Mostrar la carta más poderosa.");
                Console.WriteLine("0. Volver al menú principal.");
                Console.Write("\nSelecciona: ");
                sub = Console.ReadLine().ToLower();

                switch (sub)
                {
                    case "1": usuarioService.UsuarioConMasCartas(); break;
                    case "2":
                        Console.Write("Nombre del usuario: ");
                        string nombreUsuario = Console.ReadLine();
                        usuarioService.ValorColeccion(nombreUsuario);
                        break;
                    case "3": cartaService.CartaMasPoderosa(); break;
                }
                if (sub != "0") { Console.WriteLine("\nPresiona una tecla para volver atras"); Console.ReadKey(); }
            }
        }

        // ==========================================
        // SUBMENÚ 4: ADMINISTRACIÓN (CRUD CARTAS)
        // ==========================================
        static void MenuGestionCartas(CartaService cartaService)
        {
            int op = -1;
            while (op != 0)
            {
                Console.Clear();
                Console.WriteLine("=== ADMINISTRACIÓN DE CARTAS (CRUD) ===");
                Console.WriteLine("1. Mostrar todas.");
                Console.WriteLine("2. Por Rareza.");
                Console.WriteLine("3. Buscar por ID.");
                Console.WriteLine("4. Añadir carta.");
                Console.WriteLine("5. Mejorar.");
                Console.WriteLine("6. Eliminar.");
                Console.WriteLine("7. Idioma.");
                Console.WriteLine("8. Batalla.");
                Console.WriteLine("9. Repetidas.");
                Console.WriteLine("0. Volver al menú principal");
                Console.Write("\nOpción: ");

                if (!int.TryParse(Console.ReadLine(), out op)) op = 0;

                switch (op)
                {
                    case 1: cartaService.MostrarTodas(); break;
                    case 2: cartaService.ContarCartas(); break;
                    case 3:
                        Console.Write("ID de la carta: ");
                        if (int.TryParse(Console.ReadLine(), out int id)) cartaService.BuscarPorID(id);
                        break;
                    case 4:
                        // Lógica simplificada de añadir
                        Console.Write("Nombre: "); string n = Console.ReadLine();
                        Console.Write("Rareza: "); string r = Console.ReadLine();
                        Console.Write("Ataque: "); int atk = int.Parse(Console.ReadLine());
                        Console.Write("Defensa: "); int def = int.Parse(Console.ReadLine());
                        cartaService.AñadirCarta(n, r, "ES", atk, def, "");
                        break;
                    case 5:
                        Console.Write("ID a mejorar: "); int idM = int.Parse(Console.ReadLine());
                        cartaService.MejorarCarta(idM, 10, 10);
                        break;
                    case 6:
                        Console.Write("ID a eliminar: "); int idE = int.Parse(Console.ReadLine());
                        cartaService.EliminarCarta(idE);
                        break;
                    case 8:
                        Console.Write("ID Carta 1: "); int c1 = int.Parse(Console.ReadLine());
                        Console.Write("ID Carta 2: "); int c2 = int.Parse(Console.ReadLine());
                        cartaService.FuncionBatalla(c1, c2);
                        break;
                    case 9:
                        cartaService.EliminarCartasRepetidas();
                        break;
                }
                if (op != 0) { Console.WriteLine("\nPresiona una tecla para volver atras"); Console.ReadKey(); }
            }
        }
    }
}