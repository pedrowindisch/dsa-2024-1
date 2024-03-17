package ListaEstatica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pedrowindisch.ListaEstatica.ListaEstatica;

public class ListaEstaticaTest {
    @Test
    public void testInclusaoDados() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.toString(), "5,10,15,20");
    }

    @Test
    public void testObterTamanho() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.getTamanho(), 4);
    }

    @Test
    public void testBuscaElementoExistente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.buscar(15), 2);
    }

    @Test
    public void testBuscaElementoInexistente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.buscar(30), -1);
    }

    @Test
    public void testRetirarElemente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals(lista.toString(), "5,15,20");
        assertEquals(lista.getTamanho(), 3);
    }

    @Test
    public void testRedimensionamento() {
        ListaEstatica lista = new ListaEstatica();
        String mensagemEsperada = "";

        for (int i = 1; i <= 15; i++) {
            lista.inserir(i);

            mensagemEsperada += i;
            if (i < 15) {
                mensagemEsperada += ",";
            }
        }

        assertEquals(lista.toString(), mensagemEsperada);
        assertEquals(lista.getTamanho(), 15);
    }

    @Test
    public void testObterElementoExistente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.obterElemento(3), 20);
    }

    @Test
    public void testObterElementoInexistente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> lista.obterElemento(5));
    }
    
    @Test
    public void testLiberar() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertTrue(lista.estaVazia());
    }
}