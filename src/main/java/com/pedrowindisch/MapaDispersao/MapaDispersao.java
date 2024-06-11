package com.pedrowindisch.MapaDispersao;

import com.pedrowindisch.ListaSimplesmenteEncadeada.ListaSimplesmenteEncadeada;

public class MapaDispersao<T> {
    private ListaSimplesmenteEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaSimplesmenteEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        return chave % info.length;
    }

    public void inserir(int chave, T dado) {
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        no.setInfo(dado);

        int hash = calcularHash(chave);
        ListaSimplesmenteEncadeada<NoMapa<T>> lista = info[hash];
        if (lista == null) {
            lista = new ListaSimplesmenteEncadeada<>();
            info[hash] = lista;
        }

        lista.inserir(no);
    }

    public void remover(int chave) {
        int hash = calcularHash(chave);

        ListaSimplesmenteEncadeada<NoMapa<T>> lista = info[hash];
        if (lista == null)
            return;

        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);

        lista.retirar(no);
    }

    public T buscar(int chave) {
        int hash = calcularHash(chave);

        ListaSimplesmenteEncadeada<NoMapa<T>> lista = info[hash];
        if (lista == null)
            return null;

        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);

        return lista
            .buscar(no)
            .getInfo()
            .getInfo();
    }
}
