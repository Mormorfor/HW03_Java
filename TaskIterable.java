import java.util.Date;

public interface TaskIterable<Task> extends Iterable<Task> {
    void setScanningDueDate(Date date);


}
