public class NegativeCapacityException extends QueueException{

    NegativeCapacityException(){
        super();
    }
    NegativeCapacityException(String message){
        super(message);
    }
    NegativeCapacityException(String message, Throwable cause){
        super(message, cause);
    }



}
