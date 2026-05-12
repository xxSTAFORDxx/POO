using System;
using System.Collections.Generic;
using System.Text;
using WikiGacha;

namespace Wikigacha
{
    public class UsuarioService
    {
        private WikiGachaContext ctx;

        public UsuarioService(WikiGachaContext ctx)
        {
            this.ctx = ctx;
        }
        private CartaService cartaService;

        void MostrarSobresUsuario(string nombreUsuario)
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
        
        void MostrarCartasSobre(int sobreID)
            {
                var sobre = ctx.Sobre.Find(sobreID);

                if (sobre != null)
                {
                    Console.WriteLine("=== SOBRE ENCONTRADO ===");
                    Console.WriteLine($"COMBATE:{sobre.Nombre} {sobre.Rareza})");


                    foreach (var carta in sobre.Cartas)
                    {
                        cartaService.ImprimirConEstilo(carta);
                    }
                }
                else
                {
                    Console.WriteLine("No se ha encontrado ningun sobre con ese ID.");
                }
            }

            void MostrarColeccion(string nombreUsuari)
        {

        }

        void SobresSinAbrir()
        {

        }

        void UsuarioConMasCartas()
        {

        }

        void ValorColeccion(string nombreUsuari)
        {

        }

        void AbrirSobre(int sobreID)
        {

        }

        void ComprarSobre(int usuarioID, RarezaSobre rareza)
        {

        }
    }
}
