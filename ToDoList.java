import java.util.*;

/**
 * This class represents a least of tasks
 */
public class ToDoList implements Cloneable, TaskIterable<Task> {
    private final static int MILLISECONDS_TO_MINUTES = 60000;
    private LinkedList<Task> toDoList;
    private Date scanningDueDate;

    /**
     * Constructor method
     */
    ToDoList(){
        toDoList = new LinkedList<>();
        scanningDueDate = null;
    }

    /**
     * This method takes care of adding a new task to a ToDoList
     * @param task a new task
     */
    public void addTask(Task task){
        String description = task.getDescription();
        for(Task oldTask : toDoList) {
            if(description.compareTo(oldTask.getDescription()) == 0) {
                throw new TaskAlreadyExistsException();
            }
        }
        toDoList.add(task);
    }

    /**
     * This method orders tasks by date and then Alphabetically
     */
    public void sortTasks(){
        Comparator<Task> taskComparator = Comparator.comparing(Task::getDueDate).thenComparing(Task::getDescription);
        Collections.sort(toDoList,taskComparator);
    }
    /**
     * Creates a string representation of the object
     * @return a string representation of the object
     */
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

    /**
     * Creates a deep clone copy of the ToDoList
     * @return cloned copy
     */
    @Override
    public ToDoList clone(){
        ToDoList newToDo = new ToDoList();
        int size = toDoList.size();
        try{
            for(int i=0; i < size; i++) {
                newToDo.addTask(toDoList.get(i).clone());
            }
            newToDo.setScanningDueDate(this.scanningDueDate);
            return newToDo;
        }catch(Exception e){
            return null;
        }
    }

    /**
     * This method checks if two ToDoLists are equals.
     * Two lists are equal if they have the same set of tasks
     * @param toDo Object to be compared with
     * @return true - if equal
     *         false - if not equal
     */
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

    /**
     * Create an integer representation of the object, same for all equal objects
     * @return integer hash code
     */
    @Override
    public int hashCode(){
        long dateSum = 0;
        for(Task task : toDoList){
            dateSum += task.getDueDate().getTime();
            dateSum %= MILLISECONDS_TO_MINUTES;
        }
        return (int) dateSum;
    }

    /**
     * creates an instance of ToDoListIterator
     * @return ToDoListIterator with current object as its parameter.
     */
    @Override
    public Iterator iterator() {
        return new ToDoListIterator(this);
    }

    /**
     * {@inheritDoc}
     * @param date border parameter
     */
    @Override
    public void setScanningDueDate(Date date) {
        this.scanningDueDate = date;
    }

    /**
     * get a scanning border parameter
     * @return border parameter date
     */
    public Date getScanningDueDate() {
        return scanningDueDate;
    }

    /**
     * Gets ToDoList size
     * @return ToDoList size
     */
    public int toDoSize(){
        return toDoList.size();
    }

    /**
     * Gets an element at a given index
     * @param i index of an element to be retrieved
     * @return an element at index i
     */
    public Task getElementByIndex(int i){
        return toDoList.get(i);
    }

    /**
     * Checks if given task is contained in ToDoList
     * @param task task to be checked
     * @return true - if contained
     *         false - if not contained
     */
    public boolean taskIsContained(Task task){
        return toDoList.contains(task);
    }

}
