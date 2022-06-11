import java.util.Calendar;
import java.util.Date;


public class Task implements Cloneable{

    private String description;
    private Date dueDate;

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public String toString(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dueDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String formattedMonth = String.format("%02d", month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String formattedDay = String.format("%02d", day);

        //calendar.getDisplayName();

        return  description + ", " + formattedDay + "." + formattedMonth + "." + year;
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

        if(this.toString().equals(otherTask.toString()))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

}
