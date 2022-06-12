/**
 * Exception thrown if the task with the same description already exist
 */
public class TaskAlreadyExistsException extends RuntimeException{
    /**
     * Basic constructor
     */
    TaskAlreadyExistsException(){
        super();
    }
    /**
     * Message constructor
     * @param message error message
     */
    TaskAlreadyExistsException(String message){
        super(message);
    }
    /**
     * Message and cause constructor
     * @param message error message
     * @param cause error cause
     */
    TaskAlreadyExistsException(String message, Throwable cause){
        super(message,cause);

    }



}
