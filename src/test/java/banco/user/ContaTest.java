package banco.user;

import banco.user.Conta;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;

public class ContaTest {
    private Conta conta;
    private Logger logger = Logger.getLogger("my-Logger");

    @BeforeEach
    public void setUp(){
        this.conta = new Conta();
    }

    @AfterEach
    public void printMessage(){
        this.logger.info("Saldo atual (conta): " +this.conta.getSaldo());
    }

    @RepeatedTest(value = 3, name = "{displayName} : {currentRepetition} de {totalRepetitions}")
    @DisplayName("Teste Repetido - Verificação de Débito")
    public void verificaDepositoEmContaTest(){
        conta.realizarDeposito(50.0);
        Assertions.assertEquals(50.0, conta.getSaldo(), 0.0);
    }
    //Expected : 50
    //Actual : 60

    @ParameterizedTest(name = "Entrada : {0}")
    @ValueSource(doubles = {100.0, 90.0})
    @DisplayName("Teste Repetido - Verificação de Débito")
    public void verificaDepositoEmContaTest2(){
        conta.realizarDeposito(50.0);
        Assertions.assertEquals(50.0, conta.getSaldo(), 0.0);
    }

    @Test
    @DisplayName("Verificação de Disponibilidade de Emprestimo")
    public void verificarDisponibilidadeEmprestimoOKTest(){
        conta.realizarDeposito(100); //fixture
        conta.realizarDeposito(50); //fixture

        boolean retornoEmprestimo = conta.verificarEmprestimo();//chama ao método-al

        Assertions.assertTrue(retornoEmprestimo);//assertion
    }

    @Test
    public void verificarDisponibilidadeEmprestimoFalseTest(){
        boolean retornoEmprestimo = conta.verificarEmprestimo();//chama ao método-al

        Assertions.assertFalse(retornoEmprestimo);//assertion
    }

}
