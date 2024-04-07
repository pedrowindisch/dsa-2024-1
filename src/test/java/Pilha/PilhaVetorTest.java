package Pilha;

import org.junit.Assert;
import org.junit.Test;

import com.pedrowindisch.Pilha.PilhaCheiaException;
import com.pedrowindisch.Pilha.PilhaVaziaException;
import com.pedrowindisch.Pilha.PilhaVetor;

public class PilhaVetorTest {
    @Test
    public void testEstaVaziaPilhaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(0);

        Assert.assertTrue(pilha.estaVazia());
    }

    @Test
    public void testEstaVaziaPilhaNaoVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);

        Assert.assertFalse(pilha.estaVazia());
    }

    @Test
    public void testEmpilhamento() throws Exception {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        Assert.assertEquals(pilha.pop().intValue(), 30);
        Assert.assertEquals(pilha.pop().intValue(), 20);
        Assert.assertEquals(pilha.pop().intValue(), 10);
        Assert.assertTrue(pilha.estaVazia());
    }

    @Test
    public void testPilhaCheiaException() throws Exception {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        Assert.assertThrows(
                PilhaCheiaException.class,
                () -> pilha.push(40));
    }
    
    @Test
    public void testPilhaVaziaException() throws Exception {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);

        Assert.assertThrows(
                PilhaVaziaException.class,
                () -> pilha.pop());
    }

    @Test
    public void testPeek() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        Assert.assertEquals(pilha.peek().intValue(), 30);
    }

    @Test
    public void testLiberar() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();

        Assert.assertTrue(pilha.estaVazia());
    }

    @Test
    public void testConcatenar() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        PilhaVetor<Integer> pilhaSecundaria = new PilhaVetor<>(2);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilhaSecundaria.push(40);
        pilhaSecundaria.push(50);

        pilha.concatenar(pilhaSecundaria);

        Assert.assertEquals(pilha.toString(), "50,40,30,20,10");
    }
}
