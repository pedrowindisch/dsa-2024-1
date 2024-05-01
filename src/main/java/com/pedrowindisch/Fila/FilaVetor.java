package com.pedrowindisch.Fila;

public class FilaVetor<T> implements Fila<T> {
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
        this.info = new Object[limite];
    }

    public void inserirValor(T valor) {
        if (tamanho == limite)
            throw new FilaCheiaException();
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public T peek() {
        if (this.estaVazia())
            throw new FilaVaziaException();

        return null;
    }

    public T retirar() {
        throw new UnsupportedOperationException("Unimplemented method 'retirar'");
    }

    public void liberar() {
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        return null;
    }

    public String toString() {
        return "";
    }

    public int getLimite() {
        return this.limite;
    } 
}
