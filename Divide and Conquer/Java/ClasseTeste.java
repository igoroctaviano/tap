

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ClasseTeste {

    /*Método que gera preenche um vetor passado como parâmetro de forma ordenada*/
    public static void geraVetorOrdenado(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    /*Método que gera preenche um vetor passado como parâmetro de forma inversamente ordenada*/
    public static void geraVetorInversamenteOrdenado(int[] array) {
        int k = array.length;
        for (int i = 0; i < array.length; i++) {
            array[i] = k;
            k--;
        }
    }

    /*Método que preenche um vetor passado como parâmetro de forma aproximadamente ordenada*/
    public static void geraVetorQuaseOrdenado(int[] array) {

        /*Preenchimento do vetor ordenadamente até a metade*/
        int i = 0;
        for (; i < array.length / 2; i++) {
            array[i] = i;
        }

        /*Criação de uma lista que comportará os números a serem embaralhados*/
        ArrayList<Integer> list = new ArrayList<Integer>();

        /*Adição de números na lista*/
        int j = i;
        for (; j < array.length; j++) {
            list.add(j);
        }

        /*Embaralhamento de números*/
        Collections.shuffle(list);

        /*Adição de números embaralhados no vetor inicial*/
        for (j = 0; i < array.length; i++) {
            array[i] = list.get(j);
            j++;
        }
    }

    /*Método que gera preenche um vetor passado como parâmetro de forma aleatória*/
    public static void geraVetorAleatorio(int[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }

    /*Método que gera um log em csv*/
    public static void geraLog(Object metodo, String log) {
        String nomemetodo = (metodo.getClass().getName().replaceAll("([a-zA-Z]+\\.)([a-zA-Z]+)", "$2"));
        try {
            FileWriter x = new FileWriter("./logs/" + nomemetodo + ".csv", true);
            log += "\n\r";
            x.write(log);
            x.close();
        } catch (Exception e) {
        }
    }

    /*Método que remove os logs pre-existentes*/
    public static void removeLogsAntigos() {

        File dir = new File("./logs");
        String[] allFiles = dir.list();

        for (String file : allFiles) {
            new File("./logs/" + file).delete();
        }
    }

    public static void main(String args[]) {

        /*Remoção de logs antigos*/
        removeLogsAntigos();

        /*Array de tamanhos de vetores a serem, testados*/
        int[] arraytamanhos = {10, 100, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 20000, 30000, 40000, 50000, 600000, 70000, 80000, 90000, 100000, 200000, 500000, 1000000, 10000000};

        /*Tempos em Milisegundos*/
        long inicioMS = 0;
        long fimMS = 0;

        /*Tempos em Nanosegundos*/
        long inicioNS = 0;
        long fimNS = 0;

        /*Stringbuilder que irá ser impressa em arquivo no formato de log gerado*/
        StringBuilder logExit = new StringBuilder();

        System.out.println("Teste com Quicksort");
        Quicksort quick = new Quicksort();

        /*Teste com vetor ordenado*/
        logExit.append("Quicksort ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            /*Vetor a ser preenchido, alocado com um tamanho especificado a cada iteração*/
            int[] array = new int[size];

            /*Gera um vetor ordenado*/
            geraVetorOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            quick.quick_srt(array, 0, array.length - 1); //Chamada do método de ordenação quicksort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(quick.getNumComparacoes()).append(",").append(quick.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            quick.resetCount(); //Reset de contadores de comparação e atribuição a cada loop
        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(quick, logExit.toString());
        logExit = new StringBuilder();


        /*Teste com vetor inversamente ordenado*/
        logExit.append("Quicksort inversamente ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            /*Vetor a ser preenchido, alocado com um tamanho especificado a cada iteração*/
            int[] array = new int[size];

            /*Gera um vetor inversamente ordenado*/
            geraVetorInversamenteOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            quick.quick_srt(array, 0, array.length - 1); //Chamada do método de ordenação quicksort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(quick.getNumComparacoes()).append(",").append(quick.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            quick.resetCount();
        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(quick, logExit.toString());
        logExit = new StringBuilder();


        /*Teste com vetor aleatoriamente ordenado*/
        logExit.append("Quicksort aleatoriamente ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            /*Vetor a ser preenchido, alocado com um tamanho especificado a cada iteração*/
            int[] array = new int[size];

            /*Gera um vetor aleatoriamente ordenado*/
            geraVetorAleatorio(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            quick.quick_srt(array, 0, array.length - 1); //Chamada do método de ordenação quicksort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(quick.getNumComparacoes()).append(",").append(quick.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            quick.resetCount();
        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(quick, logExit.toString());
        logExit = new StringBuilder();


        /*Teste com vetor quase ordenado*/
        logExit.append("Quicksort quase ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        /*Teste com vetor ordenado*/
        for (int size : arraytamanhos) {

            /*Vetor a ser preenchido, alocado com um tamanho especificado a cada iteração*/
            int[] array = new int[size];

            /*Gera um vetor quase ordenado*/
            geraVetorQuaseOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            quick.quick_srt(array, 0, array.length - 1); //Chamada do método de ordenação quicksort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(quick.getNumComparacoes()).append(",").append(quick.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            quick.resetCount();

        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(quick, logExit.toString());
        logExit = new StringBuilder();

        System.out.println("Resultados do Quicksort impressos no log.");



        System.out.println("Teste com Mergesort");
        Mergesort merge = new Mergesort();

        /*Teste com vetor ordenado*/
        logExit.append("Mergesort ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");


        /*Teste com vetor ordenado*/
        for (int size : arraytamanhos) {

            int[] array = new int[size];

            /*Gera um vetor ordenado*/
            geraVetorOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            merge.mergesort(array, 0, array.length - 1); //Chamada do método de ordenação Mergesort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(merge.getNumComparacoes()).append(",").append(merge.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            merge.resetCount();

        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(merge, logExit.toString());
        logExit = new StringBuilder();


        /*Teste com vetor inversamente ordenado*/
        logExit.append("Mergesort inversamente ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            int[] array = new int[size];

            /*Gera um vetor inversamente ordenado*/
            geraVetorInversamenteOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            merge.mergesort(array, 0, array.length - 1); //Chamada do método de ordenação Mergesort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(merge.getNumComparacoes()).append(",").append(merge.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            merge.resetCount();

        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(merge, logExit.toString());
        logExit = new StringBuilder();



        /*Teste com vetor aleatoriamente ordenado*/
        logExit.append("Mergesort aleatoriamente ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            int[] array = new int[size];

            /*Gera um vetor aleatoriamente ordenado*/
            geraVetorAleatorio(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            merge.mergesort(array, 0, array.length - 1); //Chamada do método de ordenação Mergesort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(merge.getNumComparacoes()).append(",").append(merge.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            merge.resetCount();

        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(merge, logExit.toString());
        logExit = new StringBuilder();


        /*Teste com vetor quase ordenado*/
        logExit.append("Mergesort quase ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            int[] array = new int[size];

            /*Gera um vetor aleatoriamente ordenado*/
            geraVetorQuaseOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            merge.mergesort(array, 0, array.length - 1); //Chamada do método de ordenação Mergesort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(merge.getNumComparacoes()).append(",").append(merge.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            merge.resetCount();

        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(merge, logExit.toString());

        System.out.println("Resultados do Mergesort impressos no log.");


        /*Stringbuilder que irá ser impressa em arquivo no formato de log gerado*/
        logExit = new StringBuilder();

        Heapsort heap = new Heapsort();

        System.out.println("Teste com Heapsort");

        /*Teste com vetor ordenado*/
        logExit.append("Heapsort ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            /*Vetor a ser preenchido, alocado com um tamanho especificado a cada iteração*/
            int[] array = new int[size];

            /*Gera um vetor ordenado*/
            geraVetorOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            heap.heapsort(array); //Chamada do método de ordenação Heapsort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(heap.getNumComparacoes()).append(",").append(heap.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            heap.resetCount();
        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(heap, logExit.toString());
        logExit = new StringBuilder();

        /*Teste com vetor inversamente ordenado*/
        logExit.append("Heapsort inversamente ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            /*Vetor a ser preenchido, alocado com um tamanho especificado a cada iteração*/
            int[] array = new int[size];

            /*Gera um vetor inversamente ordenado*/
            geraVetorInversamenteOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            heap.heapsort(array); //Chamada do método de ordenação Heapsort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(heap.getNumComparacoes()).append(",").append(heap.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            heap.resetCount();
        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(heap, logExit.toString());
        logExit = new StringBuilder();

        /*Teste com vetor aleatoriamente ordenado*/
        logExit.append("Heapsort aleatoriamente ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");

        for (int size : arraytamanhos) {

            /*Vetor a ser preenchido, alocado com um tamanho especificado a cada iteração*/
            int[] array = new int[size];

            /*Gera um vetor aleatoriamente ordenado*/
            geraVetorAleatorio(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            heap.heapsort(array); //Chamada do método de ordenação Heapsort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(heap.getNumComparacoes()).append(",").append(heap.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            heap.resetCount();
        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(heap, logExit.toString());
        logExit = new StringBuilder();

        /*Teste com vetor quase ordenado*/
        logExit.append("Heapsort quase ordenado\n");
        logExit.append("número de entradas, número de comparações, número de atribuições, tempo(ms), tempo(ns)\n");


        for (int size : arraytamanhos) {

            /*Vetor a ser preenchido, alocado com um tamanho especificado a cada iteração*/
            int[] array = new int[size];

            /*Gera um vetor ordenado*/
            geraVetorQuaseOrdenado(array);

            /*Verificação de complexidade do algoritmo testado*/
            inicioMS = System.currentTimeMillis(); //Tempo inicial em Milisegundos
            inicioNS = System.nanoTime(); //Tempo inicial em Nanosegundos
            heap.heapsort(array); //Chamada do método de ordenação Heapsort
            fimMS = System.currentTimeMillis(); //Tempo final em Milisegundos
            fimNS = System.nanoTime() - inicioNS; //Tempo final em Nanosegundos

            logExit.append(array.length).append(",").append(heap.getNumComparacoes()).append(",").append(heap.getNumAtribuicoes()).append(",").append(fimMS - inicioMS).append(",").append(fimNS * 0.000001).append("\n");
            heap.resetCount();
        }

        /*Geração de log dos testes realizados anteriormente*/
        geraLog(heap, logExit.toString());

        System.out.println("Resultados impressos nos logs.");
    }
}
