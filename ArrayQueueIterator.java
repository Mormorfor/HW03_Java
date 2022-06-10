import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator {
    private ArrayQueue<E> currentQueue;
    private int currentElement;
    private int lastElement;
    private int remainingElements;

    ArrayQueueIterator(ArrayQueue <E> queue){
        currentQueue = queue;
        currentElement = currentQueue.getFront();
        lastElement = currentQueue.getRear();
        remainingElements = currentQueue.getNumberOfElements();
    }
    @Override
    public boolean hasNext() {
        if(remainingElements <= 0){
            return false;
        }
        else
            return true;
    }

    @Override
    public Object next() {
        Object element = currentQueue.getElement(currentElement);
        if(currentElement == currentQueue.getMaxCapacity() - 1){
            currentElement = 0;
        }
        else
            currentElement++;

        remainingElements--;
        return element;
    }
}
