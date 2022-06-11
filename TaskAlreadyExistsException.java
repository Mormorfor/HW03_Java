public class TaskAlreadyExistsException extends RuntimeException{

    TaskAlreadyExistsException(){
        super();
    }
    TaskAlreadyExistsException(String message){
        super(message);
    }
    TaskAlreadyExistsException(String message, Throwable cause){
        super(message,cause);

    }



}
