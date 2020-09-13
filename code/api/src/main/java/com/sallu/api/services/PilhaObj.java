package com.sallu.api.services;

public class PilhaObj<T> {

    private int topo;
    private final T[] pilha;


    public PilhaObj(int capacidade) {
        topo = -1;                /* inicializa topo com -1 */
        pilha= (T[]) new Object[capacidade];    /* cria o vetor da pilha */
      }

    public boolean isFull() {
        return (topo == pilha.length - 1);
        /*
         * if (topo == (pilha.length - 1))
         * { return true; } return false;
         */
    }

    public void push(T info) {
        if (!isFull()) {
            pilha[++topo] = info;
            /* a instrução acima equivale às 2 abaixo:
            topo++;
            pilha[topo] = info;
            */
        }
        else {        /* pilha cheia */
            System.out.println("Pilha cheia");
        }
    }


      /* Método isEmpty() - devolve true se a pilha está vazia
       * e false caso contrário
       */
      public boolean isEmpty() {
        return topo == -1;

        /*
         * instrução acima equivale a:
         *    if(topo == -1) {
         *        return true;
         *    }
         *    return false;
}        */
      }

      public T pop() {
        if (!isEmpty()) {
            return pilha[topo--];

            /* a instrução acima equivale às 3 abaixo:
            int retorno = pilha[topo];
            topo--;
            return retorno;
            */
        }
        return null;
    }

    /* Método peek - Retorna o elemento do topo da pilha */
    public T peek() {
        if(!isEmpty()) {
            return pilha[topo];
        }
        return null;
    }
}