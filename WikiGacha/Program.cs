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

            //AQUI FEM UN NOU CONTEXT
            using (var ctx = new WikiGachaContext())
            {

                //Borra la BD. Aquesta linea es util quan esteu fent proves
                ctx.Database.EnsureDeleted();

                //Crea la BD. Aquesta linea hauria d'estar SEMPRE
                ctx.Database.EnsureCreated();



            }
            //AQUI ACABA EL USING, ENS DESCONNECTEM DE LA BD

        }
    }
}