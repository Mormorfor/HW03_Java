import java.util.*;

public class ToDoList implements Cloneable, TaskIterable<Task> {
    private LinkedList<Task> toDoList;
    private Date scanningDueDate;


    ToDoList(){
        toDoList = new LinkedList<>();
        scanningDueDate = null;
    }


    public void addTask(Task task){
        if(toDoList.contains(task)) {
            throw new TaskAlreadyExistsException();
        }

        toDoList.add(task);
    }
    private void sortTasks(){
        Comparator<Task> taskComparator = Comparator.comparing(Task::getDueDate).thenComparing(Task::getDescription);
        Collections.sort(toDoList,taskComparator);
    }

    @Override
    public String toString(){
        StringBuilder buildString = new StringBuilder();
        buildString.append("[");
        int size = toDoList.size();
        for(int i=0; i < size; i++){
            buildString.append(toDoList.get(i).toString());
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
        ToDoList otherToDo = ((ToDoList) toDo).clone();
        int currentSize = toDoList.size();
        if( currentSize!= otherToDo.toDoSize())
            return false;

        otherToDo.sortTasks();
        this.sortTasks();

        for(int i = 0; i < currentSize; i++){
            if(!(this.getElementByIndex(i).equals(otherToDo.getElementByIndex(i))))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode(){

        return 0;
    }


    @Override
    public Iterator iterator() {
        sortTasks();
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

}
