package ListaEncadeada;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pedrowindisch.ListaEncadeada.ListaEncadeada;
import com.pedrowindisch.ListaEncadeada.NoLista;

public class ListaEncadeadaTest {
    @Test
    public void testListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testListaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    public void testInclusaoDeUmNumero() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);

        assertTrue(lista.getPrimeiro().getInfo() == 5);
        assertTrue(lista.getPrimeiro().getProximo() == null);
    }

    @Test
    public void testInclusaoDeTresNumeros() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        assertTrue(lista.toString().equals("15,10,5"));
    }

    @Test
    public void testBuscaDeDadosNaPrimeiraPosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.buscar(20);
        assertNotNull(no);
        assertTrue(no.getInfo() == 20);
    }

    @Test
    public void testBuscaDeDadosNoMeioDaLista() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.buscar(15);
        assertNotNull(no);
        assertTrue(no.getInfo() == 15);
    }

    @Test
    public void testBuscaDeDadoInexistente() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.buscar(50);
        assertTrue(no == null);
    }

    @Test
    public void testExclusaoDePrimeiroElementoDaLista() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);
        assertTrue(lista.toString().equals("15,10,5"));
    }

    @Test
    public void testExclusaoDeElementoDoMeioDaLista() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(15);
        assertTrue(lista.toString().equals("20,10,5"));
    }

    @Test
    public void testObterNoRetornaNoDaPosicao0() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(0);
        assertTrue(no.getInfo() == 20);
    }

    @Test
    public void testObterNoRetornaNoDaUltimaPosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(3);
        assertTrue(no.getInfo() == 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testObterNoRecusaTentativaDeLerPosicaoInvalida() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.obterNo(10);
    }

    @Test
    public void testObterComprimentoParaListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        assertTrue(lista.obterComprimento() == 0);
    }

    @Test
    public void testObterComprimentoParaListaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertTrue(lista.obterComprimento() == 4);
    }
}
