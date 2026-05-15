using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;
using WikiGacha;

namespace Wikigacha
{
    public class Usuario
    {
        public int UsuarioID { get; set; }

        [Required, MaxLength(50)]
        public string Nombre { get; set; }

        [Range(1, 100)]
        public int Nivel { get; set; } = 1;

        [Range(0, 500)]
        public int Monedas { get; set; } = 500;

        [Range(1, 9999)]
        public virtual ICollection<Sobre> Sobres { get; set; } = new HashSet<Sobre>();

        [Range(1, 9999)]
        public virtual ICollection<Carta> Cartas { get; set; } = new HashSet<Carta>();
    }
}
