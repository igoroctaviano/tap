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

using System.Reflection;

namespace _501119_5
{
    public class Reflections
    {
        /* 1. Defina o conceito de Reflexão para linguagens Orientada a Objetos.
              R:
              Reflexão é o processo onde se consegue em tempo de execução informações (métodos, atributos e construtores) 
              de uma classe. Este, é usado como uma extensão para o paradigma da orientação a objeto, 
              para adicionar auto-otimização e aumentar a flexibilidade de um aplicativo.

           2. Exemplifique 3 situações em que poderíamos aplicar o conceito de Reflexão.
              R:
              Criar comportamentos dinâmicos usando atributos, chamar método que não se conhece durante a concepção do sistema
              e descobrir qual é o modificador de acesso de um objeto.

           3. Implemente um programa usando reflexão que seja capaz de mapear e descrever todas as informações
           de um conjuntos de classes que se encontram em um determinado diretório/pacote informado pelo
           usuário. */
        public static Type[] GetTypesInNamespace(Assembly assembly, string nameSpace)
        {
            return assembly.GetTypes().Where(t => String.Equals(t.Namespace, nameSpace, StringComparison.Ordinal)).ToArray();
        }
  
        static void Main(string[] args)
        {
            string myNamespace = Console.ReadLine();

            var types = GetTypesInNamespace(Assembly.GetExecutingAssembly(), myNamespace);
            foreach (var type in types)
            {
                /* Peguei o BaseType para justificar porque apareceu ToString, GetHashCode e outros metodos
                   na lista de metodos, pois eles herdam de Object no C#. */
                Console.WriteLine("Type: " + type.Name + " BaseType: " + type.BaseType);

                var props = type.GetProperties();
                foreach(var prop in props)
                    Console.WriteLine("Property: " + prop.Name);

                var fields = type.GetFields();
                foreach (var field in fields)
                    Console.WriteLine("Field: " + field.Name);

                var methods = type.GetMethods();
                foreach (var method in methods)
                    Console.WriteLine("Method: " + method.Name);
            }
        } 
    }
}
