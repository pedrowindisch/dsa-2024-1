package com.pedrowindisch.ListaEstatica;

public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    private void redimensionar() {
        int[] novo = new int[this.info.length + 10];

        for (int i = 0; i < this.tamanho; i++) {
            novo[i] = this.info[i];
        }

        this.info = novo;
    }

    public void inserir(int valor) {
        if (this.tamanho == this.info.length) {
            this.redimensionar();
        }

        this.info[this.tamanho] = valor;
        this.tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(this.info[i]);
        }
    }

    public int buscar(int valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i] == valor) {
                return i;
            }
        }

        return -1;
    }

    public void retirar(int valor) {
        int posicao = this.buscar(valor);
        if (posicao == -1)
            return;

        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.info[i] = this.info[i + 1];
        }

        this.tamanho--;
    }

    public void liberar() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    public int obterElemento(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException();
        }

        return this.info[posicao];
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public String toString() {
        String str = "";

        for (int i = 0; i < this.tamanho; i++) {
            str += this.info[i];
            if (i < this.tamanho - 1) {
                str += ",";
            }
        }

        return str;
    }
}
