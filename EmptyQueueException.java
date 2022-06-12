/**
 * An exception class being thrown if there is an attempt to get an item from an empty queue.
 */
public class EmptyQueueException extends QueueException{

    /**
     * {@inheritDoc}
     */
    EmptyQueueException(){
        super();
    }

    /**
     * {@inheritDoc}
     */
    EmptyQueueException(String message){
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    EmptyQueueException(String message, Throwable cause){
        super(message, cause);
    }
}
