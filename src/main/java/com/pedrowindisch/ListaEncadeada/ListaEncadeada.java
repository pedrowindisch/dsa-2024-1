package com.pedrowindisch.ListaEncadeada;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;
    
    public ListaEncadeada() {
    
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<T>(info);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                return atual;
            }

            atual = atual.getProximo();
        }

        return null;
    }
    
    public void retirar(T info) {
        NoLista<T> atual = primeiro;
        NoLista<T> anterior = null;

        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                if (anterior != null) {
                    anterior.setProximo(atual.getProximo());
                } else {
                    primeiro = atual.getProximo();
                }

                break;
            }

            anterior = atual;
            atual = atual.getProximo();
        }
    }

    public int obterComprimento() {
        int comprimento = 0;

        NoLista<T> atual = primeiro;
        while (atual != null) {
            comprimento++;
            atual = atual.getProximo();
        }

        return comprimento;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0 || idx >= obterComprimento())
            throw new IndexOutOfBoundsException();

        NoLista<T> atual = primeiro;
        for (int i = 0; i < idx; i++) {
            atual = atual.getProximo();
        }

        return atual;
    }

    public String toString() {
        String str = "";

        NoLista<T> atual = primeiro;
        while (atual != null) {
            str += atual.getInfo().toString();
            if (atual.getProximo() != null) {
                str += ",";
            }

            atual = atual.getProximo();
        }

        return str;
    }
}
