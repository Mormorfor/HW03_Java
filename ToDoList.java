import java.util.*;

public class ToDoList implements Cloneable, TaskIterable<Task> {
    private final static int MILLISECONDS_TO_MINUTES = 60000;

    private LinkedList<Task> toDoList;
    private Date scanningDueDate;


    ToDoList(){
        toDoList = new LinkedList<>();
        scanningDueDate = null;
    }


    public void addTask(Task task){
        String description = task.getDescription();
        for(Task oldTask : toDoList) {
            if(description.compareTo(oldTask.getDescription()) == 0) {
                throw new TaskAlreadyExistsException();
            }
        }
        toDoList.add(task);
    }
    public void sortTasks(){
        Comparator<Task> taskComparator = Comparator.comparing(Task::getDueDate).thenComparing(Task::getDescription);
        Collections.sort(toDoList,taskComparator);
    }

    @Override
    public String toString(){
        StringBuilder buildString = new StringBuilder();
        buildString.append("[");
        int size = toDoList.size();
        for(int i=0; i < size; i++){
            buildString.append("(");
            buildString.append(toDoList.get(i).toString());
            buildString.append(")");
            if( i < size - 1){
                buildString.append(", ");
            }
        }
        buildString.append("]");
        return buildString.toString();
    }

    @Override
    public ToDoList clone(){
        ToDoList newToDo = new ToDoList();
        int size = toDoList.size();
        try{
            for(int i=0; i < size; i++) {
                newToDo.addTask(toDoList.get(i).clone());
            }
            return newToDo;
        }catch(Exception e){
            return null;
        }
    }


    @Override
    public boolean equals (Object toDo){
        if(!(toDo instanceof ToDoList))
            return false;
        int currentSize = toDoList.size();
        if( currentSize!= ((ToDoList) toDo).toDoSize())
            return false;

        for(int i = 0; i < currentSize; i++){
            if(!(((ToDoList) toDo).taskIsContained(this.getElementByIndex(i))))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        long dateSum = 0;
        for(Task task : toDoList){
            dateSum += task.getDueDate().getTime();
            dateSum %= MILLISECONDS_TO_MINUTES;
        }
        return (int) dateSum;
    }


    @Override
    public Iterator iterator() {
        return new ToDoListIterator(this);
    }

    @Override
    public void setScanningDueDate(Date date) {
        this.scanningDueDate = date;
    }

    public Date getScanningDueDate() {
        return scanningDueDate;
    }

    public int toDoSize(){
        return toDoList.size();
    }
    public Task getElementByIndex(int i){
        return toDoList.get(i);
    }

    public boolean taskIsContained(Task task){
        return toDoList.contains(task);
    }

}
