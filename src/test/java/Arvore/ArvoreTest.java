package Arvore;

import org.junit.Assert;
import org.junit.Test;

import com.pedrowindisch.Arvore.Arvore;
import com.pedrowindisch.Arvore.NoArvore;

public class ArvoreTest {
    @Test
    public void testRepresentacaoTextual() {
        Arvore<Integer> arvore = new Arvore<Integer>();

        NoArvore<Integer> raiz = new NoArvore<Integer>(1);

        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);

        raiz.setPrimeiro(no2);
        no2.setProximo(no3);
        no3.setProximo(no4);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);

        no2.setPrimeiro(no5);
        no5.setProximo(no6);
        no6.setProximo(no7);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8);

        no3.setPrimeiro(no8);

        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        no4.setPrimeiro(no9);
        no9.setProximo(no10);

        arvore.setRaiz(raiz);

        Assert.assertEquals(arvore.toString(), "<1<2<5><6><7>><3<8>><4<9><10>>>");
    }
    
    @Test
    public void testPertence() {
        Arvore<Integer> arvore = new Arvore<Integer>();

        NoArvore<Integer> raiz = new NoArvore<Integer>(1);
        
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);

        raiz.setPrimeiro(no2);
        no2.setProximo(no3);
        no3.setProximo(no4);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);

        no2.setPrimeiro(no5);
        no5.setProximo(no6);
        no6.setProximo(no7);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8);

        no3.setPrimeiro(no8);

        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        no4.setPrimeiro(no9);
        no9.setProximo(no10);

        arvore.setRaiz(raiz);

        Assert.assertTrue(arvore.pertence(7));
    }
    
    @Test
    public void testNaoPertence() {
        Arvore<Integer> arvore = new Arvore<Integer>();

        NoArvore<Integer> raiz = new NoArvore<Integer>(1);
        
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);

        raiz.setPrimeiro(no2);
        no2.setProximo(no3);
        no3.setProximo(no4);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);

        no2.setPrimeiro(no5);
        no5.setProximo(no6);
        no6.setProximo(no7);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8);

        no3.setPrimeiro(no8);

        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        no4.setPrimeiro(no9);
        no9.setProximo(no10);

        arvore.setRaiz(raiz);

        Assert.assertFalse(arvore.pertence(55));
    }
    
    @Test
    public void testContarNos() {
        Arvore<Integer> arvore = new Arvore<Integer>();

        NoArvore<Integer> raiz = new NoArvore<Integer>(1);
        
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);

        raiz.setPrimeiro(no2);
        no2.setProximo(no3);
        no3.setProximo(no4);

        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);

        no2.setPrimeiro(no5);
        no5.setProximo(no6);
        no6.setProximo(no7);

        NoArvore<Integer> no8 = new NoArvore<Integer>(8);

        no3.setPrimeiro(no8);

        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        no4.setPrimeiro(no9);
        no9.setProximo(no10);

        arvore.setRaiz(raiz);

        Assert.assertEquals(arvore.contarNos(), 10);
    }
}
