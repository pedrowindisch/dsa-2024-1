package com.pedrowindisch.Busca;

public class ListaEstatica<T> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        T[] info = (T[]) this.getInfo();

        if (this.getTamanho() == info.length) {
            this.redimensionar();
        }

        info[this.getTamanho()] = valor;
        this.setTamanho(getTamanho() + 1);
    }

    @Override
    public int buscar(T valor) {
        T[] info = (T[]) this.getInfo();

        for (int i = 0; i < this.getTamanho(); i++) {
            if (info[i] == valor) {
                return i;
            }
        }

        return -1;
    }
    
}
