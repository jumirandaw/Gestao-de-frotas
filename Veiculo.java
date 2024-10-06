public class Veiculo {
    private String placa;
    private String modelo;
    private int ano;
    private int numeroDePortas;

    public Veiculo(String placa, String modelo, int ano, int numeroDePortas) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.numeroDePortas = numeroDePortas;
    }

    // Getters e Setters
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Ano: " + ano + ", Portas: " + numeroDePortas;
    }
}