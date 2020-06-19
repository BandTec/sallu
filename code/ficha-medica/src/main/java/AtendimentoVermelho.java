public class AtendimentoVermelho <T>{
    private int tamanhoVermelho;
    private T filaVermelho[];

    public AtendimentoVermelho(int tam) {
        tamanhoVermelho = 0;
        filaVermelho = (T[]) new Object[tam];
    }

    public boolean isEmpty() {
        return tamanhoVermelho == 0;
    }

    public boolean isFull() {
        return tamanhoVermelho == filaVermelho.length;
    }

    public void insert(T info) {
        if (isFull()) {
            System.out.println("Fila cheia");
            return;
        }
        filaVermelho[tamanhoVermelho++]=info;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        return filaVermelho[0];
    }

    public T poll() {
        T primeiro = peek();
        if (!isEmpty()) {
            for (int i =0; i< tamanhoVermelho-1; i++){
                filaVermelho[i]=filaVermelho[i+1];
            }
            filaVermelho[tamanhoVermelho-1]=null;
            tamanhoVermelho--;
        }
        return primeiro;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
        } else {
            for (int i = 0; i < tamanhoVermelho; i++) {
                System.out.println(filaVermelho[i]);
            }
        }
    }

}
