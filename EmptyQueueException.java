/**
 * An exception class being thrown if there is an attempt to get an item from an empty queue.
 */
public class EmptyQueueException extends QueueException{

    EmptyQueueException(){
        super();
    }
    EmptyQueueException(String message){
        super(message);
    }
    EmptyQueueException(String message, Throwable cause){
        super(message, cause);
    }
}
