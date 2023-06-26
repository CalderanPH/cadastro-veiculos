package challenge.eleitores;

public class PercentualEleitores {

    private final int totalEleitores;
    private final int votosValidos;
    private final int votosBrancos;
    private final int votosNulos;

    public PercentualEleitores(int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) {
        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }

    public double percentualVotosValidos() {
        return (double) votosValidos / totalEleitores * 100;
    }

    public double percentualVotosBrancos() {
        return (double) votosBrancos / totalEleitores * 100;
    }

    public double percentualVotosNulos() {
        return (double) votosNulos / totalEleitores * 100;
    }

}