package Pilha;

import org.junit.Assert;
import org.junit.Test;

import com.pedrowindisch.Pilha.PilhaCheiaException;
import com.pedrowindisch.Pilha.PilhaLista;
import com.pedrowindisch.Pilha.PilhaVaziaException;

public class PilhaListaTest {
    @Test
    public void testEstaVaziaPilhaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        Assert.assertTrue(pilha.estaVazia());
    }

    @Test
    public void testEstaVaziaPilhaNaoVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);

        Assert.assertFalse(pilha.estaVazia());
    }

    @Test
    public void testEmpilhamento() throws Exception {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        Assert.assertEquals(pilha.pop().intValue(), 30);
        Assert.assertEquals(pilha.pop().intValue(), 20);
        Assert.assertEquals(pilha.pop().intValue(), 10);
        Assert.assertTrue(pilha.estaVazia());
    }
    
    @Test
    public void testPilhaVaziaException() throws Exception {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        Assert.assertThrows(
                PilhaVaziaException.class,
                () -> pilha.pop());
    }

    @Test
    public void testPeek() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        Assert.assertEquals(pilha.peek().intValue(), 30);
    }

    @Test
    public void testLiberar() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();

        Assert.assertTrue(pilha.estaVazia());
    }
}
