package com.pedrowindisch.Pilha;

import com.pedrowindisch.ListaEstatica.ListaEstatica;

public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = (T[]) new Object[limite];
        this.tamanho = 0; 
    }

    public void push(T info) throws PilhaCheiaException {
        if (this.tamanho == this.limite)
            throw new PilhaCheiaException();

        this.info[this.tamanho] = info;
        this.tamanho++;
    }

    public T pop() throws PilhaVaziaException {
        T elemento = this.peek();
        this.info[this.tamanho - 1] = null;
        this.tamanho--;

        return elemento;
    }

    public T peek() throws PilhaVaziaException {
        if (this.tamanho == 0)
            throw new PilhaVaziaException();

        return this.info[this.tamanho - 1];
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public void liberar() {
        for (int i = 0; i < this.tamanho; i++)
            this.info[i] = null;

        this.tamanho = 0;
    }
    
    public String toString() {
        String resultado = "";

        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += this.info[i];

            if (i != 0)
                resultado += ",";
        }

        return resultado;
    }

    public void concatenar(PilhaVetor<T> p) {
        if ((this.limite - this.tamanho) < p.tamanho)
            throw new PilhaCheiaException();

        for (int i = 0; i < p.tamanho; i++)
            this.push(p.info[i]);
    }
}
