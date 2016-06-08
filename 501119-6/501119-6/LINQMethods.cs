using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _501119_6
{
    public class LINQMethods
    {
        /* 3. Defina o conceito de LINQ. Quais as vantagens e desvantagens de utilizar este recurso? Dê exemplos
              de aplicações que usam ou poderiam utilizar este recurso.

              4. Crie uma lista de dados de carros (os dados podem ser lidos de um arquivo), com as seguintes informações:
              Placa, Modelo, Cor e Ano. Utilizando LINQ execute e exiba os resultados das seguintes
              consultas:
              (a) Exiba todas as informações da lista de carros
              (b) Exiba a quantidade de carros de um determinado modelo informado pelo usuário
              (c) Exiba todas as informações dos carros que terminam a placa com o número 1 e possuem a cor
              preto.
              (d) Exiba a quantidade de cada modelo, ordenando por modelo
              (e) Exiba todas as informações dos carros que são do modelo que mais aparece na lista de carros */

        public void CarsInfoBundle(List<Car> cars)
        {
            Console.WriteLine();
            foreach (var car in cars.Select(c => c))
                Console.WriteLine("Plate: {0}  Model: {1}  Color: {2}  Year:{3}",
                    car.plate, car.model, car.color, car.year);
        }

        public void CountCarsByModel(List<Car> cars, string model)
        {
            Console.WriteLine();
            Console.WriteLine("Model: {0}  Amount: {1}",
                    model, cars.Where(c => c.model == model).Select(c => c).Count());
        }
     
        public void BlackCarsThatPlateEndedWithOne(List<Car> cars)
        {
            Console.WriteLine();
            foreach (var car in cars.Where(c => c.plate.Last() == '1' && c.color == "Black").Select(c => c))
                Console.WriteLine("Plate: {0}  Model: {1}  Color: {2}  Year:{3}",
                     car.plate, car.model, car.color, car.year);
        }

        public void CountEachModelOrderByModel(List<Car> cars)
        {
            Console.WriteLine();
            foreach (var model in cars.OrderBy(c => c.model).Select(c => c.model).Distinct())
                Console.WriteLine("Model: {0}  Count: {1}",
                        model);
        }

        /*
        public List<Car> TopModelCars(List<Car> cars)
        {
            return null;
        } */

        public class Car
        {
            public string plate;
            public string model;
            public string color;
            public int year;

            public Car(string plate, string model, string color, int year)
            {
                this.plate = plate;
                this.model = model;
                this.color = color;
                this.year = year;
            }
        }

        /*
        static void Main(string[] args)
        {
            var cars = new List<Car>();
            cars.Add(new Car("WWW-5632", "Fusca", "Green", 1994));
            cars.Add(new Car("FFF-5632", "Belina", "Black", 1994));
            cars.Add(new Car("GGG-5631", "147", "Black", 1994));
            cars.Add(new Car("OOO-5632", "Fusca", "Red", 1994));
            cars.Add(new Car("RRR-5632", "Fusca", "Yellow", 1994));
            cars.Add(new Car("HHH-5632", "Monza", "Purple", 1994));

            LINQMethods linq = new LINQMethods();

            linq.CarsInfoBundle(cars);
            linq.CountCarsByModel(cars, "Fusca");
            linq.BlackCarsThatPlateEndedWithOne(cars);
            linq.CountEachModelOrderByModel(cars);
        }*/
    }
}
