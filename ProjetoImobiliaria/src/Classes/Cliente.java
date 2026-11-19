package Classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private List<Cliente> fiadores;
    private List<String> indicacoes;
    private List<String> telefonesContato;
    private List<Imovel> imoveisComoProprietario;

    public Cliente(String cpf, String nome, String endereco, String telefoneContato,
                   String email, String sexo, String estadoCivil, String profissao) {
        super(cpf, nome, endereco, telefoneContato, email, sexo, estadoCivil, profissao);
        fiadores = new ArrayList<>();
        indicacoes = new ArrayList<>();
        telefonesContato = new ArrayList<>();
        if (getTelefoneContato() != null && !getTelefoneContato().trim().isEmpty()) {
            telefonesContato.add(getTelefoneContato());
        }
        imoveisComoProprietario = new ArrayList<>();
    }

    public void adicionarFiador(Cliente fiador) {
        if (fiador != null && fiador != this && !fiadores.contains(fiador)) {
            fiadores.add(fiador);
        }
    }

    public void adicionarIndicacao(String indicacao) {
        if (indicacao != null && !indicacao.trim().isEmpty()) {
            indicacoes.add(indicacao);
        }
    }

    public void adicionarTelefoneContato(String telefone) {
        if (telefone != null && !telefone.trim().isEmpty()) {
            telefonesContato.add(telefone);
        }
    }

    public void adicionarImovelProprietario(Imovel imovel) {
        if (imovel != null && !imoveisComoProprietario.contains(imovel)) {
            imoveisComoProprietario.add(imovel);
        }
    }

    public List<Cliente> getFiadores() { return fiadores; }
    public List<String> getIndicacoes() { return indicacoes; }
    public List<String> getTelefonesContato() { return telefonesContato; }
    public List<Imovel> getImoveisComoProprietario() { return imoveisComoProprietario; }
}
