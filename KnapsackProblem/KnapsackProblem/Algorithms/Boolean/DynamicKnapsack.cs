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
    // Dynamic approach (Dinâmica)
    public class DynamicKnapsack
    {
        private static void Main(string[] args)
        {
            Action<object> write = Console.Write;

            write("Running ..\n\n");
            var rand = new Random();
      
            const int capacity = 15;
            var items = new List<Item>();
            items.AddRange(new List<Item>
                            {
                                new Item{Value = 4, Weight = 12},
                                new Item{Value = 2, Weight = 2},
                                new Item{Value = 1, Weight = 1},
                                new Item{Value = 10,Weight = 4},
                                new Item{Value = 2, Weight = 1}
                            });

            Knapsack.Init(items, capacity);
            Knapsack.Run();

            write("Done\n\n");

            Knapsack.PrintPicksMatrix(write);
            Knapsack.Print(write, true);
        }
        public static class Knapsack
        {
            static int[][] M { get; set; } // matrix
            static int[][] P { get; set; } // picks
            static Item[] I { get; set; } // items
            public static int MaxValue { get; private set; }
            static int W { get; set; } // max weight
            public static void Init(List<Item> items, int maxWeight)
            {
                I = items.ToArray();
                W = maxWeight;

                var n = I.Length;

                M = new int[n][];
                P = new int[n][];

                for (var i = 0; i < M.Length; i++) { M[i] = new int[W + 1]; }
                for (var i = 0; i < P.Length; i++) { P[i] = new int[W + 1]; }
            }

            public static void Run()
            {
                MaxValue = Recursive(I.Length - 1, W, 1);
            }

            public static int Recursive(int i, int w, int depth)
            {
                var take = 0;
                if (M[i][w] != 0) { return M[i][w]; }

                if (i == 0)
                {
                    if (I[i].Weight <= w)
                    {
                        P[i][w] = 1;
                        M[i][w] = I[0].Value;
                        return I[i].Value;
                    }

                    P[i][w] = -1;
                    M[i][w] = 0;
                    return 0;
                }
                if (I[i].Weight <= w)
                    take = I[i].Value + Recursive(i - 1, w - I[i].Weight, depth + 1);

                var dontTake = Recursive(i - 1, w, depth + 1);

                M[i][w] = Max(take, dontTake);

                if (take > dontTake) { P[i][w] = 1; }
                else { P[i][w] = -1; }

                return M[i][w];
            }

            public static void Print(Action<object> write, bool full)
            {
                var list = new List<Item>();
                list.AddRange(I);
                var w = W;
                var i = list.Count - 1;

                write(string.Format("Items: = {0}\n", list.Count));
                if (full) { list.ForEach(a => write(string.Format("{0}\n", a))); }

                write(string.Format("\nMax weight = {0}\n", W));
                write(string.Format("Max value = {0}\n", MaxValue));
                write("\nPicks were:\n");

                var valueSum = 0;
                var weightSum = 0;
                while (i >= 0 && w >= 0)
                {
                    if (P[i][w] == 1)
                    {
                        valueSum += list[i].Value;
                        weightSum += list[i].Weight;
                        if (full) { write(string.Format("{0}\n", list[i])); }
                        w -= list[i].Weight;
                    }

                    i--;
                }
                write(string.Format("\nvalue sum: {0}\nweight sum: {1}",
                    valueSum, weightSum));
            }

            public static void PrintPicksMatrix(Action<object> write)
            {
                write("\n\n");
                foreach (var i in P)
                {
                    foreach (var j in i)
                    {
                        var s = j.ToString();
                        var _ = s.Length > 1 ? " " : "  ";
                        write(string.Concat(s, _));
                    }
                    write("\n");
                }
            }

            public static int Max(int a, int b) { return a > b ? a : b; }
        }

        public class Item
        {
            private static int counter;
            public int Id { get; private set; }
            public int Value { get; set; } // value
            public int Weight { get; set; } // weight
            public Item()
            {
                Id = ++counter;
            }

            public override string ToString()
            {
                return string.Format("Id: {0}  v: {1}  w: {2}",
                                     Id, Value, Weight);
            }
        }
    }
}