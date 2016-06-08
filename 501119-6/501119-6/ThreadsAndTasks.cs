using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _501119_6
{
    public class ThreadsAndTasks
    {
        /* 5. Defina o conceito de Threads e Tasks. Quais as vantagens e desvantagens de utilizar estes recursos?
              Dê exemplos de aplicações que usam ou poderiam utilizar estes recursos. 
              
        /* 6. Imagine o seguinte cenário: Cinco alunos de Sistemas de Informação moram em uma republica e
              compartilham o uso da geladeira. Todos são responsáveis por manter o estoque dos alimentos (leite,
              ovos, pão, arroz, etc...) na casa e para isso definiram a seguinte regra:
              Se o alimento acabar, aquele que consumiu por último deve comprar mais no mercado
              Crie um programa para representar o cenário acima onde os alunos são representados por tarefas que
              consomem recursos e os alimentos são os recursos compartilhados. Faça com que as tarefas consumam
              recursos aleatórios. Considere que cada recurso possuem uma quantidade definida, por exemplo, uma
              caixa de leite possui 1L.
              Seu programa deve ser robusto para evitar que mais de uma pessoa vá ao mercado ao mesmo tempo.
              Deve também tentar diminuir as idas ao supermercado e ao mesmo tempo tentar diminuir o tempo de
              espera de um determinado produto chegar do mercado. */
        public void Consume()
        {
            Task<string>[] students = new Task<string>[5];
            Stack<Food> resources = new Stack<Food>(); {
                resources.Push(new Food("Maca", 1));
                resources.Push(new Food("Pera", 1));
                resources.Push(new Food("Uva", 1));
                resources.Push(new Food("Amora", 1));
                resources.Push(new Food("Leite", 1));
            }

            while (true)
            {
                var random = new Random();
                int someStudent = 0;
                do
                {
                    someStudent = random.Next(1, 5);
                    students[someStudent].Run<string>(() => {
                        return string.Format("Estudante {0} comeu uma {1}.",
                            someStudent, resources.Pop().Name);
                    });
                    Console.WriteLine(students[someStudent].Result);
                } while (TheresFood(resources));

                if (students[someStudent].IsCompleted)
                {
                    this.GoToMarket(resources);
                    Console.WriteLine("Estudante {0} comprou mais alimento . . . ", someStudent);
                }
                else
                {
                    Console.WriteLine("Aguardando estudante {9} acabar de comprar . . . ", someStudent);
                    students[someStudent].Wait();
                }
            }
        }

        private void GoToMarket(Stack<Food> resources)
        {
            resources.Push(FoodFactory.GetSomeFood());
        }

        private bool TheresFood(Stack<Food> stack)
        {
            return (stack.Count > 0);
        }

        private static class FoodFactory
        {
            static string[] foods = {"Maca", "Pera", "Uva", "Amora", "Leite"};

            public static Food GetSomeFood()
            {
                var random = new Random();
                int randomNumber = random.Next(1, foods.Length - 1);
                return new Food(foods[randomNumber], randomNumber);
            }
        }

        private class Food
        {
            private string name;
            private int amount;

            public string Name
            {
                get { return name; }
                set { name = value; }
            }

            public Food(string name, int amount)
            {
                this.name = name;
                this.amount = amount;
            }
        }

        static void Main(string[] args)
        {
            ThreadsAndTasks tet = new ThreadsAndTasks();
            tet.Consume();
        }
    }
}
