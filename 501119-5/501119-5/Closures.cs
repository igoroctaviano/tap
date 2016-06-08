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
    public class Closures
    {
        /* 10. Em seu programa você deve criar um função, usando closure, que a cada chamada gere o próximo
               número na sequencia de Fibonacci. */
        public Func<int, int> Fibonacci()
        {
            int two = 2;
            int one = 1; // local scope variables

            Func<int, int> InnerFibonacci = (n => { return 1; });

            InnerFibonacci = (n =>
            {
                if (n <= two)
                    return one;
                else
                    return InnerFibonacci(n - 1) + InnerFibonacci(n - 2);
            });

            return InnerFibonacci;
        }

        /*
        static void Main(string[] args)
        {
            Closures clos = new Closures();
            Func<int, int> Fibonacci = clos.Fibonacci();

            for (int i = 1; i < 10; i++)
                Console.WriteLine("{0} numero da Fibonacci é: {1}", i, Fibonacci(i));
        } */
    }
}
