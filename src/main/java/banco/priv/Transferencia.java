package banco.priv;

import banco.excp.SaldoInvalidoExeption;
import banco.user.Conta;

public class Transferencia {

    public void realizarTransferencia(Conta conta1, Conta conta2, double valor) throws SaldoInvalidoExeption {
        if(conta1.getSaldo() >= valor){
            conta1.debitarValor(valor);
            conta2.realizarDeposito(valor);
        }else{
            throw new SaldoInvalidoExeption("Saldo menor ou igual a zero");
        }
    }

    public boolean verificaValidadedeValordaTransferencia(double valor){
        if(valor > 0){
            return true;
        }else{
            return false;
        }
    }


}
