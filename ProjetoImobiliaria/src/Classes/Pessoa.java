package Classes;

public abstract class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefoneContato;
    private String email;
    private String sexo;
    private String estadoCivil;
    private String profissao;

    public Pessoa(String cpf, String nome, String endereco, String telefoneContato,
                  String email, String sexo, String estadoCivil, String profissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefoneContato = telefoneContato;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefoneContato() { return telefoneContato; }
    public void setTelefoneContato(String telefoneContato) { this.telefoneContato = telefoneContato; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }
}
