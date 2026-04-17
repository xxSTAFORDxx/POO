using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace WikiGacha
{
    public class Carta
    {
        public int CartaID { get; set; }

        [Required, StringLength(100)]
        public string Nombre { get; set; }

        [Required]
        public string Rareza { get; set; }

        [Required, StringLength(2)]
        public string Idioma { get; set; }

        [Range(1, 9999)]
        public int Ataque { get; set; }

        [Range(1, 9999)]
        public int Defensa { get; set; }

        public string? Descripción { get; set; }

        [DefaultValue(false)]
        public bool Repetida { get; set; }

    }
}
