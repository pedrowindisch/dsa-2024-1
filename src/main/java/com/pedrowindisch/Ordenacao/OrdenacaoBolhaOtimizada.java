package com.pedrowindisch.Ordenacao;

public class OrdenacaoBolhaOtimizada<T extends Comparable> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        int n = this.getInfo().length;
        
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < n - 1; i++) {
                if (this.getInfo()[i].compareTo(this.getInfo()[i + 1]) > 0) {
                    trocar(i, i + 1);
                    trocou = true;
                }
            }
            n--;
        }
    }
}