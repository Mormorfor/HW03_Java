import java.util.Date;

/**
 * Iterable extension requires for task objects
 * @param <Task> an iterator parameter
 */
public interface TaskIterable<Task> extends Iterable<Task> {
    /**
     * set a scanning border parameter
     * @param date border parameter
     */
    void setScanningDueDate(Date date);


}
