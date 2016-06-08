//
// Igor Octaviano Ribeiro Rezende
// 501119
// Pontifícia Universidade Católica de Minas Gerais
// Técnicas Avançadas de Programação
//
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _501119_5
{
    public class Aluno
    {
        /* 8. Implemente o exemplo abaixo, adaptando a classe MyClass para a classe aluno. O aluno deve ter um
              nome, um número de matrícula e uma data de nascimento. Use delegates multicast para imprimir os
              dados dos alunos. */
        private string name;
        private int number;
        private DateTime birthDate;

        public Aluno(string name, int number, DateTime birthDate)
        {
            this.name = name;
            this.number = number;
            this.birthDate = birthDate;
        }

        public void ShowMyName()
        {
            Console.WriteLine("My name is " + this.name);
        }

        public void ShowMyNumber()
        {
            Console.WriteLine("My school number is " + this.number);
        }

        public void ShowMyBirthDate()
        {
            Console.WriteLine("My birth date is " + this.birthDate.ToShortDateString());
        }

        delegate void DemoOp(); // declare delegate type

        /*
        static void Main()
        {
            // cria algumas instâncias de Aluno
            Aluno[] alunos = {
                new Aluno("First", 1, new DateTime(1998, 2, 6)),
                new Aluno("Second", 2, new DateTime(1993, 5, 2))
            };

            for (int i = 0; i < 2; i++)
            {
                DemoOp demo = null; // declara um delegate vazio

                // adiciona métodos ao delegate
                demo += new DemoOp(alunos[i].ShowMyName);
                demo += new DemoOp(alunos[i].ShowMyNumber);
                demo += new DemoOp(alunos[i].ShowMyBirthDate);

                demo(); // invoca o delegate
            } 
        } */
    }
}
