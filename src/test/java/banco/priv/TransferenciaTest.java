package banco.priv;

import banco.excp.SaldoInvalidoExeption;
import banco.user.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransferenciaTest {

    @Test
    public void realizarTransferenciaEntreContasComSaldoInvalidoTest() throws SaldoInvalidoExeption {
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();

        Transferencia transferencia = new Transferencia();

        //Assume.assumeTrue(conta1.getSaldo() > 70);
        Throwable exception = Assertions.assertThrows(SaldoInvalidoExeption.class, () -> {
            transferencia.realizarTransferencia(conta1, conta2, 10.0);
        });

        Assertions.assertEquals("Saldo menor ou igual a zero", exception.getMessage());

    }

    @Test
    public void realizarTransferenciaValidaEntreContasTest() throws SaldoInvalidoExeption {
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        conta1.realizarDeposito(60.0);

        Transferencia transferencia = new Transferencia();
        transferencia.realizarTransferencia(conta1, conta2, 50.0);

        Assertions.assertEquals(10.0, conta1.getSaldo(), 0.0);
    }

}
