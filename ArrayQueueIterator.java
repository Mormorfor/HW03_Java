import java.util.Iterator;

/**
 * an iterator class for ArrayQueue objects
 * @param <E> data type stored in the ArrayQueue
 */
public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E> {
    private ArrayQueue<E> currentQueue;
    private int currentElement;
    private int remainingElements;

    /**
     * constructor method
     * @param queue ArrayQueue to be iterated
     */
    ArrayQueueIterator(ArrayQueue <E> queue){
        currentQueue = queue;
        currentElement = currentQueue.getFront();
        remainingElements = currentQueue.size();
    }

    /**
     * check if queue has next element
     * @return true - if element exists
     *         false - if last element has been reached
     */
    @Override
    public boolean hasNext() {
        if(remainingElements <= 0){
            return false;
        }
        else
            return true;
    }

    /**
     * get next element of the queue
     * @return next queue element 
     */
    @Override
    public E next() {
        E element = currentQueue.getElement(currentElement);
        if(currentElement == currentQueue.getMaxCapacity() - 1){
            currentElement = 0;
        }
        else
            currentElement++;

        remainingElements--;
        return element;
    }
}
