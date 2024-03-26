package ListaDupla;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pedrowindisch.ListaDupla.ListaDupla;
import com.pedrowindisch.ListaDupla.NoListaDupla;

public class ListaDuplaTest {
    @Test
    public void testInsercao() {
        ListaDupla<Integer> lista = new ListaDupla<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> atual = lista.getPrimeiro();
        assertEquals(20, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(15, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(10, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(5, atual.getInfo().intValue());
    }
    
    @Test
    public void testBuscarInicio() {
        ListaDupla<Integer> lista = new ListaDupla<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> no = lista.buscar(20);
        assertEquals(20, no.getInfo().intValue());
    }

    @Test
    public void testBuscarMeioLista() {
        ListaDupla<Integer> lista = new ListaDupla<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> no = lista.buscar(10);
        assertEquals(10, no.getInfo().intValue());
    }


    @Test
    public void testRetirarInicio() {
        ListaDupla<Integer> lista = new ListaDupla<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        NoListaDupla<Integer> atual = lista.getPrimeiro();
        assertEquals(15, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(10, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(5, atual.getInfo().intValue());

        atual = atual.getAnterior();
        assertEquals(10, atual.getInfo().intValue());

        atual = atual.getAnterior();
        assertEquals(15, atual.getInfo().intValue());
    }
    

    @Test
    public void testRetirarMeio() {
        ListaDupla<Integer> lista = new ListaDupla<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        NoListaDupla<Integer> atual = lista.getPrimeiro();
        assertEquals(20, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(15, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(5, atual.getInfo().intValue());

        atual = atual.getAnterior();
        assertEquals(15, atual.getInfo().intValue());

        atual = atual.getAnterior();
        assertEquals(20, atual.getInfo().intValue());
    }
    
    
    @Test
    public void testRetirarFim() {
        ListaDupla<Integer> lista = new ListaDupla<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(5);

        NoListaDupla<Integer> atual = lista.getPrimeiro();
        assertEquals(20, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(15, atual.getInfo().intValue());

        atual = atual.getProximo();
        assertEquals(10, atual.getInfo().intValue());

        atual = atual.getAnterior();
        assertEquals(15, atual.getInfo().intValue());

        atual = atual.getAnterior();
        assertEquals(20, atual.getInfo().intValue());
    }
    
    @Test
    public void testLiberarNos() {
        ListaDupla<Integer> lista = new ListaDupla<Integer>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        ArrayList<NoListaDupla<Integer>> listaNos = new ArrayList<>();
        listaNos.add(lista.buscar(5));
        listaNos.add(lista.buscar(10));
        listaNos.add(lista.buscar(15));
        listaNos.add(lista.buscar(20));

        lista.liberar();

        for (NoListaDupla<Integer> no : listaNos) {
            assertNull(no.getAnterior());
            assertNull(no.getProximo());
        }
    }
}
