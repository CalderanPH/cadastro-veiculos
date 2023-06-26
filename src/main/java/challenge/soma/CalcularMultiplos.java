package challenge.soma;

public class CalcularMultiplos {

    public static void main(String[] args) {
        int numeroLimite = 10;
        int soma = somaMultiplos(numeroLimite);
        System.out.println("A soma dos múltiplos de 3 ou 5 abaixo de " + numeroLimite + " é: " + soma);
    }

    /**
     * O loop percorre todos os números até o o limite, ou seja, considera o limite do parametro, verificando o primeiro
     * numero e excluindo o numero limite. i < numeroLimite. Cada numero é verificado se é multiplo por 3 ou 5.
     *
     * @param numeroLimite
     * @return
     */
    public static int somaMultiplos(int numeroLimite) {
        int soma = 0;

        for (int i = 1; i < numeroLimite; i++) {
            if (isMultiplo(i, 3) || isMultiplo(i, 5)) {
                soma += i;
            }
        }

        return soma;
    }

    public static boolean isMultiplo(int numero, int divisor) {
        return numero % divisor == 0;
    }

}