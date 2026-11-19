package Classes;

import java.time.LocalDate;

public class Terreno extends Imovel {
    private double areaMetrosQuadrados;
    private double largura;
    private double comprimento;
    private boolean possuiAcliveOuDeclive;

    public Terreno(String codigo, Endereco endereco, LocalDate dataConstrucao,
                   LocalDate dataDisponibilizacao, StatusImovel status,
                   double valorSugerido, double areaMetrosQuadrados,
                   double largura, double comprimento, boolean possuiAcliveOuDeclive) {
        super(codigo, endereco, dataConstrucao, dataDisponibilizacao,
                CategoriaImovel.TERRENO, status, valorSugerido);
        this.areaMetrosQuadrados = areaMetrosQuadrados;
        this.largura = largura;
        this.comprimento = comprimento;
        this.possuiAcliveOuDeclive = possuiAcliveOuDeclive;
    }

    @Override
    public String getDetalhesEspecificos() {
        return "Terreno: área " + areaMetrosQuadrados + " m², largura: " + largura
                + " m, comprimento: " + comprimento + " m, possui aclive/declive: "
                + (possuiAcliveOuDeclive ? "sim" : "não");
    }

    public double getAreaMetrosQuadrados() { return areaMetrosQuadrados; }
    public void setAreaMetrosQuadrados(double areaMetrosQuadrados) { this.areaMetrosQuadrados = areaMetrosQuadrados; }

    public double getLargura() { return largura; }
    public void setLargura(double largura) { this.largura = largura; }

    public double getComprimento() { return comprimento; }
    public void setComprimento(double comprimento) { this.comprimento = comprimento; }

    public boolean isPossuiAcliveOuDeclive() { return possuiAcliveOuDeclive; }
    public void setPossuiAcliveOuDeclive(boolean possuiAcliveOuDeclive) { this.possuiAcliveOuDeclive = possuiAcliveOuDeclive; }
}
