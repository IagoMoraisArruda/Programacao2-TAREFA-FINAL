package Classes;

import java.time.LocalDate;

public abstract class Transacao {
    private int numeroContrato;
    private Imovel imovel;
    private Cliente clienteUsuario;
    private Funcionario funcionarioResponsavel;
    private LocalDate dataTransacao;
    private double valorNegociado;
    private double valorComissaoImobiliaria;
    private double valorComissaoFuncionario;
    private FormaPagamento formaPagamento;

    public Transacao(int numeroContrato, Imovel imovel, Cliente clienteUsuario,
                     Funcionario funcionarioResponsavel, LocalDate dataTransacao,
                     double valorNegociado, double valorComissaoImobiliaria,
                     FormaPagamento formaPagamento) {
        this.numeroContrato = numeroContrato;
        this.imovel = imovel;
        this.clienteUsuario = clienteUsuario;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.dataTransacao = dataTransacao;
        this.valorNegociado = valorNegociado;
        this.valorComissaoImobiliaria = valorComissaoImobiliaria;
        this.formaPagamento = formaPagamento;
        this.valorComissaoFuncionario = funcionarioResponsavel.calcularComissao(valorComissaoImobiliaria);
    }

    public abstract String getTipoOperacao();

    public String getResumo() {
        return "Contrato nº " + numeroContrato + " | " + getTipoOperacao()
                + " | Imóvel: " + imovel.getCodigo()
                + " | Cliente: " + clienteUsuario.getNome()
                + " | Funcionário: " + funcionarioResponsavel.getNome()
                + " | Data: " + dataTransacao
                + " | Valor: R$ " + String.format("%.2f", valorNegociado)
                + " | Comissão imobiliária: R$ " + String.format("%.2f", valorComissaoImobiliaria)
                + " | Comissão funcionário: R$ " + String.format("%.2f", valorComissaoFuncionario)
                + " | Pagamento: " + formaPagamento;
    }

    public int getNumeroContrato() { return numeroContrato; }
    public Imovel getImovel() { return imovel; }
    public Cliente getClienteUsuario() { return clienteUsuario; }
    public Funcionario getFuncionarioResponsavel() { return funcionarioResponsavel; }
    public LocalDate getDataTransacao() { return dataTransacao; }
    public double getValorNegociado() { return valorNegociado; }
    public double getValorComissaoImobiliaria() { return valorComissaoImobiliaria; }
    public double getValorComissaoFuncionario() { return valorComissaoFuncionario; }
    public FormaPagamento getFormaPagamento() { return formaPagamento; }
}
