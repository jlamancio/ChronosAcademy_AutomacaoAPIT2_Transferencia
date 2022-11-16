package transferencia;

public class Conta {

    private String agencia, numeroConta;
    private double saldo;
    Cliente proprietario;

    public Conta(String agencia, String numeroConta, double saldo, Cliente proprietario) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.proprietario = proprietario;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void realizarDeposito(double valor){
      saldo += valor;
    }

    public boolean realizarSaque(double valor){
        if (valor > saldo || valor < 0) {
            return false;
        }
        saldo -=valor;
        return true;
    }

    public boolean realizarTransferencia(double valor, Conta destino){
        if (realizarSaque(valor) == true){
                destino.realizarDeposito(valor);
                return true;
        }
        return false;
    }
}
