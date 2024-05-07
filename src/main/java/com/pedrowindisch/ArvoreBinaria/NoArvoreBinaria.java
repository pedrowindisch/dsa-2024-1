package com.pedrowindisch.ArvoreBinaria;

public class NoArvoreBinaria<T> {
    private T info;

    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direita;

    public NoArvoreBinaria(T info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esquerda, NoArvoreBinaria<T> direita) {
        this.info = info;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvoreBinaria<T> getDireita() {
        return this.direita;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }
}
