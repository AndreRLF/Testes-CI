package banco.user;

public class Conta {

    private double saldo;

    public Conta() {
        this.saldo = 0;
    }

    public void realizarDeposito(double valorDeposito) {
        this.saldo += valorDeposito;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean verificarEmprestimo() {
        if(this.saldo > 100){
            return true;
        }else{
            return false;
        }
    }

    public void debitarValor(double valor) {
        this.saldo -= valor;
    }

    public void realizaEmprestimo(){
        if(verificarEmprestimo()){

        }
    }
}
