/**
 * Queue interface
 * @param <E> data type to be put into the queue
 */
public interface Queue<E extends Cloneable> extends Iterable<E>, Cloneable {
    /**
     * Add an element to the back of a queue
     * @param element element to be added to the queue
     */
    void enqueue(E element);
    /**
     * remove element from the front of the queue
     * @return the removed element
     */
    E dequeue();
    /**
     * view the front element of the queue without removing it
     * @return front element of the queue
     */
    E peek();
    /**
     * current number of queued elements
     * @return integer size of the queue
     */
    int size();
    /**
     * Checks if queue is empty
     * @return true - if empty
     *         false - if not empty
     */
    boolean isEmpty();

    /**
     * create a clone of the queue object
     * @return return the cloned object
     */
    Queue<E> clone();
}


