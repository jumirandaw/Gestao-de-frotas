import java.util.ArrayList;
import java.util.List;

public class FrotaService {
    private List<Veiculo> frota = new ArrayList<>();

    public void cadastrarVeiculo(String placa, String modelo, int ano, int numeroDePortas) {
        if (placa.isBlank() || modelo.isBlank() || ano == 0 || numeroDePortas == 0) {
            System.out.println("Erro: Todos os campos devem ser preenchidos corretamente.");
            return;
        }

        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Erro: Já existe um veículo com essa placa.");
                return;
            }
        }

        Veiculo veiculo = new Veiculo(placa, modelo, ano, numeroDePortas);
        frota.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void listarVeiculos() {
        if (frota.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            for (Veiculo veiculo : frota) {
                System.out.println(veiculo);
            }
        }
    }

    public Veiculo pesquisarPorPlaca(String placa) {
        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void removerVeiculo(String placa) {
        Veiculo veiculo = pesquisarPorPlaca(placa);
        if (veiculo != null) {
            frota.remove(veiculo);
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Erro: Veículo não encontrado.");
        }
    }
}

