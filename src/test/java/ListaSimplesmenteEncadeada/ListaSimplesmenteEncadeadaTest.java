package ListaSimplesmenteEncadeada;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pedrowindisch.ListaSimplesmenteEncadeada.ListaSimplesmenteEncadeada;
import com.pedrowindisch.ListaSimplesmenteEncadeada.NoLista;

public class ListaSimplesmenteEncadeadaTest {
    @Test
    public void testListaVazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testListaNaoVazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    public void testInclusaoDeUmNumero() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);

        assertTrue(lista.getPrimeiro().getInfo() == 5);
        assertTrue(lista.getPrimeiro().getProximo() == null);
    }

    @Test
    public void testInclusaoDeTresNumeros() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        assertTrue(lista.toString().equals("15,10,5"));
    }

    @Test
    public void testBuscaDeDadosNaPrimeiraPosicao() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
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
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
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
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.buscar(50);
        assertTrue(no == null);
    }

    @Test
    public void testExclusaoDePrimeiroElementoDaLista() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);
        assertTrue(lista.toString().equals("15,10,5"));
    }

    @Test
    public void testExclusaoDeElementoDoMeioDaLista() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(15);
        assertTrue(lista.toString().equals("20,10,5"));
    }

    @Test
    public void testObterNoRetornaNoDaPosicao0() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(0);
        assertTrue(no.getInfo() == 20);
    }

    @Test
    public void testObterNoRetornaNoDaUltimaPosicao() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(3);
        assertTrue(no.getInfo() == 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testObterNoRecusaTentativaDeLerPosicaoInvalida() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.obterNo(10);
    }

    @Test
    public void testObterComprimentoParaListaVazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        assertTrue(lista.obterComprimento() == 0);
    }

    @Test
    public void testObterComprimentoParaListaNaoVazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertTrue(lista.obterComprimento() == 4);
    }

    @Test
    public void testRetirarTodos() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(15);
        lista.inserir(20);

        assertTrue(lista.obterComprimento() == 5);

        lista.retirarTodos(15);

        assertTrue(lista.obterComprimento() == 3);
        assertTrue(lista.toString().equals("20,10,5"));
    }

    @Test
    public void testRetirarTodos2() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);
        lista.inserir(15);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertTrue(lista.obterComprimento() == 5);

        lista.retirarTodos(10);

        assertTrue(lista.obterComprimento() == 4);
        assertTrue(lista.toString().equals("20,15,15,5"));
    }


    @Test
    public void testRetirarTodos3() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        lista.inserir(5);

        assertTrue(lista.obterComprimento() == 1);

        lista.retirarTodos(5);

        assertTrue(lista.obterComprimento() == 0);
        assertTrue(lista.toString().equals(""));

        lista.inserir(5);
        assertTrue(lista.obterComprimento() == 1);
        assertTrue(lista.toString().equals("5"));
    }

    
    @Test
    public void testRetirarTodosVazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<Integer>();
        assertTrue(lista.obterComprimento() == 0);
        lista.retirarTodos(5);
        assertTrue(lista.obterComprimento() == 0);
        assertTrue(lista.toString().equals(""));
    }
}
