
class Quicksort {

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

    public void quick_srt(int array[], int low, int n) {

        /*Duas atribuições*/
        int lo = low;
        int hi = n;
        this.numeroatribuicoes += 2;

        /*Uma comparação*/
        this.numerocomparacoes++;
        if (lo >= n) {
            return;
        }

        /*Uma atribuição*/
        int mid = array[(lo + hi) / 2];
        this.numeroatribuicoes++;

        while (lo < hi) {

            /*Uma comparação a cada iteração*/
            this.numerocomparacoes++;


            while (lo < hi && array[lo] < mid) {
                lo++;

                /*Duas comparações e uma atribuição a cada iteração*/
                this.numerocomparacoes += 2;
                this.numeroatribuicoes++;
            }

            while (lo < hi && array[hi] > mid) {
                hi--;

                /*Duas comparações e uma atribuição a cada iteração*/
                this.numerocomparacoes += 2;
                this.numeroatribuicoes++;
            }

            /*Uma comparação*/
            this.numerocomparacoes++;
            if (lo < hi) {

                /*três atribuições*/
                this.numeroatribuicoes += 3;

                int T = array[lo];
                array[lo] = array[hi];
                array[hi] = T;
            }
        }

        /*Uma comparação*/
        this.numerocomparacoes++;
        if (hi < lo) {
            /*três atribuições*/
            this.numeroatribuicoes += 3;
            int T = hi;
            hi = lo;
            lo = T;
        }

        /*Chamadas recursivas*/
        quick_srt(array, low, lo);
        quick_srt(array, lo == low ? lo + 1 : lo, n);
    }
}