package Classes;

import java.time.LocalDate;

public abstract class ImovelResidencial extends Imovel {
    private int quantidadeQuartos;
    private int quantidadeSuites;
    private int salasEstar;
    private int salasJantar;
    private int vagasGaragem;
    private double areaMetrosQuadrados;
    private boolean possuiArmarioEmbutido;
    private String descricao;

    public ImovelResidencial(String codigo, Endereco endereco, LocalDate dataConstrucao,
                             LocalDate dataDisponibilizacao, CategoriaImovel categoria,
                             StatusImovel status, double valorSugerido,
                             int quantidadeQuartos, int quantidadeSuites,
                             int salasEstar, int salasJantar, int vagasGaragem,
                             double areaMetrosQuadrados, boolean possuiArmarioEmbutido,
                             String descricao) {
        super(codigo, endereco, dataConstrucao, dataDisponibilizacao,
                categoria, status, valorSugerido);
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeSuites = quantidadeSuites;
        this.salasEstar = salasEstar;
        this.salasJantar = salasJantar;
        this.vagasGaragem = vagasGaragem;
        this.areaMetrosQuadrados = areaMetrosQuadrados;
        this.possuiArmarioEmbutido = possuiArmarioEmbutido;
        this.descricao = descricao;
    }

    protected String detalhesResidenciais() {
        return "Quartos: " + quantidadeQuartos
                + ", suítes: " + quantidadeSuites
                + ", salas de estar: " + salasEstar
                + ", salas de jantar: " + salasJantar
                + ", vagas: " + vagasGaragem
                + ", área: " + areaMetrosQuadrados + " m²"
                + ", armário embutido: " + (possuiArmarioEmbutido ? "sim" : "não")
                + ", descrição: " + descricao;
    }

    public int getQuantidadeQuartos() { return quantidadeQuartos; }
    public void setQuantidadeQuartos(int quantidadeQuartos) { this.quantidadeQuartos = quantidadeQuartos; }

    public int getQuantidadeSuites() { return quantidadeSuites; }
    public void setQuantidadeSuites(int quantidadeSuites) { this.quantidadeSuites = quantidadeSuites; }

    public int getSalasEstar() { return salasEstar; }
    public void setSalasEstar(int salasEstar) { this.salasEstar = salasEstar; }

    public int getSalasJantar() { return salasJantar; }
    public void setSalasJantar(int salasJantar) { this.salasJantar = salasJantar; }

    public int getVagasGaragem() { return vagasGaragem; }
    public void setVagasGaragem(int vagasGaragem) { this.vagasGaragem = vagasGaragem; }

    public double getAreaMetrosQuadrados() { return areaMetrosQuadrados; }
    public void setAreaMetrosQuadrados(double areaMetrosQuadrados) { this.areaMetrosQuadrados = areaMetrosQuadrados; }

    public boolean isPossuiArmarioEmbutido() { return possuiArmarioEmbutido; }
    public void setPossuiArmarioEmbutido(boolean possuiArmarioEmbutido) { this.possuiArmarioEmbutido = possuiArmarioEmbutido; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
