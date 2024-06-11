package com.pedrowindisch.Busca;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        if (getTamanho() == getInfo().length) {
            redimensionar();
        }

        Object[] info = this.getInfo();

        int posicao = 0;
        while (posicao < getTamanho() && valor.compareTo((T) info[posicao]) > 0) {
            posicao++;
        }
        for (int i = getTamanho(); i > posicao; i--) {
            info[i] = info[i - 1];
        }
        info[posicao] = valor;

        setTamanho(getTamanho() + 1);
    }

    @Override
    public int buscar(T valor) {
        Object[] info = this.getInfo();

        int inicio = 0;
        int fim = this.getTamanho() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (((Comparable) info[meio]).compareTo(valor) == 0) {
                return meio;
            } else if (((Comparable) info[meio]).compareTo(valor) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
    
}
