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
using System.Diagnostics;
using System.Globalization;
using System.Threading;

namespace KnapsackProblem.Algorithms.Boolean
{
    // Brute Force approach (Força Bruta)
    public class BruteForceKnapsack
    {
        public double Capacity { get; set; }
        public Item[] Items { get; set; }

        public Data Run()
        {
            var bestValue = 0d;
            var bestPosition = 0;
            var size = Items.Length;

            var permutations = (long)Math.Pow(2, size);
            for (var i = 0; i < permutations; i++)
            {
                var total = 0d;
                var weight = 0d;
                for (var j = 0; j < size; j++)
                {
                    // If bit not included then skip
                    if (((i >> j) & 1) != 1) continue;

                    total += Items[j].Value;
                    weight += Items[j].Weight;
                }
                if (weight <= Capacity && total > bestValue)
                {
                    bestPosition = i;
                    bestValue = total;
                }
            }

            var include = new List<Item>();
            for (var j = 0; j < size; j++)
            {
                // If bit match then add
                if (((bestPosition >> j) & 1) == 1)
                    include.Add(Items[j]);
            }
            return new Data { BestValue = bestValue, Include = include };
        }

        /*
        static void Main(string[] args)
        {
            var resolver = new BruteForceKnapsack
            {
                Capacity = 15,
                Items = new List<Item>
                {   new Item{Value = 4, Weight = 12},
                    new Item{Value = 2, Weight = 2},
                    new Item{Value = 1, Weight = 1},
                    new Item{Value = 10,Weight = 4},
                    new Item{Value = 2, Weight = 1}
                }.ToArray()
            };

            Data result = resolver.Run();

            Console.WriteLine("Items:" + resolver.Items.Length);
            Console.WriteLine("Capacity:" + resolver.Capacity);
            Console.WriteLine("Best value:" + result.BestValue + "\n");
            result.Include.ForEach(i => Console.WriteLine(i + "\n"));
        } */

        public class Item
        {
            private static int counter;
            public double Identification { get; private set; }
            public double Value { get; set; }
            public double Weight { get; set; }
            public Item() { Identification = ++counter; }
            public override string ToString()
            {
                return string.Format("Id: {0} \tValue: {1} \tWeight: {2}",
                    Identification, Value, Weight);
            }
        }

        public class Data
        {
            public List<Item> Include { get; set; }
            public double BestValue { get; set; }
        }
    }
}
