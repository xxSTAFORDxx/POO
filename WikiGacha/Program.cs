using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;
using WikiGacha;
//namespace es com el package
namespace WikiGacha
{
    //el program es com el Test a l'hospital
    public class Program
    {
        //EL PROGRAM ES LA UNICA CLASSE QUE TINDRA MAIN
        static void Main(string[] args)
        {


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
                Idioma = "CA",
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



            //AQUI FEM UN NOU CONTEXT
            using (var ctx = new WikiGachaContext())
            {

                CartaService cartaService = new CartaService(ctx);

                //Borra la BD. Aquesta linea es util quan esteu fent proves
                ctx.Database.EnsureDeleted();

                //Crea la BD. Aquesta linea hauria d'estar SEMPRE
                ctx.Database.EnsureCreated();

                //Es fa un insert en la DB
                ctx.Carta.Add(germanCuisine);
                ctx.Carta.Add(gatPersa);
                ctx.Carta.Add(battleOfMidway);
                ctx.Carta.Add(tablaPeriodica);
                ctx.Carta.Add(castellers);
                ctx.Carta.Add(gatPersa2);

                ctx.SaveChanges();

                //Fem ús de les funcions
                cartaService.MostrarTodas();
                Console.WriteLine("---------------------------------");
                //cartaService.BuscarPorID(1);
                Console.WriteLine("---------------------------------");
                cartaService.ContarCartas();
                Console.WriteLine("---------------------------------");
                cartaService.FiltrarPorIdioma("CA").Foreach (carta => Console.WriteLine ($"ID:" { carta.CartaID} -"" Nombre"" { Carta.Nombre} ));
            }
            //AQUI ACABA EL USING, ENS DESCONNECTEM DE LA BD
        }

    }
}







