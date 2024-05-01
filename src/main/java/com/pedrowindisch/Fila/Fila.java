package com.pedrowindisch.Fila;

public interface Fila<T> {
    void inserirValor(T valor);

    boolean estaVazia();

    T peek();

    T retirar();

    void liberar();
}
