package Classes;

import java.time.LocalDate;

public class Venda extends Transacao {
    public Venda(int numeroContrato, Imovel imovel, Cliente comprador,
                 Funcionario funcionario, LocalDate dataTransacao,
                 double valorVenda, double comissaoImobiliaria,
                 FormaPagamento formaPagamento) {
        super(numeroContrato, imovel, comprador, funcionario, dataTransacao,
                valorVenda, comissaoImobiliaria, formaPagamento);
    }

    @Override
    public String getTipoOperacao() {
        return "Venda";
    }
}
