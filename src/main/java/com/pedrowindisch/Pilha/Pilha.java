package com.pedrowindisch.Pilha;

public interface Pilha<T> {
    public void push(T info) throws PilhaCheiaException;

    public T pop() throws PilhaVaziaException;

    public T peek() throws PilhaVaziaException;

    public boolean estaVazia();

    public void liberar();
}
