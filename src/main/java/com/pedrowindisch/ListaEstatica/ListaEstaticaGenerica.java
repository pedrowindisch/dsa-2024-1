package com.pedrowindisch.ListaEstatica;

public class ListaEstaticaGenerica<T> {
    private Object[] info;
    private int tamanho;

    public ListaEstaticaGenerica() {
        this.info = new Object[10];
        this.tamanho = 0;
    }

    private void redimensionar() {
        Object[] novo = new Object[this.info.length + 10];

        for (int i = 0; i < this.tamanho; i++) {
            novo[i] = this.info[i];
        }

        this.info = novo;
    }

    public void inserir(T valor) {
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

    public int buscar(T valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i] == valor) {
                return i;
            }
        }

        return -1;
    }

    public void retirar(T valor) {
        int posicao = this.buscar(valor);
        if (posicao == -1)
            return;

        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.info[i] = this.info[i + 1];
        }

        this.tamanho--;
    }

    public void liberar() {
        this.info = new Object[10];
        this.tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException();
        }

        return (T) this.info[posicao];
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
            str += this.info[i].toString();
            if (i < this.tamanho - 1) {
                str += ",";
            }
        }

        return str;
    }

    public void inverter() {
        // Object[] novo = new Object[this.info.length];

        // for (int i = 0; i < this.tamanho; i++) {
        //     novo[i] = this.info[this.tamanho - i - 1];
        // }

        // this.info = novo;

        int qtyToChange = tamanho / 2;

        int currentIndex = 0;
        while (qtyToChange > 0) {
            Object bkp = this.info[currentIndex];
            this.info[currentIndex] = this.info[tamanho - currentIndex - 1];
            this.info[tamanho - currentIndex - 1] = bkp;

            currentIndex++;
            qtyToChange--;
        }
        
    }
}
