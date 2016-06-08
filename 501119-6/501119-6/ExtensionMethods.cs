using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _501119_6
{
    public static class ExtensionMethods
    {
        /* 2. Um palíndromo é uma sequência de caracteres cuja leitura é idêntica se feita da direita para esquerda
            ou vice-versa. Por exemplo: OSSO e OVO são palíndromos. Em textos mais complexos os espaços e
            pontuação são ignorados. A frase SUBI NO ONIBUS é o exemplo de uma frase palíndroma onde
            os espaços foram ignorados. Faça um Método de Extensão que verifique se uma string qualquer é um
            palíndromo ou não. */

        public static bool IsPalindrome(this string input)
        {
            int reverse = (input.Length - 1);
            for (int i = 0; i < input.Length; i++)
            {
                if (input[i] != input[reverse - i])
                {
                    if (input[i] == ' ')
                        i++;
                    else if (input[i] == ' ' && input[reverse - i] == ' ')
                        i++;
                    else if (input[reverse - i] == ' ')
                        reverse--;
                    else
                        return false;
                }
            }
            return true;
        }    

        /*
        static void Main(string[] args)
        {
            string stuff = "su bino oni bus";
            Console.WriteLine(stuff.IsPalindrome());
        } */
    }
}
