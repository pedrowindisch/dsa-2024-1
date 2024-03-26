package com.pedrowindisch.ListaDupla;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro = null;

    public ListaDupla() {

    }
    
    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novoNo = new NoListaDupla<T>();
        novoNo.setInfo(valor);

        novoNo.setProximo(primeiro);

        if (primeiro != null) {
            primeiro.setAnterior(novoNo);
        }

        primeiro = novoNo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(valor))
                return atual;

            atual = atual.getProximo();
        }

        return atual;
    }

    public void retirar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null && !atual.getInfo().equals(valor))
            atual = atual.getProximo();

        if (atual.getAnterior() != null) {
            atual.getAnterior().setProximo(atual.getProximo());
        }

        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(atual.getAnterior());
        }

        if (atual == primeiro) {
            primeiro = atual.getProximo();
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> atual = primeiro;
        while (atual != null && atual.getProximo() != null)
            atual = atual.getProximo();

        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> ultimo = primeiro;
        while (ultimo != null && ultimo.getProximo() != null)
            ultimo = ultimo.getProximo();

        while (ultimo != null) {
            NoListaDupla<T> atual = ultimo;
            ultimo = ultimo.getAnterior();
            
            atual.setProximo(null);
            atual.setAnterior(null);
        }

        primeiro = null;
    }
    
    public String toString() {
        String resultado = "";

        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            resultado += atual.toString() + ",";

            atual = atual.getProximo();
        }
        
        return resultado.substring(0, resultado.length());
    }
}
