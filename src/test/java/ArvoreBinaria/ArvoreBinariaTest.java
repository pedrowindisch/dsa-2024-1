package ArvoreBinaria;

import org.junit.Assert;
import org.junit.Test;

import com.pedrowindisch.ArvoreBinaria.ArvoreBinaria;
import com.pedrowindisch.ArvoreBinaria.NoArvoreBinaria;

public class ArvoreBinariaTest {
    @Test
    public void testReconheceVazia() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        Assert.assertTrue(arvore.estaVazia());
    }

    @Test
    public void testReconheceNaoVazia() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        arvore.setRaiz(new NoArvoreBinaria<Integer>(5));

        Assert.assertFalse(arvore.estaVazia());
    }

    @Test
    public void testRepresentacaoTextual() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        arvore.setRaiz(new NoArvoreBinaria<Integer>(
                1,
                new NoArvoreBinaria<Integer>(
                        2,
                        null,
                        new NoArvoreBinaria<Integer>(4)),
                new NoArvoreBinaria<Integer>(
                        3,
                        new NoArvoreBinaria<Integer>(5),
                        new NoArvoreBinaria<Integer>(6))));

        Assert.assertEquals(arvore.toString(), "<1<2<><4<><>>><3<5<><>><6<><>>>>");
    }
    
    @Test
    public void testPertence() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        arvore.setRaiz(new NoArvoreBinaria<Integer>(
                1,
                new NoArvoreBinaria<Integer>(
                        2,
                        null,
                        new NoArvoreBinaria<Integer>(4)),
                new NoArvoreBinaria<Integer>(
                        3,
                        new NoArvoreBinaria<Integer>(5),
                        new NoArvoreBinaria<Integer>(6))));

        Assert.assertTrue(arvore.pertence(1));
    }
    
    @Test
    public void testPertenceNaoRaizNaoFolha() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        arvore.setRaiz(new NoArvoreBinaria<Integer>(
                1,
                new NoArvoreBinaria<Integer>(
                        2,
                        null,
                        new NoArvoreBinaria<Integer>(4)),
                new NoArvoreBinaria<Integer>(
                        3,
                        new NoArvoreBinaria<Integer>(5),
                        new NoArvoreBinaria<Integer>(6))));

        Assert.assertTrue(arvore.pertence(3));
    }
    
    @Test
    public void testPertenceFolha() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        arvore.setRaiz(new NoArvoreBinaria<Integer>(
                1,
                new NoArvoreBinaria<Integer>(
                        2,
                        null,
                        new NoArvoreBinaria<Integer>(4)),
                new NoArvoreBinaria<Integer>(
                        3,
                        new NoArvoreBinaria<Integer>(5),
                        new NoArvoreBinaria<Integer>(6))));

        Assert.assertTrue(arvore.pertence(6));
    }
    
    @Test
    public void testNaoPertence() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        arvore.setRaiz(new NoArvoreBinaria<Integer>(
                1,
                new NoArvoreBinaria<Integer>(
                        2,
                        null,
                        new NoArvoreBinaria<Integer>(4)),
                new NoArvoreBinaria<Integer>(
                        3,
                        new NoArvoreBinaria<Integer>(5),
                        new NoArvoreBinaria<Integer>(6))));

        Assert.assertFalse(arvore.pertence(10));
    }
    
    @Test
    public void testContarNos() {
            ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

            arvore.setRaiz(new NoArvoreBinaria<Integer>(
                            1,
                            new NoArvoreBinaria<Integer>(
                                            2,
                                            null,
                                            new NoArvoreBinaria<Integer>(4)),
                            new NoArvoreBinaria<Integer>(
                                            3,
                                            new NoArvoreBinaria<Integer>(5),
                                            new NoArvoreBinaria<Integer>(6))));

            Assert.assertEquals(arvore.contarNos(), 6);
    }
    
    @Test
    public void testContarNosInternos() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<Integer>(
                1,
                new NoArvoreBinaria<Integer>(
                                2,
                                null,
                                new NoArvoreBinaria<Integer>(4)),
                new NoArvoreBinaria<Integer>(
                                3,
                                new NoArvoreBinaria<Integer>(5),
                                        new NoArvoreBinaria<Integer>(6)));
        arvore.setRaiz(raiz);

        Assert.assertEquals(arvore.contarNosInternos(raiz), 3);
}
}
