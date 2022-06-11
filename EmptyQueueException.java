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
