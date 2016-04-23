
public class Heapsort {

    private long numerocomparacoes = 0, numeroatribuicoes = 0;

    public long getNumComparacoes() {
        return this.numerocomparacoes;
    }

    public long getNumAtribuicoes() {
        return this.numeroatribuicoes;
    }

    public void resetCount() {
        this.numeroatribuicoes = 0;
        this.numerocomparacoes = 0;
    }

    public void heapsort(int[] num) {

        constructHeap(num);

        /*Uma atribuição*/
        this.numeroatribuicoes++;
        int end = num.length - 1;

        while (end > 0) {
            /*Uma comparação a cada repetição*/
            this.numerocomparacoes++;

            /*Três atribuições a cada repetição*/
            this.numeroatribuicoes += 3;
            int temp = num[0];
            num[0] = num[end];
            num[end] = temp;
            bubbleDown(num, 0, end - 1);
            end--;
        }
    }

    public void constructHeap(int[] num) {

        /*Duas atribuições*/
        int start = (num.length / 2) - 1; // Starting from last parent
        int end = num.length - 1;
        this.numeroatribuicoes += 2;

        /*Uma comparação a cada iteração*/
        while (start >= 0) {

            this.numerocomparacoes++;

            bubbleDown(num, start, end);

            /*Uma comparação*/
            this.numerocomparacoes++;
            if (start == 0) {
                break;
            }

            /*Uma atribuição*/
            start = start - 1;
            this.numeroatribuicoes++;
        }
    }

    public void bubbleDown(int[] num, int start, int end) {

        /*Uma atribuição*/
        this.numeroatribuicoes++;
        int root = start;

        /*Uma comparação a cada iteração*/
        while (root * 2 + 1 <= end) { // at least one child exists

            this.numerocomparacoes++;

            /*Três atribuições*/
            this.numeroatribuicoes += 3;
            int swap = root;
            int child = root * 2 + 1;
            int rchild = root * 2 + 2;


            /*Uma comparação*/
            this.numerocomparacoes++;
            if (num[swap] < num[child]) {

                /*Uma atribuição*/
                this.numeroatribuicoes++;
                swap = child;

            }

            /*Duas comparações*/
            this.numerocomparacoes += 2;
            if (rchild <= end && num[swap] < num[rchild]) {

                /*Uma atribuição*/
                this.numeroatribuicoes++;
                swap = rchild;
            }

            /*Uma comparação*/
            this.numerocomparacoes++;
            if (swap != root) {

                /*Quatro atribuições*/
                this.numeroatribuicoes += 4;

                int temp = num[root];
                num[root] = num[swap];
                num[swap] = temp;
                root = swap;

            } else {
                return;
            }
        }
    }

    public void bubbleDownMin(int[] num, int start, int end) {

        /*Uma atribuição*/
        this.numeroatribuicoes++;
        int root = start;


        while (root * 2 + 1 <= end) {

            /*Uma comparação a cada loop*/
            this.numerocomparacoes++;


            /*Três atribuições*/
            this.numeroatribuicoes += 3;
            int swap = root;
            int child = root * 2 + 1;
            int rchild = root * 2 + 2;

            /*Uma comparação*/
            this.numerocomparacoes++;
            if (num[swap] > num[child]) {

                /*Uma atribuição*/
                this.numeroatribuicoes++;
                swap = child;
            }

            /*Duas comparações*/
            this.numerocomparacoes += 2;
            if (rchild <= end && num[swap] > num[rchild]) {

                /*Uma atribuição*/
                this.numeroatribuicoes++;
                swap = rchild;
            }


            /*Uma comparação*/
            this.numerocomparacoes++;
            if (swap != root) {
                // swap here

                /*Quatro atribuições*/
                this.numeroatribuicoes += 4;

                int temp = num[root];
                num[root] = num[swap];
                num[swap] = temp;
                root = swap;
            } else {
                return;
            }
        }
    }
}
