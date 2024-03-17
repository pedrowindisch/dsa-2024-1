package ListaEncadeada;
// 1 Verificar se é reconhecida
// lista vazia
// Apenas construir a lista estaVazia() = true
// 2 Verificar se é reconhecida
// lista não vazia
// Adicionar o número 5 na lista estaVazia() = false
// 3 Validar inclusão de um
// número
// Adicionar o número 5 na lista Obter o primeiro objeto da lista.
// Conferir que tenha sido retornado nó e o nó
// contenha 5.
// Certificar-se que não haja mais nós
// 4 Validar inclusão de 3
// números
// Adicionar os números 5, 10, 15
// – nesta ordem
// Obter os objetos da lista e certificar-se que hajam
// apenas 3 nós e os valores devem ser 15, 10 e 5
// (nesta ordem).
// 5 Validar busca de dados na
// lista na primeira posição
// Adicionar os números 5, 10, 15
// e 20 – nesta ordem
// Buscar o número 20
// Certificar-se que o método buscar() retorne um nó
// contendo o número 20
// 6 Validar busca de dados no
// meio da lista
// Adicionar os números 5, 10, 15
// e 20 – nesta ordem
// Buscar o número 15
// Certificar-se que o método buscar() retorne um nó
// contendo o número 15
// 7 Validar busca de dado
// inexistente
// Adicionar os números 5, 10, 15
// e 20 – nesta ordem
// Buscar o número 50
// buscar() deve resultar null.
// 8 Validar exclusão de primeiro
// elemento da lista
// Adicionar os números 5, 10, 15
// e 20 – nesta ordem
// Solicitar exclusão de número 20
// Após o algoritmo de remoção, navegar na lista e
// certificar-se que a lista contenha exclusivamente os
// números 5, 10 e 15.
// 9 Validar exclusão de
// elemento do meio da lista
// Adicionar os números 5, 10, 15
// e 20 – nesta ordem
// Solicitar exclusão de número 15
// Após o algoritmo de remoção, navegar na lista e
// certificar-se que a lista contenha exclusivamente os
// números 5, 10 e 20.
// 10 Validar que obterNo()
// retorna nó da posição 0
// Criar lista e adicionar os
// números 5, 10, 15, 20 – nesta
// ordem
// obterNo(0) deve resultar no nó que armazena 20
// 11 Validar que obterNo()
// retorna nó da última posição
// Criar lista e adicionar os
// números 5, 10, 15, 20 – nesta
// ordem
// obterNo(3) deve resultar no nó que armazena 5
// 12 Validar que obterNo() recusa
// tentativa de ler posição
// invalidade nó
// Criar lista e adicionar os
// números 5, 10, 15, 20
// obterNo(10) deve lançar a exceção
// IndexOutOfBoundsException
// 13 Validar método
// obterComprimento() para
// lista vazia
// Criar lista vazia. obterComprimento() deve resultar em 0.
// 14 Validar método
// obterComprimento() para
// lista não vazia.
// Criar lista e adicionar os
// números 5, 10, 15, 20
// obterComprimento() deve resultar em 4.

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
