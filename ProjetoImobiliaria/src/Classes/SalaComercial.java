package Classes;

import java.time.LocalDate;

public class SalaComercial extends Imovel {
    private double areaMetrosQuadrados;
    private int quantidadeBanheiros;
    private int quantidadeComodos;

    public SalaComercial(String codigo, Endereco endereco, LocalDate dataConstrucao,
                         LocalDate dataDisponibilizacao, StatusImovel status,
                         double valorSugerido, double areaMetrosQuadrados,
                         int quantidadeBanheiros, int quantidadeComodos) {
        super(codigo, endereco, dataConstrucao, dataDisponibilizacao,
                CategoriaImovel.SALA_COMERCIAL, status, valorSugerido);
        this.areaMetrosQuadrados = areaMetrosQuadrados;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeComodos = quantidadeComodos;
    }

    @Override
    public String getDetalhesEspecificos() {
        return "Sala comercial: área " + areaMetrosQuadrados + " m², banheiros: "
                + quantidadeBanheiros + ", cômodos: " + quantidadeComodos;
    }

    public double getAreaMetrosQuadrados() { return areaMetrosQuadrados; }
    public void setAreaMetrosQuadrados(double areaMetrosQuadrados) { this.areaMetrosQuadrados = areaMetrosQuadrados; }

    public int getQuantidadeBanheiros() { return quantidadeBanheiros; }
    public void setQuantidadeBanheiros(int quantidadeBanheiros) { this.quantidadeBanheiros = quantidadeBanheiros; }

    public int getQuantidadeComodos() { return quantidadeComodos; }
    public void setQuantidadeComodos(int quantidadeComodos) { this.quantidadeComodos = quantidadeComodos; }
}
