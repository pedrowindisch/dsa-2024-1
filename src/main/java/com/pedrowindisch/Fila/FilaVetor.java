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

        this.info[(this.inicio + tamanho) % this.limite] = valor;
        this.tamanho++;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public T peek() {
        if (this.estaVazia())
            throw new FilaVaziaException();

        return (T) this.info[this.inicio % this.limite];
    }

    public T retirar() {
        T valor = peek();

        inicio = (inicio + 1) % limite;
        tamanho = tamanho - 1;

        return valor;
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
    
    public void encolher() {
        Object[] novoVetor = new Object[this.tamanho];

        for (int i = 0; i < tamanho; i++)
            novoVetor[i] = this.info[(this.inicio + i) % this.limite];

        this.info = novoVetor;
        this.limite = this.tamanho;
        this.inicio = 0;
    }
}
