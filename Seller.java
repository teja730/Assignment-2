import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
    int catalogSize;
    public int sleepTime;
	public Thread t;
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attibutes
        // ...


        this.catalogSize=catalogSize;
        this.catalog=catalog;
        this.inventory=inventory;
        this.empty=empty;
        this.full=full;
        this.lock=lock;
        this.sleepTime=sleepTime;
        t=new Thread(this);
    }
    public  void sell() throws InterruptedException {

        lock.lock();
	try {

	    while(catalog.isFull()) {
            full.await();
        }
        if(!inventory.isEmpty()) {
            catalog.enqueue((Node<V>) inventory.dequeue());
            empty.signalAll();
        }

            //TODO Complete the try block for produce method
            // ...
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
        lock.unlock();

            //TODO Complete this block
	}
    }
}
