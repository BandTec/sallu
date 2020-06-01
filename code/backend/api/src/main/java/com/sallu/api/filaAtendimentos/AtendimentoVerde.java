package com.sallu.api.filaAtendimentos;

public class AtendimentoVerde <T> {

    private int tamanhoVerde;
    private T filaVerde[];

    public AtendimentoVerde(int tam) {
        tamanhoVerde = 0;
        filaVerde = (T[]) new Object[tam];
    }

    public boolean isEmpty() {
        return tamanhoVerde == 0;
    }

    public boolean isFull() {
        return (tamanhoVerde == filaVerde.length);
    }

    public void insert(T info) {
        if (!isFull()) {
            filaVerde[++tamanhoVerde] = info;
            tamanhoVerde++;
            filaVerde[tamanhoVerde] = info;
        } else {
            System.out.println("fila cheia!");
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        return filaVerde[0];
    }

    public T poll() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        T primeiro = peek();
        for (int i = 0; i < filaVerde.length; i++) {
            filaVerde[i] = filaVerde[i + 1];
        }
        tamanhoVerde--;
        return primeiro;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
        } else {
            for (int i = 0; i < tamanhoVerde; i++) {
                System.out.println(filaVerde[i]);
            }
        }
    }


}
