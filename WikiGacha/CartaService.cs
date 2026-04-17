using System;
using System.Collections.Generic;
using System.Text;

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
            return rareza.ToLower() switch
            {
                "común" or "comú" or "common" => ConsoleColor.DarkGray,
                "poco común" or "poc comú" or "uncommon" => ConsoleColor.Gray,
                "rara" or "rare" => ConsoleColor.DarkYellow,
                "épica" or "èpica" or "epic" => ConsoleColor.Magenta,
                "legendária" or "llegendària" or "legendary" => ConsoleColor.Red,
                _ => ConsoleColor.Green // Color base de tu consola
            };
        }

        public void MostrarTodas()
        {
            List<Carta> cartas = ctx.Carta.ToList();

            Console.WriteLine("===== MI COLECCIÓN DE CARTAS =====");

            foreach (var carta in cartas)
            {
                // 1. Color base de la línea (Blanco si es repetida, si no, verde/default)
                if (carta.Repetida) Console.ForegroundColor = ConsoleColor.White;
                else Console.ResetColor(); // Asegura que las no repetidas sean verdes

                // 2. Escribimos la primera parte (sin saltar de línea)
                Console.Write($"[{carta.CartaID}] {carta.Nombre} (");

                // 3. CAMBIAMOS COLOR SOLO PARA LA RAREZA
                Console.ForegroundColor = ObtenerColorRareza(carta.Rareza);
                Console.Write(carta.Rareza);

                // 4. VOLVEMOS AL COLOR DE LA LÍNEA (Blanco o Verde)
                if (carta.Repetida) Console.ForegroundColor = ConsoleColor.White;
                else Console.ResetColor();

                // 5. Cerramos paréntesis y ponemos el resto de datos
                Console.WriteLine($") - ATK: {carta.Ataque} / DEF: {carta.Defensa}");
            }

            Console.ResetColor(); // Limpieza final al salir del bucle
        }

        public void BuscarPorID(int ID)
        {
            Carta carta = ctx.Carta.Find(ID);

            if (carta != null)
            {
                if (carta.Repetida) Console.ForegroundColor = ConsoleColor.White;

                Console.WriteLine(carta.Nombre);
            }
            else
            {
                Console.WriteLine("No se ha encontrado ninguna carta con ese ID");
            }

        }
        public void ContarCartas()
        {
            int total = ctx.Carta.Count();
            int totalComunes = ctx.Carta.Count(carta => carta.Rareza == "Común" || carta.Rareza == "Comú" || carta.Rareza == "Common");
            int totalPocoComun = ctx.Carta.Count(carta => carta.Rareza == "Poco Común" || carta.Rareza == "Poc Comú" || carta.Rareza == "Uncommon");
            int totalRaras = ctx.Carta.Count(carta => carta.Rareza == "Rara" || carta.Rareza == "Rara" || carta.Rareza == "Rare");
            int totalEpicas = ctx.Carta.Count(carta => carta.Rareza == "Épica" || carta.Rareza == "Èpica" || carta.Rareza == "Epic");
            int totalLegendaria = ctx.Carta.Count(carta => carta.Rareza == "Legendária" || carta.Rareza == "Llegendària" || carta.Rareza == "Legendary");
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
            var cartaIdioma = ctx.Carta.Where(c => c.Idioma == idioma).ToList();
            Console.WriteLine(idioma);
            return;
        }
    }
}
