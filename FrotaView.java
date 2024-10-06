import java.util.Scanner;

public class FrotaView {

    public static void main(String[] args) {
        limparTela(); // Limpa a tela assim que o código for executado
        Scanner scanner = new Scanner(System.in);
        FrotaService frotaService = new FrotaService();
        int opcao;

        do {
            System.out.println("Sistema de Gestão de Frotas");
            System.out.println("1 Cadastrar Novo Veículo");
            System.out.println("2 Listar todos Veículos cadastrados");
            System.out.println("3 Pesquisar um Veículo por placa");
            System.out.println("4 Remover um Veículo");
            System.out.println("0 Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida. Por favor, insira um número.");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            
            limparTela();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a placa:");
                    String placa = scanner.nextLine();
                    System.out.println("Informe o modelo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Informe o ano:");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Ano inválido. Por favor, insira um número válido.");
                        scanner.next();
                    }
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Informe o número de portas:");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Número de portas inválido. Por favor, insira um número.");
                        scanner.next();
                    }
                    int numeroDePortas = scanner.nextInt();
                    scanner.nextLine(); 

                    frotaService.cadastrarVeiculo(placa, modelo, ano, numeroDePortas);
                    break;
                case 2:
                    frotaService.listarVeiculos();
                    break;
                case 3:
                    System.out.println("Informe a placa:");
                    String placaPesquisa = scanner.nextLine();
                    Veiculo veiculo = frotaService.pesquisarPorPlaca(placaPesquisa);
                    if (veiculo != null) {
                        System.out.println(veiculo);
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Informe a placa do veículo a ser removido:");
                    String placaRemocao = scanner.nextLine();
                    frotaService.removerVeiculo(placaRemocao);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        scanner.close(); // Fecha o scanner ao final
    }

    public static void limparTela() {
        // Comando para limpar a tela no Windows
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                System.out.println("Erro ao limpar a tela: " + e.getMessage());
            }
        } else { // Comando para limpar a tela no Linux ou Mac
            System.out.print("\033[H\033[2J"); // Códigos ANSI para limpar a tela
            System.out.flush();
        }
    }
}
