package Busca;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.pedrowindisch.Busca.ListaOrdenada;

public class BuscaTest {
    // 1
    @Test
    public void testeInserir() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        lista.inserir(100);
        lista.inserir(20);
        lista.inserir(70);
        lista.inserir(1);
        assertEquals("1,20,70,100", lista.toString());
    }

    // 2
    @Test
    public void testeBuscar20() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        assertEquals(2, lista.buscar(20));
    }

    // 3
    @Test
    public void testeBuscar40() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        assertEquals(4, lista.buscar(40));
    }

    // 4
    @Test
    public void testeBuscar70() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        assertEquals(7, lista.buscar(70));
    }

    // 5
    @Test
    public void testeBuscar100() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        assertEquals(10, lista.buscar(100));
    }

    // 6
    @Test
    public void testeBuscar85() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        assertEquals(-1, lista.buscar(85));
    }
}
