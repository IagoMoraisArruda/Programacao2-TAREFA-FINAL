package Classes;

import java.time.LocalDate;

public class Locacao extends Transacao {
    public Locacao(int numeroContrato, Imovel imovel, Cliente locatario,
                   Funcionario funcionario, LocalDate dataTransacao,
                   double valorAluguel, double comissaoImobiliaria,
                   FormaPagamento formaPagamento) {
        super(numeroContrato, imovel, locatario, funcionario, dataTransacao,
                valorAluguel, comissaoImobiliaria, formaPagamento);
    }

    @Override
    public String getTipoOperacao() {
        return "Locação";
    }
}
