//
// Pontifícia Universidade Católica de Minas Gerais
// Unidade São Gabriel
// Disciplina: Técnicas Avançadas de Programação
// *Advanced Programming Techniques
// 
// Igor Octaviano
// More? access: https://github.com/igoroctaviano/
// 
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KnapsackProblem.Algorithms.Boolean
{
    // Greedy approach (Guloso)
    public class GreedyKnapsack
    {
        public int Solve(int[] weights, int[] values, int items, int capacity)
        {
            if (items == 0)
                return 0;

            int a = Solve(weights, values, items - 1, capacity);
            if (weights[items] > capacity)
                return a;

            int b = Solve(weights, values, items - 1, capacity - weights[items]) + values[items];

            return this.Max(a, b);
        }
        private int Max(int a, int b) { return (a > b) ? a : b; }

        /*
        public static void Main(string[] args)
        {
            int[] weights = { 12, 2, 1, 4, 1 };
            int[] values = { 4, 2, 1, 10, 2 };
            int capacity = 15;
            int items = 5;

            RecursiveKnapsack rk = new RecursiveKnapsack();
            Console.WriteLine(rk.Solve(weights, values, items - 1, capacity));
        } */
    }
}
