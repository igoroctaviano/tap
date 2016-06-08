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
    public class Lambdas
    {
        /* 6. Defina o conceito de Expressões Lambda utilizado no .NET e explique suas principais vantagens e
              desvantagens. Dê exemplos de sua utilização.
              R:
              Um lambda combina os benefícios dos ponteiros de função com os objetos de função,
              é uma maneira concisa de declarar uma função ou subrotina. em poo, é bastante similar
              a um objeto que tem um método só, elas retornam uma referência para aquela funcionalidade codificada,
              por definição, funções anônimas.

              Vantagens: Para que dar um nome a algo que só vai ser usado uma vez mesmo? Funções lambda podem 
              automaticamente usar todas as variáveis do escopo atual.  Ao usar lambdas, você pode escrever código
              que seja menos inconveniente e menos sujeito a erros do que o código para um objeto de função equivalente.

              Desvantagens:
              Para implementar um lambda o compilador tem que criar um delegate. Obviamente, cada vez que um é chamado a lambda
              um é criado. Se a lambda permanece em um caminho onde ela é chamada frequentemente, ela irá gerar tráfego de
              memória enorme, se não devidamente implementada. Técnicas de caching resolvem isso.


           9. Escreva uma expressão lambda que recebe uma tripla formada pelo nome, peso (em quilogramas) e altura
              (em metros) de uma pessoa e retorne o índice de massa corporal, dado pela equação IMC =
              massa / (altura ∗ altura). Crie um programa e realize testes na sua expressão. */

        static Func<string, double, double, double> imc = (nome, peso, altura) => { return peso / (altura * altura); };
        // Func é um delegate genérico que tem retorno.

        /*
        static void Main(string[] args)
        {
            Console.WriteLine("IMC de João é: " + imc("João", 50.0, 1.5));
        } */      
    }
}
