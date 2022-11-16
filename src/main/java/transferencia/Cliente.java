package transferencia;

public class Cliente {
    private String nome, rg, cpf;

    public Cliente(String nome, String rg, String cpf) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }
}
