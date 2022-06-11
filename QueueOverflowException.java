public class QueueOverflowException extends QueueException{

    QueueOverflowException(){
        super();
    }
    QueueOverflowException(String message){
        super(message);
    }
    QueueOverflowException(String message, Throwable cause){
        super(message, cause);
    }


}
