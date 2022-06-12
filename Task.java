import java.util.Calendar;
import java.util.Date;

/**
 * This class represents a specific task with description and due date
 */
public class Task implements Cloneable{

    private String description;
    private Date dueDate;

    /**
     * This method sets task's dueDate
     * @param dueDate new dueDate
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Constructor method
     * @param description string task's description
     * @param dueDate task's dueDate
     */
    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    /**
     * Creates the string representation of the task
     * @return the string representation of the task
     */
    @Override
    public String toString(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dueDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String formattedMonth = String.format("%02d", month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String formattedDay = String.format("%02d", day);
        return  description + ", " + formattedDay + "." + formattedMonth + "." + year;
    }

    /**
     * Create a deep copy of the task object
     * @return cloned object
     */
    @Override
    public Task clone (){
        Date cloneDate = new Date(dueDate.getTime());
        String cloneDescription = new String(description);

        return new Task(cloneDescription, cloneDate);
    }

    /**
     * Check if task object equals a given object
     * @param otherTask the Task object to be compared with
     * @return true - if objects are equal
     *         false - if objects are not equal
     */
    @Override
    public boolean equals(Object otherTask){
        if(!(otherTask instanceof Task))
            return false;

        if(this.toString().equals(otherTask.toString()))
            return true;
        else
            return false;
    }

    /**
     * Create an integer representation of the object, same for all equal objects
     * @return integer hash code
     */
    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    /**
     * Get tasks description String
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get tasks Date due date
     * @return Date dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

}
