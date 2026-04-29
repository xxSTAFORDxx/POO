using System;
using System.Collections.Generic;
using System.Text;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace WikiGacha
{
    public class CartaService
    {
        private WikiGachaContext ctx;

        public CartaService(WikiGachaContext ctx)
        {
            this.ctx = ctx;
        }

        private ConsoleColor ObtenerColorRareza(string rareza)
        {
            // Usamos .Trim() por si hay espacios vacíos por error
            return rareza.Trim().ToLower() switch
            {
                "común" or "comú" or "common" => ConsoleColor.DarkGray,
                "poco común" or "poc comú" or "uncommon" => ConsoleColor.Gray,
                "rara" or "rare" => ConsoleColor.DarkYellow,
                "épica" or "èpica" or "epic" => ConsoleColor.Magenta,
                "legendaria" or "llegendària" or "legendary" => ConsoleColor.Red,
                _ => ConsoleColor.Green // Color base de tu consola
            };
        }

        private void ImprimirConEstilo(List<Carta> lista)
        {
            foreach (var carta in lista)
            {
                // Aplicamos tu Guía de Estilo:
                // Color de línea según si es repetida
                Console.ForegroundColor = carta.Repetida ? ConsoleColor.White : ConsoleColor.Green;

                Console.Write($"[{carta.CartaID}] {carta.Nombre} (");

                // Color especial solo para la rareza
                Console.ForegroundColor = ObtenerColorRareza(carta.Rareza);
                Console.Write(carta.Rareza);

                // Volvemos al color de la línea
                Console.ForegroundColor = carta.Repetida ? ConsoleColor.White : ConsoleColor.Green;
                Console.WriteLine($") - ATK: {carta.Ataque} / DEF: {carta.Defensa}");
            }
            Console.ResetColor(); // Importante: dejar la consola limpia
        }

        public void MostrarTodas()
        {
            List<Carta> todasLasCartas = ctx.Carta.ToList();
            Console.WriteLine("\n===== TODOS LOS REGISTROS DEL SISTEMA =====");
            // 2. Llamamos al método que sabe imprimir con colores
            ImprimirConEstilo(todasLasCartas);
        }

        public void BuscarPorID(int ID)
        {
            Carta carta = ctx.Carta.Find(ID);

            if (carta == null)
            {
                Console.WriteLine("No se ha encontrado ninguna carta con ese ID.");
                return;
            }

            Console.WriteLine("=== CARTA ENCONTRADA ===");

            ImprimirConEstilo(new List<Carta> { carta });
        }
        public void ContarCartas()
        {
            int total = ctx.Carta.Count();
            int totalComunes = ctx.Carta.Count(carta => carta.Rareza == "Común" || carta.Rareza == "Comú" || carta.Rareza == "Common");
            int totalPocoComun = ctx.Carta.Count(carta => carta.Rareza == "Poco Común" || carta.Rareza == "Poc Comú" || carta.Rareza == "Uncommon");
            int totalRaras = ctx.Carta.Count(carta => carta.Rareza == "Rara" || carta.Rareza == "Rara" || carta.Rareza == "Rare");
            int totalEpicas = ctx.Carta.Count(carta => carta.Rareza == "Épica" || carta.Rareza == "Èpica" || carta.Rareza == "Epic");
            int totalLegendaria = ctx.Carta.Count(carta => carta.Rareza == "Legendaria" || carta.Rareza == "Llegendària" || carta.Rareza == "Legendary");
            Console.WriteLine("=== ESTADÍSTICAS DE COLECCIÓN ===");
            Console.WriteLine($"Total de cartas: {total}");
            Console.WriteLine("---------------------------------");

            // Comunes: Negro (Ojo: si tu fondo es negro, no se verá. Si es así, usa Gray)
            Console.ForegroundColor = ConsoleColor.DarkGray;
            Console.Write("Comunes:      ");
            Console.ForegroundColor = ConsoleColor.DarkGray;
            Console.WriteLine(totalComunes);
            Console.ResetColor();

            // Poco Comunes: Gris
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write("Poco Comunes: ");
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine(totalPocoComun);
            Console.ResetColor();

            // Raras: Dorado (Amarillo oscuro)
            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.Write("Raras:        ");
            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.WriteLine(totalRaras);
            Console.ResetColor();

            // Épicas: Morado
            Console.ForegroundColor = ConsoleColor.DarkMagenta;
            Console.Write("Épicas:       ");
            Console.ForegroundColor = ConsoleColor.DarkMagenta;
            Console.WriteLine(totalEpicas);
            Console.ResetColor();

            // Legendarias: Naranja
            Console.ForegroundColor = ConsoleColor.Red;
            Console.Write("Legendarias:  ");
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine(totalLegendaria);
            Console.ResetColor();

            Console.WriteLine("---------------------------------");
        }
        public void FiltrarPorIdioma(string idioma)
        {
            
                var lista = ctx.Carta.Where(c => c.Idioma.ToLower() == idioma.ToLower()).ToList();

                if (!lista.Any())
                {
                    Console.WriteLine("No hay cartas en ese idioma.");
                    return;
                }

                Console.WriteLine($"=== CARTAS EN IDIOMA: {idioma} ===");

                ImprimirConEstilo(lista);
           
        }
        public void CartaMasPoderosa()
        {
            if (!ctx.Carta.Any())
            {
                Console.WriteLine("No hay cartas en la colección.");
                return;
            }

            var carta = ctx.Carta.OrderByDescending(c => c.Ataque).First();

            Console.WriteLine("=== CARTA MÁS PODEROSA ===");

            ImprimirConEstilo(new List<Carta> { carta });
        }
            
        public bool HayLegendaria()
        {
            return ctx.Carta.Any(carta => carta.Rareza.ToLower().Contains("legend") || carta.Rareza.ToLower().Contains("llegend"));
        }
        public void MejorarCarta(int ID, int BonusAtaque, int BonusDefensa)
        {
            
                Carta carta = ctx.Carta.Find(ID);

                if (carta == null)
                {
                    Console.WriteLine("No existe una carta con ese ID.");
                    return;
                }

                carta.Ataque += BonusAtaque;
                carta.Defensa += BonusDefensa;

                ctx.SaveChanges();

                Console.WriteLine("Carta mejorada correctamente.");
          

        }
        public void MarcarRepetida(int ID)
        {

            Carta carta = ctx.Carta.Find(ID);
            carta.Repetida = true;
            ctx.SaveChanges();


        }
        public void EliminarCarta(int ID)
        {
            
                Carta carta = ctx.Carta.Find(ID);

                if (carta == null)
                {
                    Console.WriteLine("No se ha encontrado la carta.");
                    return;
                }

                ctx.Carta.Remove(carta);
                ctx.SaveChanges();

                Console.WriteLine("Carta eliminada correctamente.");
           
        }
        public void EliminarCartaRepetida(int v)
        {
            
                var lista = ctx.Carta
                               .Where(c => c.Repetida)
                               .ToList();

                if (!lista.Any())
                {
                    Console.WriteLine("No hay cartas repetidas.");
                    return;
                }

                ctx.Carta.RemoveRange(lista);
                ctx.SaveChanges();

                Console.WriteLine($"Se han eliminado {lista.Count} cartas repetidas.");
           
        }

        public void AñadirCarta(string NombreCarta, string RarezaCarta, string IdiomaCarta, int AtaqueCarta, int DefensaCarta, string DescripcionCarta)

        {
            bool RepetidaCarta = ctx.Carta.Any(carta => carta.Nombre.ToLower() == NombreCarta.ToLower());

            if (RepetidaCarta)
            {
                Console.WriteLine("Esta carta ya existe. Se marcará como repetida.");
            }

            Carta carta = new Carta()
            {
                Nombre = NombreCarta,
                Rareza = RarezaCarta,
                Idioma = IdiomaCarta,
                Ataque = AtaqueCarta,
                Defensa = DefensaCarta,
                Descripción = DescripcionCarta,
                Repetida = RepetidaCarta
            };

            ctx.Carta.Add(carta);
            ctx.SaveChanges();

            Console.WriteLine("Carta añadida correctamente.");
        }
        public bool CartaConNombreExistente(string nombreCarta)
        {
            return ctx.Carta.Any(carta => carta.Nombre == nombreCarta);
        }
    }
}