/**
 * Exception caused by negative sized queue creation
 */
public class NegativeCapacityException extends QueueException{

    /**
     * {@inheritDoc}
     */
    NegativeCapacityException(){
        super();
    }
    /**
     * {@inheritDoc}
     */
    NegativeCapacityException(String message){
        super(message);
    }
    /**
     * {@inheritDoc}
     */
    NegativeCapacityException(String message, Throwable cause){
        super(message, cause);
    }



}
