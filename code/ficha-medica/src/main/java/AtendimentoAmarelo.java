public class AtendimentoAmarelo <T> {


    private int tamanhoAmarelo;
    private T filaAmarelo[];

    public AtendimentoAmarelo(int tam){

        tamanhoAmarelo = 0;
        filaAmarelo = (T[]) new Object[tam];
    }

    public boolean isEmpty() {
        return tamanhoAmarelo == 0;
    }

    public boolean isFull() {
        return (tamanhoAmarelo == filaAmarelo.length);
    }

    public void insert(T info) {
        if (!isFull()) {
            filaAmarelo[++tamanhoAmarelo] = info;
            tamanhoAmarelo++;
            filaAmarelo[tamanhoAmarelo] = info;
        } else {
            System.out.println("fila cheia!");
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        return filaAmarelo[0];
    }

    public T poll() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return null;
        }
        T primeiro = peek();
        for (int i = 0; i < filaAmarelo.length; i++) {
            filaAmarelo[i] = filaAmarelo[i + 1];
        }
        tamanhoAmarelo--;
        return primeiro;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
        } else {
            for (int i = 0; i < tamanhoAmarelo; i++) {
                System.out.println(filaAmarelo[i]);
            }
        }
    }


}
