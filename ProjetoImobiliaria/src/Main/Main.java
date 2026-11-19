package Main;

import java.time.LocalDate;
import java.util.Scanner;

import Classes.Apartamento;
import Classes.Casa;
import Classes.Cliente;
import Classes.Endereco;
import Classes.FormaPagamento;
import Classes.Funcionario;
import Classes.Imovel;
import Classes.SalaComercial;
import Classes.StatusImovel;
import Classes.Terreno;
import service.Imobiliaria;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Imobiliaria imobiliaria = new Imobiliaria();

        cadastrarDadosDeExemplo(imobiliaria);

        int opcao;
        do {
            System.out.println("\n IMOBILIÁRIA ");
            System.out.println("1. Listar Imóveis | 2. Buscar por Bairro | 3. Imóveis para Venda | 4. Imóveis para Locação");
            System.out.println("5. Registrar Venda | 6. Registrar Locação | 7. Listar Transações | 8. Consultar Salário");
            System.out.println("9. Cadastrar Cliente | 10. Cadastrar Funcionário | 11. Cadastrar Imóvel | 0. Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(leitor.nextLine());

            switch (opcao) {
                case 1:
                    imobiliaria.getImoveis().forEach(i -> System.out.println("\n" + i.getResumo()));
                    break;
                case 2:
                    System.out.print("Bairro: ");
                    imobiliaria.buscarImoveisPorBairro(leitor.nextLine()).forEach(i -> System.out.println("\n" + i.getResumo()));
                    break;
                case 3:
                    imobiliaria.listarDisponiveisParaVenda().forEach(i -> System.out.println("\n" + i.getResumo()));
                    break;
                case 4:
                    imobiliaria.listarDisponiveisParaLocacao().forEach(i -> System.out.println("\n" + i.getResumo()));
                    break;
                case 5:
                    try {
                        System.out.print("Cód. Imóvel: "); Imovel imv = imobiliaria.buscarImovelPorCodigo(leitor.nextLine());
                        System.out.print("CPF Comprador: "); Cliente cli = imobiliaria.buscarClientePorCpf(leitor.nextLine());
                        System.out.print("CPF Funcionário: "); Funcionario fun = imobiliaria.buscarFuncionarioPorCpf(leitor.nextLine());
                        System.out.print("Valor Venda: R$ "); double val = Double.parseDouble(leitor.nextLine().replace(",", "."));
                        System.out.print("Comissão Imobiliária: R$ "); double com = Double.parseDouble(leitor.nextLine().replace(",", "."));
                        System.out.println(imobiliaria.realizarVenda(imv, cli, fun, val, com, FormaPagamento.PIX).getResumo());
                    } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
                    break;
                case 6:
                    try {
                        System.out.print("Cód. Imóvel: "); Imovel imv = imobiliaria.buscarImovelPorCodigo(leitor.nextLine());
                        System.out.print("CPF Locatário: "); Cliente cli = imobiliaria.buscarClientePorCpf(leitor.nextLine());
                        System.out.print("CPF Funcionário: "); Funcionario fun = imobiliaria.buscarFuncionarioPorCpf(leitor.nextLine());
                        System.out.print("Valor Aluguel: R$ "); double val = Double.parseDouble(leitor.nextLine().replace(",", "."));
                        System.out.print("Comissão Imobiliária: R$ "); double com = Double.parseDouble(leitor.nextLine().replace(",", "."));
                        System.out.println(imobiliaria.realizarLocacao(imv, cli, fun, val, com, FormaPagamento.PIX).getResumo());
                    } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
                    break;
                case 7:
                    imobiliaria.getTransacoes().forEach(t -> System.out.println(t.getResumo()));
                    break;
                case 8:
                    System.out.print("CPF Funcionário: ");
                    Funcionario f = imobiliaria.buscarFuncionarioPorCpf(leitor.nextLine());
                    System.out.println(f != null ? "Salário: R$ " + f.calcularSalario() : "Não encontrado.");
                    break;
                case 9:
                    System.out.print("CPF: "); String cpfC = leitor.nextLine();
                    System.out.print("Nome: "); String nomeC = leitor.nextLine();
                    imobiliaria.cadastrarCliente(new Cliente(cpfC, nomeC, "Endereço", "Telefone", "Email", "M/F", "Solteiro", "Profissão"));
                    System.out.println("Cliente cadastrado!");
                    break;
                case 10:
                    System.out.print("CPF: "); String cpfF = leitor.nextLine();
                    System.out.print("Nome: "); String nomeF = leitor.nextLine();
                    System.out.print("Salário Base: R$ "); double sal = Double.parseDouble(leitor.nextLine().replace(",", "."));
                    imobiliaria.cadastrarFuncionario(new Funcionario(cpfF, nomeF, "Endereço", "Tel", "Email", "M/F", "Solteiro", "Profissão", "Tel", "Cel", LocalDate.now(), "Corretor", sal, 10.0, "user", "senha"));
                    System.out.println("Funcionário cadastrado!");
                    break;
                case 11:
                    System.out.print("Código do Imóvel: "); String cod = leitor.nextLine();
                    System.out.print("Bairro: "); String bairro = leitor.nextLine();
                    System.out.print("Valor Sugerido: R$ "); double vSugerido = Double.parseDouble(leitor.nextLine().replace(",", "."));

                    Casa novaCasa = new Casa(cod, new Endereco("Rua", "1", "", bairro, "Marabá", "PA", "68500-000"), LocalDate.now(), LocalDate.now(), StatusImovel.DISPONIVEL_VENDA, vSugerido, 2, 1, 1, 1, 1, 100.0, true, "Casa simples");
                    System.out.print("CPF do Proprietário: ");
                    Cliente prop = imobiliaria.buscarClientePorCpf(leitor.nextLine());
                    if (prop != null) novaCasa.adicionarProprietario(prop);

                    imobiliaria.cadastrarImovel(novaCasa);
                    System.out.println("Imóvel cadastrado!");
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        leitor.close();
    }

    private static void cadastrarDadosDeExemplo(Imobiliaria imobiliaria) {
        Cliente proprietario = new Cliente("11111111111", "Mariah Souza", "Rua A, 100", "94990000001", "mariah@email.com", "F", "Casada", "Comerciante");
        Cliente comprador = new Cliente("33333333333", "Pedro Alves", "Rua C, 300", "94990000003", "pedro@email.com", "M", "Solteiro", "Analista");
        Funcionario funcionario = new Funcionario("66666666666", "Lucas Mendes", "Rua F, 600", "94990000008", "lucas@imobiliaria.com", "M", "Solteiro", "Corretor", "9433000001", "94990000008", LocalDate.now(), "Corretor", 2000.00, 20.0, "lucas", "senha123");

        imobiliaria.cadastrarCliente(proprietario);
        imobiliaria.cadastrarCliente(comprador);
        imobiliaria.cadastrarFuncionario(funcionario);

        Casa casa = new Casa("IMO001", new Endereco("Rua das Flores", "120", "", "Nova Marabá", "Marabá", "PA", "68500-000"), LocalDate.of(2010, 5, 10), LocalDate.now(), StatusImovel.DISPONIVEL_VENDA, 350000.00, 3, 1, 1, 1, 2, 150.0, true, "Casa próxima.");
        casa.adicionarProprietario(proprietario);
        imobiliaria.cadastrarImovel(casa);
    }
}