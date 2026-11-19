package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
    private String telefone;
    private String celular;
    private LocalDate dataIngresso;
    private String cargo;
    private double salarioBase;
    private double percentualComissao;
    private String usuario;
    private String senha;
    private List<Transacao> transacoes;

    public Funcionario(String cpf, String nome, String endereco, String telefoneContato,
                       String email, String sexo, String estadoCivil, String profissao,
                       String telefone, String celular, LocalDate dataIngresso,
                       String cargo, double salarioBase, double percentualComissao,
                       String usuario, String senha) {
        super(cpf, nome, endereco, telefoneContato, email, sexo, estadoCivil, profissao);
        this.telefone = telefone;
        this.celular = celular;
        this.dataIngresso = dataIngresso;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.percentualComissao = percentualComissao;
        this.usuario = usuario;
        this.senha = senha;
        transacoes = new ArrayList<>();
    }

    public double calcularComissao(double valorComissaoImobiliaria) {
        return valorComissaoImobiliaria * percentualComissao / 100.0;
    }

    public double calcularSalario() {
        double totalComissoes = 0;
        for (Transacao transacao : transacoes) {
            totalComissoes += transacao.getValorComissaoFuncionario();
        }
        return salarioBase + totalComissoes;
    }

    public void adicionarTransacao(Transacao transacao) {
        if (transacao != null && !transacoes.contains(transacao)) {
            transacoes.add(transacao);
        }
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public LocalDate getDataIngresso() { return dataIngresso; }
    public void setDataIngresso(LocalDate dataIngresso) { this.dataIngresso = dataIngresso; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    public double getPercentualComissao() { return percentualComissao; }
    public void setPercentualComissao(double percentualComissao) { this.percentualComissao = percentualComissao; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public List<Transacao> getTransacoes() { return transacoes; }
}
