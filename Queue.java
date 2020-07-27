// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;
	
    public Queue(int capacity) {    
        this.capacity=capacity;
        queue=new Node[capacity];
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return size()==0;
    }
	
    public boolean isFull() {
        return capacity==size();
    }

    public void enqueue(Node<V> node) {
        if(!isFull()) {
            queue[size()] =  node;
            currentSize++;
        }
    }

    public NodeBase<V> dequeue() {
        if(!isEmpty()) {
            NodeBase<V> temp=queue[0];


            for (int i = 0; i < (currentSize - 1); i++) {
                queue[i] = queue[i + 1];
                queue[i + 1] = null;
            }
            currentSize--;
            return temp;
        }
        else return null;
    }
    public void add(int p,V e){
        enqueue(new Node<V>(p,e));
    }

}

