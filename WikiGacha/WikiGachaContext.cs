using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;
using WikiGacha;

namespace WikiGacha
{
    //el context es la clase que traduce el objeto a tabla y la tabla a objeto
    //el context té tota la informacio de la BD
    //quines classes son taules
    //ubicacio de la DB, nom de la DB, user i password, etc
    public class WikiGachaContext : DbContext
    {

        //FAREM UN DBSET PET CADA CLASE QUE VULGUEM PASSAR A TAULA
        public DbSet<Carta> Carta { get; set; }


        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                //de moment nomes canivem el database, que es el nom de la db
                //mes endavant posarem usuari i password, potser la db per IP, etc
                optionsBuilder.UseSqlServer(@"Server=(localdb)\mssqllocaldb;Database=WikiGacha;Trusted_Connection=True;")
                .UseLazyLoadingProxies();
            }
        }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
        }

    }
}
