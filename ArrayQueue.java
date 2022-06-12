import java.util.Iterator;

/**
 * A Queue implementation based on array
 * @param <E> data type to be stored in the queue
 */
public class ArrayQueue <E extends Cloneable> implements Queue<E>{
    private final int maxCapacity;
    private E [] queue;
    private int front, rear,numberOfElements;

    /**
     * A constructor method
     * @param maxCapacity a maximum capacity of a queue
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public E peek() {
        if(numberOfElements == 0){
            throw new EmptyQueueException();
        }
        else{
            return queue[front];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return numberOfElements;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    /**
     * create a deep clone of the queue
     * @return a cloned ArrayQueue
     */
    @Override
    public ArrayQueue <E> clone()  {
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

    /**
     * create an instance of ArrayQueueIterator
     * @return ArrayQueueIterator with current object as its parameter.
     */
    @Override
    public Iterator <E> iterator() {
        return new ArrayQueueIterator<E>(this);
    }

    /**
     * get index of front element
     * @return integer index front
     */
    public int getFront() {
        return front;
    }

    /**
     * get maximal capacity of the current ArrayQueue
     * @return maximal queue capacity integer
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * get element of the queue by i index
     * @param i index of required element
     * @return element of the queue at the i position
     */
    E getElement(int i){
        return queue[i];
    }

    /**
     * sets an element at specific index
     * @param element new element to be set
     * @param i index at which to include
     */
    private void setElement(E element, int i){
        this.queue[i] = element;
    }

    /**
     * set a new queue array
     * @param queue array of queue's elements
     */
    private void setQueue(E[] queue){
        this.queue = queue;
    }

}
