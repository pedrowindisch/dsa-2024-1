package com.pedrowindisch.Arvore;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        if (no == null)
            return "";

        String representacao = "<" + no.getInfo();
        NoArvore<T> noAtual = no.getPrimeiro();
        while (noAtual != null) {
            representacao += obterRepresentacaoTextual(noAtual);
            noAtual = noAtual.getProximo();
        }

        return representacao + ">";
    }
    
    public String toString() {
        return obterRepresentacaoTextual(raiz);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null)
            return false;

        return no.getInfo().equals(info)
            || pertence(no.getPrimeiro(), info)
            || pertence(no.getProximo(), info);
    }

    public boolean pertence(T info) {
        return pertence(this.raiz, info);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null)
            return 0;

        return 1 + contarNos(no.getPrimeiro()) + contarNos(no.getProximo());
    }

    public int contarNos() {
        return contarNos(raiz);
    }
}
