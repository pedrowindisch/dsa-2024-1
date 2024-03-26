package com.pedrowindisch.ListaDupla;

public class NoListaDupla<T> {
    private NoListaDupla<T> anterior;
    private NoListaDupla<T> proximo;
    private T info;

    public void setInfo(T valor) {
        info = valor;
    }

    public T getInfo() {
        return info;
    }

    public void setProximo(NoListaDupla<T> prox) {
        proximo = prox;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setAnterior(NoListaDupla<T> ant) {
        anterior = ant;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }
}
