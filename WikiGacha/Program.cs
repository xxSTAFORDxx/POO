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

                Console.WriteLine("=== WIKIGACHA - Gestor de Colección ===");

                int opcion;
                do
                {
                    Console.WriteLine("                                 ");
                    Console.WriteLine("1. Mostrar totas las cartas.");
                    Console.WriteLine("2. Mostrar las cartas por cada rareza.");
                    Console.WriteLine("3. Buscar carta por ID.");
                    Console.WriteLine("4. Añadir nueva carta.");
                    Console.WriteLine("5. Mejorar carta.");
                    Console.WriteLine("6. Eliminar carta por ID.");
                    Console.WriteLine("7. Mostrar cartas por idioma.");
                    Console.WriteLine("8. Mostrar la carta mas poderosa.");
                    Console.WriteLine("9. Eliminar todas las repetidas.");
                    Console.WriteLine("10. Salir del programa.");
                    Console.WriteLine("-----------");
                    Console.WriteLine("-----------");
                    Console.WriteLine("Elige una opcion:");

                    opcion = int.Parse(Console.ReadLine());

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
                            int IDBuscar = int.Parse(Console.ReadLine());
                            cartaService.BuscarPorID(IDBuscar);

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
                            int AtaqueCarta = int.Parse(Console.ReadLine());

                            Console.Write("Defensa: ");
                            int DefensaCarta = int.Parse(Console.ReadLine());

                            Console.Write("Descripción: ");
                            string DescripcionCarta = Console.ReadLine();

                            cartaService.AñadirCarta(NombreCarta, RarezaCarta, IdiomaCarta, AtaqueCarta, DefensaCarta, DescripcionCarta);

                            break;
                        case 5:

                            Console.WriteLine("Mejorando carta...");

                            Console.WriteLine("Dime el ID de la carta a mejorar.");
                            int IDMejorar = int.Parse(Console.ReadLine());

                            Console.Write("Introduce bonus de ataque: ");
                            int BonusAtaque = int.Parse(Console.ReadLine());

                            Console.Write("Introduce bonus de defensa: ");
                            int BonusDefensa = int.Parse(Console.ReadLine());

                            cartaService.MejorarCarta(IDMejorar, BonusAtaque, BonusDefensa);

                            break;
                        case 6:

                            Console.WriteLine("Eliminando carta...");

                            Console.Write("Introduce el ID de la carta a eliminar: ");
                            int idEliminar = int.Parse(Console.ReadLine());
                            cartaService.EliminarCarta(idEliminar);

                            break;
                        case 7:

                            Console.Write("Introduce el idioma: ");
                            string idioma = Console.ReadLine();
                            cartaService.FiltrarPorIdioma(idioma);

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

                            Console.WriteLine("Saliendo del programa...");

                            break;
                        default:

                            Console.WriteLine("Opción no válida.");

                            break;
                    }
                }
                while (opcion != 10);
                Console.ReadKey();

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
                ctx.Carta.Add(castellers);
                ctx.Carta.Add(gatPersa2);

                ctx.SaveChanges();

                //AQUI ACABA EL USING, ENS DESCONNECTEM DE LA BD
            }

        }
    }
}







