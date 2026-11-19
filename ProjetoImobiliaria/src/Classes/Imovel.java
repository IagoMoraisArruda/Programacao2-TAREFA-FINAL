package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Imovel {
    private String codigo;
    private Endereco endereco;
    private LocalDate dataConstrucao;
    private LocalDate dataDisponibilizacao;
    private LocalDate dataConclusao;
    private CategoriaImovel categoria;
    private StatusImovel status;
    private double valorSugerido;
    private double valorReal;
    private List<Cliente> proprietarios;

    public Imovel(String codigo, Endereco endereco, LocalDate dataConstrucao,
                  LocalDate dataDisponibilizacao, CategoriaImovel categoria,
                  StatusImovel status, double valorSugerido) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.dataConstrucao = dataConstrucao;
        this.dataDisponibilizacao = dataDisponibilizacao;
        this.categoria = categoria;
        this.status = status;
        this.valorSugerido = valorSugerido;
        this.valorReal = 0;
        this.dataConclusao = null;
        proprietarios = new ArrayList<>();
    }

    public void adicionarProprietario(Cliente cliente) {
        if (cliente != null && !proprietarios.contains(cliente)) {
            proprietarios.add(cliente);
            cliente.adicionarImovelProprietario(this);
        }
    }

    public abstract String getDetalhesEspecificos();

    public String getResumo() {
        return "Código: " + codigo
                + " | Categoria: " + categoria
                + " | Status: " + status
                + " | Bairro: " + endereco.getBairro()
                + " | Valor sugerido: R$ " + String.format("%.2f", valorSugerido)
                + "\nEndereço: " + endereco
                + "\n" + getDetalhesEspecificos();
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public LocalDate getDataConstrucao() { return dataConstrucao; }
    public void setDataConstrucao(LocalDate dataConstrucao) { this.dataConstrucao = dataConstrucao; }

    public LocalDate getDataDisponibilizacao() { return dataDisponibilizacao; }
    public void setDataDisponibilizacao(LocalDate dataDisponibilizacao) { this.dataDisponibilizacao = dataDisponibilizacao; }

    public LocalDate getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(LocalDate dataConclusao) { this.dataConclusao = dataConclusao; }

    public CategoriaImovel getCategoria() { return categoria; }
    public StatusImovel getStatus() { return status; }
    public void setStatus(StatusImovel status) { this.status = status; }

    public double getValorSugerido() { return valorSugerido; }
    public void setValorSugerido(double valorSugerido) { this.valorSugerido = valorSugerido; }

    public double getValorReal() { return valorReal; }
    public void setValorReal(double valorReal) { this.valorReal = valorReal; }

    public List<Cliente> getProprietarios() { return proprietarios; }
}
