Assignment2
Item : This class is used to store the name and price of the item .
Node : This creates a node by taking input as priority and the value. 
Queue: This class is used to store the input into a queue by the following enqueue& dequeue functions .The dequeue returns the element taken from the queue.
PriorityQueue: This class is used to store and remove the elements in a priority wise order.The main idea is to remove the least priority element which can be done by a single iteration. First it will find the index of the element of least priority and then dequeue the element.
Buyer: In this class we remove the element from the priority queue. We use locks and conditions to comunicate between the threads which are operating in seller.
Seller: In this class the inventory is dequeued and the element is added to the catalog. We use locks here also to comunicate with another threads.
Assignment2driver: This takes the input from the user then stores it in the inventory. As the seller and buyer are the process done at same time we use threads to do the work. The thread are created and that is given to perform to buyer and seller classes.
The locks and the conditions are used not to get deadlock in threads, which can cause the program not complete.  