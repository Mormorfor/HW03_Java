import java.util.Date;


public class Task implements Cloneable{

    private String description;
    private Date dueDate;


    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public String toString(){
        return "(" + description + ", " + dueDate.toString() + ")";
    }

    @Override
    public Task clone (){
        Date cloneDate = new Date(dueDate.getTime());
        String cloneDescription = new String(description);

        return new Task(cloneDescription, cloneDate);
    }

    @Override
    public boolean equals(Object otherTask){
        if(!(otherTask instanceof Task))
            return false;

        if(this.toString() == otherTask.toString())
            return true;
        else
            return false;
    }

    @Override
    public int hashCode(){
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }



}
