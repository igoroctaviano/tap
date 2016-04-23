
public class Mergesort {

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

    public void mergesort(int[] data, int first, int n) {

        /*Duas atribuições*/
        this.numeroatribuicoes += 2;

        int n1; // Size of the first half of the array
        int n2; // Size of the second half of the array

        /*Uma comparação*/
        this.numerocomparacoes++;

        if (n > 1) {
            // Compute sizes of the two halves

            /*Duas atribuições*/
            this.numeroatribuicoes += 2;

            n1 = n / 2;
            n2 = n - n1;


            mergesort(data, first, n1);      // Sort data[first] through data[first+n1-1]
            mergesort(data, first + n1, n2); // Sort data[first+n1] to the end

            // Merge the two sorted halves.
            merge(data, first, n1, n2);
        }
    }

    private void merge(int[] data, int first, int n1, int n2) {


        /*Cinco atribuições*/
        this.numeroatribuicoes += 5;

        int[] temp = new int[n1 + n2]; // Allocate the temporary array
        int copied = 0; // Number of elements copied from data to temp
        int copied1 = 0; // Number copied from the first half of data
        int copied2 = 0; // Number copied from the second half of data
        int i;           // Array index to copy from temp back into data

        // Merge elements, copying from two halves of data to the temporary array.
        while ((copied1 < n1) && (copied2 < n2)) {

            /*Duas comparações a cada repetição*/
            this.numerocomparacoes += 2;

            if (data[first + copied1] < data[first + n1 + copied2]) {

                /*Uma comparação*/
                this.numerocomparacoes++;

                temp[copied++] = data[first + (copied1++)];

                /*Uma atribuição*/
                this.numeroatribuicoes++;

            } else {

                temp[copied++] = data[first + n1 + (copied2++)];

                /*Uma atribuição*/
                this.numeroatribuicoes++;
            }
        }

        // Copy any remaining entries in the left and right subarrays.
        while (copied1 < n1) {

            /*Uma comparação a cada repetição*/
            this.numerocomparacoes++;

            temp[copied++] = data[first + (copied1++)];

            /*Uma atribuição a cada repetição*/
            this.numeroatribuicoes++;
        }
        while (copied2 < n2) {

            /*Uma comparação a cada repetição*/
            this.numerocomparacoes++;

            temp[copied++] = data[first + n1 + (copied2++)];

            /*Uma atribuição a cada repetição*/
            this.numeroatribuicoes++;
        }

        // Copy from temp back to the data array.
        for (i = 0; i < n1 + n2; i++) {
            data[first + i] = temp[i];

            /*Uma atribuição a cada repetição*/
            this.numeroatribuicoes++;

        }
    }
}
