public class QueueException extends RuntimeException{

    QueueException(){
        super();
    }
    QueueException(String message){
        super(message);
    }
    QueueException(String message, Throwable cause){
        super(message, cause);
    }


}
