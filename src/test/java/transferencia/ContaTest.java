package transferencia;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Cliente flavia, joseLuis;
    Conta contaFlavia, contaJoseLuis;

    @BeforeEach
    void SetUp(){
        flavia = new Cliente("Flavia Regina Boconcelo", "23456789","16820750870");
        joseLuis = new Cliente("Jose Luis Amancio","13997532", "01315802805");
        contaFlavia = new Conta("2468", "123456", 5000.00, flavia);
        contaJoseLuis = new Conta("5305", "013335", 5000.00, joseLuis);
    }

    @Test
    public void  realizarTransferenciaValidaFJ(){
       contaFlavia.realizarTransferencia(1000.00, contaJoseLuis);
       assertEquals(4000.00, contaFlavia.getSaldo());
    }

    @Test
    public void realizarTransferenciaValidaJF(){
        contaJoseLuis.realizarTransferencia(3000.00, contaFlavia);
        assertEquals(2000.00, contaJoseLuis.getSaldo());
    }

    @Test
    public void realizarTransferenciaInvalidaFJ(){
        boolean resultado =  contaFlavia.realizarTransferencia(5000.01,contaJoseLuis);
        assertFalse(resultado);
    }

    @Test
    public void realizarTransferenciaInvalidaJF(){
        boolean resultado = contaJoseLuis.realizarTransferencia(5000.01, contaFlavia);
        assertFalse(resultado);
    }
    @Test
    public void realizarTransferenciaInvalidaValorNegativoFJ(){
        boolean resultado = contaFlavia.realizarTransferencia(-1.00, contaJoseLuis);
        assertFalse(resultado);
    }

    @Test
    public void realizarTransferenciaInvalidaValorNegativoJF() {
        boolean resultado = contaJoseLuis.realizarTransferencia(-1.00, contaFlavia);
        assertFalse(resultado);

    }


}