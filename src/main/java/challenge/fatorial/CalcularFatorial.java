package challenge.fatorial;

import java.util.Scanner;

public class CalcularFatorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nDigite um número para calcular o fatorial (ou digite 'exit' para sair): ");
            String entrada = scanner.nextLine().toLowerCase();

            switch (entrada) {
                case "exit":
                    continuar = false;
                    break;
                default:
                    try {
                        int numero = Integer.parseInt(entrada);
                        long fatorial = calcularFatorial(numero);
                        System.out.println("O fatorial de " + numero + " é: " + fatorial + "\n");
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número válido ou 'exit' para sair.\n");
                    }
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    /**
     * lógica do fatorial enquanto o i for menor ou igual ao número i recebe + 1. O loop é executado até o i seja maior
     * que o numero, fatorial é multiplicado pelo o valor atual de i, sendo assim atribuido o resultado a fatorial.
     *
     * @param numero
     * @return
     */
    public static long calcularFatorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("O número não deve ser negativo.");
        }

        long fatorial = 1;

        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }

        return fatorial;
    }

}