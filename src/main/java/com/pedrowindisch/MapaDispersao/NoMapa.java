package com.pedrowindisch.MapaDispersao;

public class NoMapa<T> {
    private int chave;
    private T info;

    public int getChave() {
        return this.chave;
    }

    public T getInfo() {
        return this.info;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NoMapa) {
            NoMapa<T> no = (NoMapa<T>) obj;
            return this.chave == no.getChave();
        }

        return false;
    }
}
