using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;
using Wikigacha;

namespace WikiGacha
{
    public class Carta
    {
        public int CartaID { get; set; }

        [Required, MaxLength(100)]
        public string Nombre { get; set; }

        [Required, AllowedValues("Común", "Comú", "Common", "Poco Común", "Poc Comú", "Uncommon", "Rara", "Rare", "Épica", "Èpica", "Epic", "Legendaria", "Llegendària", "Legendary")]
        public string Rareza { get; set; }

        [Required, MaxLength(3)]
        public string Idioma { get; set; }

        [Range(1, 9999)]
        public int Ataque { get; set; }

        [Range(1, 9999)]
        public int Defensa { get; set; }

        public string? Descripción { get; set; }
        public bool Repetida { get; set; } = false;

        [Range(1, 9999)]
        public virtual ICollection<Sobre> Sobres { get; set; } = new HashSet<Sobre>();
        public virtual ICollection<Usuario> Usuarios { get; set; } = new HashSet<Usuario>();
    }
}
