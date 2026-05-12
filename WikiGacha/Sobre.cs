using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;
using WikiGacha;

namespace Wikigacha
{
    public class Sobre
    {
        public int SobreID { get; set; }

        [Required, MaxLength(100)]
        public string Nombre { get; set; }
        public RarezaSobre Rareza { get; set; }

        [Range(1, 10)]
        public int NumCartas { get; set; }
        public bool Abierto { get; set; } = false;

        [Range(0, int.MaxValue)]
        public int Precio { get; set; }
        public int UsuarioID { get; set; }
        public virtual Usuario Usuario{ get; set; }

        [Range(1, 9999)]
        public virtual ICollection<Carta> Cartas { get; set; } = new HashSet<Carta>();

    }
}