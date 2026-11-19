package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Classes.Cliente;
import Classes.FormaPagamento;
import Classes.Funcionario;
import Classes.Imovel;
import Classes.Locacao;
import Classes.StatusImovel;
import Classes.Transacao;
import Classes.Venda;

public class Imobiliaria {
    private List<Imovel> imoveis;
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    private List<Transacao> transacoes;
    private int proximoNumeroContrato;

    public Imobiliaria() {
        imoveis = new ArrayList<>();
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        transacoes = new ArrayList<>();
        proximoNumeroContrato = 1;
    }

    public void cadastrarImovel(Imovel imovel) {
        if (imovel == null) {
            throw new IllegalArgumentException("O imóvel não pode ser vazio.");
        }
        if (imovel.getProprietarios().isEmpty()) {
            throw new IllegalArgumentException("Cadastre pelo menos um proprietário para o imóvel.");
        }
        if (buscarImovelPorCodigo(imovel.getCodigo()) != null) {
            throw new IllegalArgumentException("Já existe um imóvel com esse código.");
        }
        imoveis.add(imovel);
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser vazio.");
        }
        for (Cliente clienteCadastrado : clientes) {
            if (clienteCadastrado.getCpf().equals(cliente.getCpf())) {
                throw new IllegalArgumentException("Já existe um cliente com esse CPF.");
            }
        }
        clientes.add(cliente);
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("O funcionário não pode ser vazio.");
        }
        for (Funcionario funcionarioCadastrado : funcionarios) {
            if (funcionarioCadastrado.getCpf().equals(funcionario.getCpf())) {
                throw new IllegalArgumentException("Já existe um funcionário com esse CPF.");
            }
        }
        funcionarios.add(funcionario);
    }

    public Imovel buscarImovelPorCodigo(String codigo) {
        for (Imovel imovel : imoveis) {
            if (imovel.getCodigo().equalsIgnoreCase(codigo)) {
                return imovel;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public List<Imovel> buscarImoveisPorBairro(String bairro) {
        List<Imovel> encontrados = new ArrayList<>();
        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().getBairro().equalsIgnoreCase(bairro)) {
                encontrados.add(imovel);
            }
        }
        return encontrados;
    }

    public List<Imovel> listarDisponiveisParaVenda() {
        List<Imovel> encontrados = new ArrayList<>();
        for (Imovel imovel : imoveis) {
            if (imovel.getStatus() == StatusImovel.DISPONIVEL_VENDA) {
                encontrados.add(imovel);
            }
        }
        return encontrados;
    }

    public List<Imovel> listarDisponiveisParaLocacao() {
        List<Imovel> encontrados = new ArrayList<>();
        for (Imovel imovel : imoveis) {
            if (imovel.getStatus() == StatusImovel.DISPONIVEL_LOCACAO) {
                encontrados.add(imovel);
            }
        }
        return encontrados;
    }

    public Venda realizarVenda(Imovel imovel, Cliente comprador, Funcionario funcionario,
                               double valorVenda, double comissaoImobiliaria,
                               FormaPagamento formaPagamento) {
        validarParticipantes(imovel, comprador, funcionario);
        if (imovel.getStatus() != StatusImovel.DISPONIVEL_VENDA) {
            throw new IllegalArgumentException("Esse imóvel não está disponível para venda.");
        }
        validarValores(valorVenda, comissaoImobiliaria);

        Venda venda = new Venda(proximoNumeroContrato, imovel, comprador, funcionario,
                LocalDate.now(), valorVenda, comissaoImobiliaria, formaPagamento);
        registrarTransacao(venda, StatusImovel.VENDIDO);
        proximoNumeroContrato++;
        return venda;
    }

    public Locacao realizarLocacao(Imovel imovel, Cliente locatario, Funcionario funcionario,
                                   double valorAluguel, double comissaoImobiliaria,
                                   FormaPagamento formaPagamento) {
        validarParticipantes(imovel, locatario, funcionario);
        if (imovel.getStatus() != StatusImovel.DISPONIVEL_LOCACAO) {
            throw new IllegalArgumentException("Esse imóvel não está disponível para locação.");
        }
        if (locatario.getFiadores().size() < 1) {
            throw new IllegalArgumentException("Para a locação, cadastre pelo menos um fiador.");
        }
        if (locatario.getIndicacoes().size() < 2) {
            throw new IllegalArgumentException("Para a locação, cadastre pelo menos duas indicações.");
        }
        validarValores(valorAluguel, comissaoImobiliaria);

        Locacao locacao = new Locacao(proximoNumeroContrato, imovel, locatario, funcionario,
                LocalDate.now(), valorAluguel, comissaoImobiliaria, formaPagamento);
        registrarTransacao(locacao, StatusImovel.ALUGADO);
        proximoNumeroContrato++;
        return locacao;
    }

    private void validarParticipantes(Imovel imovel, Cliente cliente, Funcionario funcionario) {
        if (imovel == null || !imoveis.contains(imovel)) {
            throw new IllegalArgumentException("Imóvel não cadastrado na imobiliária.");
        }
        if (cliente == null || !clientes.contains(cliente)) {
            throw new IllegalArgumentException("Cliente não cadastrado na imobiliária.");
        }
        if (funcionario == null || !funcionarios.contains(funcionario)) {
            throw new IllegalArgumentException("Funcionário não cadastrado na imobiliária.");
        }
    }

    private void validarValores(double valorNegociado, double comissaoImobiliaria) {
        if (valorNegociado <= 0) {
            throw new IllegalArgumentException("O valor negociado deve ser maior que zero.");
        }
        if (comissaoImobiliaria < 0) {
            throw new IllegalArgumentException("A comissão da imobiliária não pode ser negativa.");
        }
    }

    private void registrarTransacao(Transacao transacao, StatusImovel novoStatus) {
        transacoes.add(transacao);
        transacao.getFuncionarioResponsavel().adicionarTransacao(transacao);
        transacao.getImovel().setStatus(novoStatus);
        transacao.getImovel().setValorReal(transacao.getValorNegociado());
        transacao.getImovel().setDataConclusao(transacao.getDataTransacao());
    }

    public List<Imovel> getImoveis() { return imoveis; }
    public List<Cliente> getClientes() { return clientes; }
    public List<Funcionario> getFuncionarios() { return funcionarios; }
    public List<Transacao> getTransacoes() { return transacoes; }
}
