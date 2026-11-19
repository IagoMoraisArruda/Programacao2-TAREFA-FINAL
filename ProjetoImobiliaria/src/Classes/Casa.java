package Classes;

import java.time.LocalDate;

public class Casa extends ImovelResidencial {
    public Casa(String codigo, Endereco endereco, LocalDate dataConstrucao,
                LocalDate dataDisponibilizacao, StatusImovel status, double valorSugerido,
                int quantidadeQuartos, int quantidadeSuites, int salasEstar,
                int salasJantar, int vagasGaragem, double areaMetrosQuadrados,
                boolean possuiArmarioEmbutido, String descricao) {
        super(codigo, endereco, dataConstrucao, dataDisponibilizacao,
                CategoriaImovel.CASA, status, valorSugerido,
                quantidadeQuartos, quantidadeSuites, salasEstar, salasJantar,
                vagasGaragem, areaMetrosQuadrados, possuiArmarioEmbutido, descricao);
    }

    @Override
    public String getDetalhesEspecificos() {
        return "Casa: " + detalhesResidenciais();
    }
}
