package com.sallu.api.filaAtendimentos;

public class AtendimentoObj <T>{

    private int tamanho;
    private T fila[];

    public AtendimentoObj(int tam) {
        tamanho = 0;
        fila = (T[]) new Object[tam];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return (tamanho == fila.length);
    }

    public void insert(T info) {
        if (!isFull()) {
            fila[++tamanho] = info;
            tamanho++;
            fila[tamanho] = info;
        } else {
            System.out.println("fila cheia!");
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        return fila[0];
    }

    public T poll() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        T primeiro = peek();
        for (int i = 0; i < fila.length; i++) {
            fila[i] = fila[i + 1];
        }
        tamanho--;
        return primeiro;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
        } else {
            for (int i = 0; i < tamanho; i++) {
                System.out.println(fila[i]);
            }
        }
    }


}
