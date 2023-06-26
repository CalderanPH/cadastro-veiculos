package challenge.eleitores;

/**
 * Classe utilizada para calcular o Percentual de Eleitores.
 */
public class CalculaPercentualEleitores {
    public static void main(String[] args) {
        PercentualEleitores percentualEleitores = new PercentualEleitores(1000, 800, 150, 50);
        double votosValidos = percentualEleitores.percentualVotosValidos();
        double votosNulos = percentualEleitores.percentualVotosNulos();
        double votosBrancos = percentualEleitores.percentualVotosBrancos();

        System.out.println("\nPercentual de votos válidos: " + votosValidos + "%");
        System.out.println("Percentual de votos brancos: " + votosBrancos + "%");
        System.out.println("Percentual de votos nulos: " + votosNulos + "%");
    }

}