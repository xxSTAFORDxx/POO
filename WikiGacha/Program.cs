using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Numerics;
using System.Text;
using WikiGacha;
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


                //Borra la BD. Aquesta linea es util quan esteu fent proves
                ctx.Database.EnsureDeleted();

                //Crea la BD. Aquesta linea hauria d'estar SEMPRE
                ctx.Database.EnsureCreated();

                //CARTAS


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

                //Es fa un insert en la DB
                ctx.Carta.Add(germanCuisine);
                ctx.Carta.Add(gatPersa);
                ctx.Carta.Add(battleOfMidway);
                ctx.Carta.Add(tablaPeriodica);
                ctx.Carta.Add(programacio);
                ctx.Carta.Add(castellers);
                ctx.Carta.Add(gatPersa2);

                ctx.SaveChanges();

                Console.WriteLine("=== WIKIGACHA - Gestor de Colección ===");

                int opcion;
                do
                {
                    // --- PUNTO 2: Limpieza de pantalla al inicio de cada ciclo ---
                    // Esto borra el menú anterior y los resultados de la operación pasada
                    // Console.Clear(); // Descomenta esta línea si quieres que el menú siempre esté arriba del todo

                    Console.WriteLine("\n=== WIKIGACHA - Gestor de Colección ===");
                    Console.WriteLine("1. Mostrar totas las cartas.");
                    Console.WriteLine("2. Mostrar las cartas por cada rareza.");
                    Console.WriteLine("3. Buscar carta por ID.");
                    Console.WriteLine("4. Añadir nueva carta.");
                    Console.WriteLine("5. Mejorar carta.");
                    Console.WriteLine("6. Eliminar carta por ID.");
                    Console.WriteLine("7. Mostrar cartas por idioma.");
                    Console.WriteLine("8. Mostrar la carta mas poderosa.");
                    Console.WriteLine("9. Eliminar todas las repetidas.");
                    Console.WriteLine("10. Simular Batalla entre dos cartas.");
                    Console.WriteLine("11. Salir del programa.");
                    Console.WriteLine("-----------");
                    Console.WriteLine("-----------");
                    Console.WriteLine("Elige una opcion:");

                    if (!int.TryParse(Console.ReadLine(), out opcion))
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("Error: ¡Debes introducir un número!");
                        Console.ResetColor();
                        opcion = 0; 
                    }

                    Console.WriteLine("                                 ");

                    switch (opcion)
                    {
                        case 1:

                            Console.WriteLine("Mostrando todas las cartas...");
                            cartaService.MostrarTodas();

                            break;
                        case 2:

                            cartaService.ContarCartas();

                            break;
                        case 3:

                            Console.Write("Introduce el ID de la carta: ");
                            if (int.TryParse(Console.ReadLine(), out int IDCarta))
                            {
                                cartaService.BuscarPorID(IDCarta);
                            }
                            else Console.WriteLine("ID no válido.");

                            break;
                        case 4:

                            Console.WriteLine("Añadiendo nueva carta...");

                            Console.Write("Nombre: ");
                            string NombreCarta = Console.ReadLine();

                            Console.Write("Rareza: ");
                            string RarezaCarta = Console.ReadLine();

                            Console.Write("Idioma: ");
                            string IdiomaCarta = Console.ReadLine();

                            Console.Write("Ataque: ");
                            if (!int.TryParse(Console.ReadLine(), out int AtaqueCarta))
                            {
                                Console.WriteLine("Valor no válido."); break;
                            }

                            Console.Write("Defensa: ");
                            if (!int.TryParse(Console.ReadLine(), out int DefensaCarta))
                            {
                                Console.WriteLine("Valor no válido."); break;
                            }

                            Console.Write("Descripción: ");
                            string DescripcionCarta = Console.ReadLine();
                            cartaService.AñadirCarta(NombreCarta, RarezaCarta, IdiomaCarta, AtaqueCarta, DefensaCarta, DescripcionCarta);

                            break;
                        case 5:

                            Console.WriteLine("Mejorando carta...");

                            Console.WriteLine("Dime el ID de la carta a mejorar.");
                            if (!int.TryParse(Console.ReadLine(), out int IDMejorar))
                            {
                                Console.WriteLine("Error: El ID debe ser un número entero.");
                                break;
                            }

                            Console.Write("Introduce bonus de ataque: ");
                            if (!int.TryParse(Console.ReadLine(), out int BonusAtaque))
                            {
                                Console.WriteLine("Error: El bonus de ataque debe ser un número.");
                                break;
                            }

                            Console.Write("Introduce bonus de defensa: ");
                            if (!int.TryParse(Console.ReadLine(), out int BonusDefensa))
                            {
                                Console.WriteLine("Error: El bonus de defensa debe ser un número.");
                                break;
                            }
                            cartaService.MejorarCarta(IDMejorar, BonusAtaque, BonusDefensa);

                            break;
                        case 6:

                            Console.WriteLine("Eliminando carta...");

                            Console.Write("Introduce el ID de la carta a eliminar: ");
                            if (!int.TryParse(Console.ReadLine(), out int IDEliminar))
                            {
                                Console.WriteLine("ID no válido. Debe ser un número.");
                                break;
                            }
                            cartaService.EliminarCarta(IDEliminar);

                            break;
                        case 7:

                            Console.Write("Introduce el idioma: ");
                            string Idioma = Console.ReadLine();
                            cartaService.FiltrarPorIdioma(Idioma);

                            break;
                        case 8:

                            Console.WriteLine("Buscando la carta más poderosa...");
                            cartaService.CartaMasPoderosa();

                            break;
                        case 9:

                            Console.WriteLine("Eliminando cartas repetidas...");
                            cartaService.EliminarCartasRepetidas();

                            break;
                        case 10:
                            Console.WriteLine("=== ARENA DE COMBATE ===");

                            Console.Write("Introduce el ID de la primera carta: ");
                            if (!int.TryParse(Console.ReadLine(), out int ID1))
                            {
                                Console.WriteLine("ID no válido. Debe ser un número.");
                                break;
                            }

                            Console.Write("Introduce el ID de la segunda carta: ");
                            if (!int.TryParse(Console.ReadLine(), out int ID2))
                            {
                                Console.WriteLine("ID no válido. Debe ser un número.");
                                break;
                            }
                            cartaService.FuncionBatalla(ID1, ID2);

                            break;
                        case 11:

                            Console.WriteLine("Saliendo del programa...");

                            break;
                        default:

                            if (opcion != 0) Console.WriteLine("Opción no válida.");

                            break;
                    }
                    if (opcion != 11)
                    {
                        Console.WriteLine("\nPresiona cualquier tecla para volver al menú...");
                        Console.ReadKey();
                        Console.Clear();
                    }
                }
                while (opcion != 11);
                Console.ReadKey();

                //AQUI ACABA EL USING, ENS DESCONNECTEM DE LA BD
            }

        }
    }
}