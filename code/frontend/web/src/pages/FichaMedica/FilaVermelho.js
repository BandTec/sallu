class FilaVermelho{
    constructor(size){
        this.queue = new Array(size);
        this.size = size;
        this.head = 0;
        this.tail = 0;
    }

    isFull(){
        return this.size == this.tail
    }

    isEmpty(){
        return this.head == this.tail;
    }

    peek(){
        return this.queue[this.head];
    }

    enqueue(elemento){
        if(this.isFull()){
            return "Infelizmente a fila está completa";
        }else{
            this.queue[this.tail]= elemento;
            this.tail++;
            return "O valor foi adicionado";
        }
    }

    dequeue(){
        if(this.isEmpty()){
            return "Esta fila não contém elementos"
        }else{
            this.head++;
            return this.queue.shift();
        }
    }
}
export default FilaVermelho; 