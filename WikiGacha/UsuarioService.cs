using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;
using WikiGacha;

namespace Wikigacha
{
    public class UsuarioService
    {
        private WikiGachaContext ctx;
        private CartaService cartaService;

        public UsuarioService(WikiGachaContext ctx)
        {
            this.ctx = ctx;
            // ¡Indispensable para que MostrarColeccion() funcione!
            this.cartaService = new CartaService(ctx);
        }
 


        public void MostrarTodosLosUsuarios()
        {

        }
        public void MostrarSobresUsuario(string nombreUsuario)
        {
            var usuario = ctx.Usuario.Where(u => u.Nombre.ToLower() == nombreUsuario.ToLower()).FirstOrDefault();
            if (usuario != null)
            {
                Console.WriteLine($"\nSobres de {usuario.Nombre}:");

                int contador = 1;
                foreach (var sobre in usuario.Sobres)
                {
                    string estado = sobre.Abierto ? "ABIERTO" : "CERRADO";

                    Console.WriteLine($"  [{contador}] {sobre.Nombre} ({sobre.Rareza}) - {sobre.NumCartas} cartes - {estado}");
                    contador++;
                }
            }
            else
            {
                Console.WriteLine("Usuario no encontrado.");
            }
        }

        public void MostrarCartasSobre(int sobreID)
        {
            var sobre = ctx.Sobre.Include(s => s.Cartas).FirstOrDefault(s => s.SobreID == sobreID);

            if (sobre != null)
            {
                Console.WriteLine("=== CARTAS DEL SOBRE ===");
                Console.WriteLine($"SOBRE: {sobre.Nombre} | Rareza: {sobre.Rareza}");
                Console.WriteLine("-----------------------");

                if (sobre.Cartas != null && sobre.Cartas.Any())
                {
                    foreach (var carta in sobre.Cartas)
                    {
                        cartaService.ImprimirConEstilo(new List<Carta> { carta });
                    }
                }
                else
                {
                    Console.WriteLine("Este sobre está vacío.");
                }
            }
            else
            {
                Console.WriteLine($"No se ha encontrado ningún sobre con el ID: {sobreID}");
            }
        }

        public void MostrarColeccion(string nombreUsuario)
        {
            var usuario = ctx.Usuario.Include(u => u.Cartas).FirstOrDefault(u => u.Nombre.ToLower() == nombreUsuario.ToLower());

            if (usuario != null)
            {
                Console.WriteLine($"\n=== COLECCIÓN DE {usuario.Nombre.ToUpper()} ===");

                int total = usuario.Cartas?.Count ?? 0;
                Console.WriteLine($"Nivel: {usuario.Nivel} | Total cartas: {total}");
                Console.WriteLine("--------------------------------------------------");

                if (total > 0)
                {
                    foreach (var carta in usuario.Cartas)
                    {
                        cartaService.ImprimirConEstilo(new List<Carta> { carta });
                    }
                }
                else
                {
                    Console.WriteLine("Este usuario aún no tiene cartas en su colección.");
                }
            }
            else
            {
                Console.WriteLine($"Error: No se ha encontrado al usuario '{nombreUsuario}'.");
            }
        }

        public List<Sobre> SobresSinAbrir()
        {
            var listasobres = ctx.Sobre.Where(s => !s.Abierto).ToList();

            Console.WriteLine("Sobres sin abrir:");

            foreach (var sobre in listasobres)
            {
                Console.WriteLine($"  {sobre.Usuario.Nombre} - {sobre.Nombre} ({sobre.Rareza})");
            }
            return listasobres;
        }

        public Usuario UsuarioConMasCartas()
        {
            var usuario = ctx.Usuario.OrderByDescending(u => u.Cartas.Count()).FirstOrDefault();

            if (usuario != null)
            {
                Console.WriteLine($"EL usuario con mas cartas es: {usuario.Nombre}");
                Console.WriteLine($"Total de cartas: {usuario.Cartas.Count()}");
            }
            else
            {
                Console.WriteLine("Este usuario aún no tiene cartas en su colección.");
            }
            {
                return usuario;
            }
        }

        public int ValorColeccion(string nombreUsuario)
        {
            var usuario = ctx.Usuario.FirstOrDefault(u => u.Nombre.ToLower() == nombreUsuario.ToLower());

            if (usuario == null)
            {
                Console.WriteLine($"No se ha encontrado al usuario: {nombreUsuario}");
                return 0;
            }
            int poderTotal = usuario.Cartas.Sum(c => c.Ataque + c.Defensa);

            Console.WriteLine($"\n=== ESTADÍSTICAS DE PODER ===");
            Console.WriteLine($"Jugador: {usuario.Nombre}");
            Console.WriteLine($"Cartas en posesión: {usuario.Cartas.Count}");
            Console.WriteLine($"Poder total (ATK+DEF): {poderTotal}");
            Console.WriteLine("------------------------------");
            {
                return poderTotal;
            }
        }

        public bool AbrirSobre(int sobreID)
        {
            var sobre = ctx.Sobre.Find(sobreID);
            if (sobre == null || sobre.Abierto)
            {
                return false;
            }
            sobre.Abierto = true;

            Console.WriteLine($"Abriendo {sobre.Nombre} ({sobre.Rareza})...\n");
            this.MostrarCartasSobre(sobre.SobreID);

            if (sobre.Usuario != null)
            {
                foreach (var carta in sobre.Cartas)
                {
                    sobre.Usuario.Cartas.Add(carta);
                }
                ctx.SaveChanges();

                Console.WriteLine($"\nCartas añadidas a la colección de {sobre.Usuario.Nombre}!");
                return true;
            }
            return false;
        }

        public bool ComprarSobre(int usuarioID, RarezaSobre rareza)
        {
            var usuario = ctx.Usuario.Find(usuarioID);
            if (usuario == null) return false;
            int precio = 0;
            switch (rareza)
            {
                case RarezaSobre.Normal: precio = 100; break;
                case RarezaSobre.Dorado: precio = 300; break;
                case RarezaSobre.Arcoiris: precio = 500; break;
                default: return false;
            }
            if (usuario.Monedas < precio)
            {
                Console.WriteLine($"No tienes suficentes monedas! Tienes {usuario.Monedas} y necesitas {precio}.");
                return false;
            }
            usuario.Monedas -= precio;
            Random random = new Random();
            Sobre nuevoSobre = new Sobre
            {
                Nombre = $"Sobre {rareza} #{random.Next(100, 999)}",
                Rareza = rareza,
                Abierto = false,
                UsuarioID = usuario.UsuarioID,
                Cartas = new List<Carta>()
            };
            var todasLasCartas = ctx.Carta.ToList();
            if (!todasLasCartas.Any()) return false;

            for (int i = 0; i < 5; i++)
            {
                nuevoSobre.Cartas.Add(todasLasCartas[random.Next(todasLasCartas.Count)]);
            }
            if (rareza == RarezaSobre.Dorado)
            {
                var poolGarantizada = todasLasCartas.Where(c =>
                    c.Rareza == "Rara" || c.Rareza == "Èpica" || c.Rareza == "Llegendària").ToList();

                if (poolGarantizada.Any())
                {
                    var listaCartas = nuevoSobre.Cartas.ToList();
                    listaCartas[0] = poolGarantizada[random.Next(poolGarantizada.Count)];
                    nuevoSobre.Cartas = listaCartas;
                }
                if (poolGarantizada.Any())
                {
                    var listaCartas = nuevoSobre.Cartas.ToList();
                    listaCartas[0] = poolGarantizada[random.Next(poolGarantizada.Count)];
                    nuevoSobre.Cartas = listaCartas;
                }
            }
            ctx.Sobre.Add(nuevoSobre);
            ctx.SaveChanges();

            Console.WriteLine($"Compra realizada: {nuevoSobre.Nombre}");
            return true;
        }
    }
}
