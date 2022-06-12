/**
 * Exception thrown while attempting to put an element while maximum capacity is reached
 */
public class QueueOverflowException extends QueueException{

    /**
     * {@inheritDoc}
     */
    QueueOverflowException(){
        super();
    }
    /**
     * {@inheritDoc}
     */
    QueueOverflowException(String message){
        super(message);
    }
    /**
     * {@inheritDoc}
     */
    QueueOverflowException(String message, Throwable cause){
        super(message, cause);
    }


}
