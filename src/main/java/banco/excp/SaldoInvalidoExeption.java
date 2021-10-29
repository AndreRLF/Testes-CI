package banco.excp;

public class SaldoInvalidoExeption extends Throwable {
    public SaldoInvalidoExeption(String saldo_invalido) {
        super(saldo_invalido);
    }

}
