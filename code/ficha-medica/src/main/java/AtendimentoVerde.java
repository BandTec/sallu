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
        return tamanhoVerde == filaVerde.length;
    }

    public void insert(T info) {
        if (isFull()) {
            System.out.println("Fila cheira");
            return;
        }
        filaVerde[tamanhoVerde++]=info;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        return filaVerde[0];
    }

    public T poll() {
        T primeiro = peek();
        if (!isEmpty()) {
            for (int i=0; i<tamanhoVerde-1;i++){
                filaVerde[i]=filaVerde[i+1];
            }
            filaVerde[tamanhoVerde-1]=null;
            tamanhoVerde--;
        }
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
