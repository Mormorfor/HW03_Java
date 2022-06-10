import java.lang.reflect.Method;
import java.util.Iterator;

public class ArrayQueue <E extends Cloneable> implements Queue{
    private int maxCapacity;
    private E [] queue;
    private int front, rear,numberOfElements;
    ArrayQueue (int maxCapacity){
        if(maxCapacity < 0){
            throw new NegativeCapacityException();
        }
        else {
            this.maxCapacity = maxCapacity;
        }
        try {
            queue = (E[]) new Cloneable[maxCapacity];
        }
        catch (ClassCastException e){
            System.out.println("Class Cast Error!");
        }
        front = 0;
        rear = 0;
        numberOfElements = 0;
    }
    @Override
    public void enqueue(Cloneable element) {
        if(numberOfElements == maxCapacity){
            throw new QueueOverflowException();
        }
        else{
            queue[rear] = (E) element;
            if(rear == maxCapacity - 1){
                rear = 0;
            }
            else{
                rear++;
            }
            numberOfElements++;
        }
    }

    @Override
    public E dequeue() {
        E returnedElement;
        if(numberOfElements == 0){
            throw new EmptyQueueException();
        }
        else{
            returnedElement = queue [front];
            queue[front] = null;
            if(front == maxCapacity - 1){
                front = 0;
            }
            else{
                front++;
            }
            numberOfElements--;
        }
        return returnedElement;
    }

    @Override
    public E peek() {
        if(numberOfElements == 0){
            throw new EmptyQueueException();
        }
        else{
            return queue[front];
        }
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public ArrayQueue clone()  {
        ArrayQueue<E> clone;
        E element;

        try{
            clone = (ArrayQueue<E>) super.clone();
            E[] newQueue = (E[]) new Cloneable[maxCapacity];
            clone.setQueue(newQueue);
            for(int i = 0; i < maxCapacity; i++){
                if(queue[i] != null){
                    element = (E) queue[i].getClass().getMethod("clone").invoke(queue[i]);
                    clone.setElement(element,i);
                }
            }
            return clone;
        }
        catch(Exception e){
            return null;
        }

    }

    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator(this);
    }

    public int getFront() {
        return front;
    }
    public int getRear() {
        return rear;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public E getElement(int i){
        return queue[i];
    }
    public void setElement(E element, int i){
        this.queue[i] = element;
    }
    public void setQueue(E[] queue){
        this.queue = queue;
    }
    public int getNumberOfElements() {
        return numberOfElements;
    }
}
