/**
 * Exception related to queue operation
 */
public class QueueException extends RuntimeException{
    /**
     * Basic constructor
     */
    QueueException(){
        super();
    }
    /**
     * Message constructor
     * @param message error message
     */
    QueueException(String message){
        super(message);
    }
    /**
     * Message and cause constructor
     * @param message error message
     * @param cause error cause
     */
    QueueException(String message, Throwable cause){
        super(message, cause);
    }


}
