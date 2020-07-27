
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    public PriorityQueue(int capacity) {    
        this.capacity=capacity;
        queue= new NodeBase[capacity];
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return size()==0;
    }
	
    public boolean isFull() {
        return size()==capacity;
    }

    public void enqueue(Node<V> node) {
        if(!isFull()) {
            queue[size()] = node;
            currentSize++;
            /*for(int i=currentSize-1;i>0;i--){
                if(queue[i].getPriority()<queue[i-1].getPriority()) {
                    NodeBase<V> temp = queue[i];
                    queue[i]=queue[i-1];
                    queue[i-1]=temp;
                }
            }*/
            //System.out.print(currentSize);
        }
    }
    public void add(int p,V e){
        enqueue(new Node<V>(p,e));
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
        if(!isEmpty()) {
            //NodeBase<V> temp = queue[0];
            int h = 0;
            int x=queue[0].getPriority();

            for (int i = 0; i < size(); i++) {
                if (queue[i].getPriority() < x)
                    h = i;
            }
            NodeBase<V> temp = queue[h];
            queue[h] = null;
            for (int i = h; i < size() - 1; i++) {
                queue[i] = queue[i + 1];
                queue[i + 1] = null;
            }/*
            for (int i = 0; i < size() - 1; i++) {
                queue[i] = queue[i + 1];
                queue[i + 1] = null;
            }*/
            currentSize--;
            return temp;
        }
        else return null;
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i].show();
	}
    }
}

