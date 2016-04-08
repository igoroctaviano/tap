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

using System.Drawing;

namespace KnightsTour
{
    public class KnightsTour
    {
        private int[] legalX = { 2, 1, -1, -2, -2, -1, 1, 2 };
        private int[] legalY = { 1, 2, 2, 1, -1, -2, -2, -1 };

        private int size;
        private int positions;
        private int[,] board;

        public KnightsTour(int size)
        {
            this.size = size;
            this.positions = size * size;
            this.board = new int[size, size];
        }

        private bool IsValid(Point position)
        {
            return (position.X >= 0 && position.X <= this.size - 1 && position.Y >= 0 && position.Y <= this.size - 1 && this.board[position.X, position.Y] == 0);
        }

        public void Solve(Point position)
        {
            int movementNumber = 1;
            this.board[position.X, position.Y] = movementNumber;
            bool done = this.TrySolve(movementNumber = 2, position);

            if (done)
            {
                for (int i = 0; i < this.size; i++)
                {
                    for (int j = 0; j < this.size; j++)
                        Console.Write(board[i, j] + " ");
                    Console.WriteLine();
                }
            }
            else
                Console.WriteLine("Não há solução possível.");
        }

        private bool TrySolve(int currentMoviment, Point position)
        {
            bool done = (currentMoviment > this.positions); // Verifica a quantidade de movimentos

            if (!done)
            {
                Point newPosition = Point.Empty;
                for (int k = 0; k < legalX.Length; k++) // Passa para o próximo movimento possível
                {
                    newPosition.X = position.X + this.legalX[k];
                    newPosition.Y = position.Y + this.legalY[k];

                    if (IsValid(newPosition))
                    {
                        this.SetMovement(newPosition, currentMoviment); // Seta movimento válido
                        done = this.TrySolve(currentMoviment + 1, newPosition); // Tenta outro movimento

                        if (!done)
                            this.board[newPosition.X, newPosition.Y] = 0; // Sem sucesso, descarta movimento
                    }
                }
            }
            return done;
        }

        private void SetMovement(Point position, int index)
        {
            this.board[position.X, position.Y] = index;
        }

        public static void Main(string[] args)
        {
            KnightsTour kt = new KnightsTour(5);
            kt.Solve(new Point(2, 2));
        } 
    }
}
