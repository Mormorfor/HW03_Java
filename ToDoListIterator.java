import java.util.Date;
import java.util.Iterator;

/**
 * an iterator class for ToDoList objects
 */
public class ToDoListIterator implements Iterator<Task> {
    ToDoList toDoList;
    Date upToDate;
    int i;

    /**
     * Constructor method
     * @param toDoList object to be iterated
     */
    ToDoListIterator(ToDoList toDoList){
        this.toDoList = toDoList.clone();
        this.toDoList.sortTasks();
        upToDate = toDoList.getScanningDueDate();
        i = 0;
    }

    /**
     * check if ToDoList has next element
     * if no scanning border has been set goes through the whole list
     * if there is a border goes up to the border
     * @return true - if element exists
     *         false - if last element has been reached
     */
    @Override
    public boolean hasNext() {

        int size = toDoList.toDoSize();
        if(upToDate == null){
            if(i < size)
                return true;
            else
                return false;
        }
        else{
            if( (i < size) && (toDoList.getElementByIndex(i).getDueDate().compareTo(upToDate) <= 0))
                return true;
            else
                return false;
        }

    }
    /**
     * get next element of the ToDoList
     * @return next ToDoList element
     */
    @Override
    public Task next() {
        Task returnTask = toDoList.getElementByIndex(i);
        i++;
        return returnTask;
    }
}
