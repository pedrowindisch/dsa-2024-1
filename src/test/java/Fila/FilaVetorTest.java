package Fila;

import org.junit.Assert;
import org.junit.Test;

import com.pedrowindisch.Fila.FilaVetor;

public class FilaVetorTest {
    @Test
    public void testEncolher() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserirValor(0);
        fila.inserirValor(0);
        fila.inserirValor(0);

        fila.retirar();
        fila.retirar();
        fila.retirar();

        fila.inserirValor(10);
        fila.inserirValor(20);
        fila.inserirValor(30);
        fila.inserirValor(40);

        fila.encolher();

        Assert.assertEquals(fila.peek().intValue(), 10);
    }
}
