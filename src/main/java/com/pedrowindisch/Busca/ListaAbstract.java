package com.pedrowindisch.Busca;

public abstract class ListaAbstract<T> {
    private Object[] info;
    private int tamanho;

    public ListaAbstract() {
        this.info = new Object[10];
        this.tamanho = 0;
    }

    protected Object[] getInfo() {
        return info;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    protected void redimensionar() {
        Object[] novo = new Object[this.info.length + 10];

        for (int i = 0; i < this.tamanho; i++) {
            novo[i] = this.info[i];
        }

        this.info = novo;
    }

    public abstract void inserir(T valor);

    public void exibir() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(this.info[i]);
        }
    }

    public abstract int buscar(T valor);

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

    public void retirarElementos(int inicio, int fim) {
        int qtdElementosRemover = fim - inicio + 1;
        for (int i = inicio; i <= fim; i ++)
            this.info[i] = null;
        
        for (int i = fim + 1; i < tamanho; i++) {
            this.info[i - qtdElementosRemover] = this.info[i];
            this.info[i] = null;
        }
        
        tamanho -= qtdElementosRemover;
    }
}
