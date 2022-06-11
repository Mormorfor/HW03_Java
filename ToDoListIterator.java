import java.util.Date;
import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task> {
    ToDoList toDoList;
    Date upToDate;
    int i;

    ToDoListIterator(ToDoList toDoList){
        this.toDoList = toDoList;
        upToDate = toDoList.getScanningDueDate();
        i = 0;
    }

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
            if( (i < size) && (toDoList.getElementByIndex(i).getDueDate().compareTo(upToDate) < 0))
                return true;
            else
                return false;
        }

    }

    @Override
    public Task next() {
        Task returnTask = toDoList.getElementByIndex(i);
        i++;
        return returnTask;
    }
}
