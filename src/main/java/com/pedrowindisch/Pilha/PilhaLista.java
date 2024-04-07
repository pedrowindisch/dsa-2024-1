package com.pedrowindisch.Pilha;

import com.pedrowindisch.ListaSimplesmenteEncadeada.ListaSimplesmenteEncadeada;

public class PilhaLista<T> implements Pilha<T> {
    private ListaSimplesmenteEncadeada<T> lista;

    public PilhaLista() {
        this.lista = new ListaSimplesmenteEncadeada<>();
    }

    public void push(T info) throws PilhaCheiaException {
        this.lista.inserir(info);
    }

    public T pop() throws PilhaVaziaException {
        T elemento = this.peek();
        this.lista.retirar(elemento);

        return elemento;
    }

    public T peek() throws PilhaVaziaException {
        if (this.lista.estaVazia())
            throw new PilhaVaziaException();

        return this.lista.getPrimeiro().getInfo();
    }

    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    public void liberar() {
        this.lista = new ListaSimplesmenteEncadeada<>();
    }
    
}
