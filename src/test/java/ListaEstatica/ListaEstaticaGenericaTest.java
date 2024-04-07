package ListaEstatica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.pedrowindisch.ListaEstatica.ListaEstaticaGenerica;

public class ListaEstaticaGenericaTest {
    @Test
    public void testInclusaoDados() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.toString(), "5,10,15,20");
    }

    @Test
    public void testObterTamanho() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.getTamanho(), 4);
    }

    @Test
    public void testBuscaElementoExistente() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.buscar(15), 2);
    }

    @Test
    public void testBuscaElementoInexistente() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.buscar(30), -1);
    }

    @Test
    public void testRetirarElemente() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

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
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();
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
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals((int) lista.obterElemento(3), 20);
    }

    @Test
    public void testObterElementoInexistente() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

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
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertTrue(lista.estaVazia());
    }

    @Test
    public void testInverterPar() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.inverter();

        assertEquals(lista.toString(), "20,15,10,5");
    }


    @Test
    public void testInverterImpar() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);

        lista.inverter();

        assertEquals(lista.toString(), "25,20,15,10,5");
    }

    @Test
    public void testRetirarElementos() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();

        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);

        lista.retirarElementos(2, 4);

        assertEquals(lista.toString(), "10,20,60");
    }
    

    @Test
    public void testRetirarElementos2() {
        ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<Integer>();
        
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(60);
        lista.inserir(60);
        lista.inserir(60);
        lista.inserir(60);
        lista.inserir(60);

        lista.retirarElementos(2, 3);

        assertEquals(lista.toString(), "10,20,50,60,60,60,60,60,60");
    }
}