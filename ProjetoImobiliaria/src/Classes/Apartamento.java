package Classes;

import java.time.LocalDate;

public class Apartamento extends ImovelResidencial {
    private int andar;
    private double valorCondominio;
    private boolean portaria24Horas;

    public Apartamento(String codigo, Endereco endereco, LocalDate dataConstrucao,
                       LocalDate dataDisponibilizacao, StatusImovel status,
                       double valorSugerido, int quantidadeQuartos, int quantidadeSuites,
                       int salasEstar, int salasJantar, int vagasGaragem,
                       double areaMetrosQuadrados, boolean possuiArmarioEmbutido,
                       String descricao, int andar, double valorCondominio,
                       boolean portaria24Horas) {
        super(codigo, endereco, dataConstrucao, dataDisponibilizacao,
                CategoriaImovel.APARTAMENTO, status, valorSugerido,
                quantidadeQuartos, quantidadeSuites, salasEstar, salasJantar,
                vagasGaragem, areaMetrosQuadrados, possuiArmarioEmbutido, descricao);
        this.andar = andar;
        this.valorCondominio = valorCondominio;
        this.portaria24Horas = portaria24Horas;
    }

    @Override
    public String getDetalhesEspecificos() {
        return "Apartamento: " + detalhesResidenciais()
                + ", andar: " + andar
                + ", condomínio: R$ " + String.format("%.2f", valorCondominio)
                + ", portaria 24h: " + (portaria24Horas ? "sim" : "não");
    }

    public int getAndar() { return andar; }
    public void setAndar(int andar) { this.andar = andar; }

    public double getValorCondominio() { return valorCondominio; }
    public void setValorCondominio(double valorCondominio) { this.valorCondominio = valorCondominio; }

    public boolean isPortaria24Horas() { return portaria24Horas; }
    public void setPortaria24Horas(boolean portaria24Horas) { this.portaria24Horas = portaria24Horas; }
}
