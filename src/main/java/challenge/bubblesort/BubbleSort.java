package challenge.bubblesort;

import java.util.Arrays;

/**
 * Classe utilizada para executar o Bubble Sort
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] vetor = {5, 3, 2, 4, 7, 1, 0, 6};
        System.out.println("\nInicio da ordenação: ");
        System.out.println(Arrays.toString(vetor) + "\n");

        ordernar(vetor);

        System.out.println("Fim da ordenação: ");
        System.out.println(Arrays.toString(vetor));
    }

    /**
     * método utilizado para ordenar o vetor com Bubble Sort. Percorrendo o vetor multiplas vezes e comparando
     * os elementos adjacentes em pares. A cada iteração o maior elemento é movido para o final do vetor.
     * Sendo que a variavel j percorre até o penultimo elemento restante a ser verificado. Sendo verificado pela condição
     * j < n - i - 1.
     *
     * @param vetor a ser ordenado.
     */
    public static void ordernar(int[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    System.out.println("Pegamos último par: (" + vetor[j] + " e " + vetor[j + 1] + ")");
                    trocarElementos(vetor, j, j + 1);
                    System.out.println("Trocamos: " + Arrays.toString(vetor) + "\n");
                } else {
                    System.out.println("Pegamos último par: (" + vetor[j] + " e " + vetor[j + 1] + "), par já ordenado\n");
                }
            }
        }
    }

    private static void trocarElementos(int[] vetor, int i, int j) {
        int posicaoTemporaria = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = posicaoTemporaria;
    }

}