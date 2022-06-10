import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator {
    private ArrayQueue<E> currentQueue;
    private int currentElement;
    private int lastElement;
    ArrayQueueIterator(ArrayQueue <E> queue){
        currentQueue = queue;
        currentElement = currentQueue.getFront();
        lastElement = currentQueue.getRear();
    }
    @Override
    public boolean hasNext() {
        if(currentElement == lastElement){
            return false;
        }
        else
            return true;
    }

    @Override
    public Object next() {
        if(currentElement == currentQueue.getNumberOfElements()){
            currentElement = 0;
        }
        else
            currentElement++;
        return currentQueue.getElement(currentElement);
    }
}
