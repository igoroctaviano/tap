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
    /* 5. Defina o conceito de Delegates e Delegates Multicast utilizados no.NET e explique suas principais
          vantagens e desvantagens.Dê exemplos de sua utilização. 
          R:

       7. Implemente um programa de Calculadora utilizando delegates. A calculadora deve implementar as
          funções de soma, subtração, multiplicação e divisão de números inteiros. */
    public delegate int OperationHandler(int a, int b); 

    public class Delegates
    {
        public static int Addition(int a, int b) { return a + b; }
        public static int Subtraction(int a, int b) { return a - b; }
        public static int Multiplication(int a, int b) { return a * b; }
        public static int Division(int a, int b) { return a / b; }

        /*
        static void Main(string[] args)
        {
            OperationHandler op = new OperationHandler(Addition);
            Console.WriteLine("1 + 2: " + op(1, 2));
            op = Multiplication;
            Console.WriteLine("1 * 2: " + op(1, 2));
            op = Subtraction;
            Console.WriteLine("1 - 2: " + op(1, 2));
            op = Division;
            Console.WriteLine("1 / 2: " + op(1, 2));
        } */
    }
}
