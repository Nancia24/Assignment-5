//import java.time.Duration;

public class Shift {
    private CalendarTime start;
    private CalendarTime finish;
    
    
    // Create a Shift object representing a shift worked between the given date times.
    public Shift(CalendarTime start, CalendarTime finish){
        this.start =start;
        this.finish = finish;
    }

    // Obtain the start date and time for this shift.        
    public CalendarTime start(){
       return start; 
    }
    // Obtain the end date and time for this shift.
    public CalendarTime finish(){
        return finish;
    }
    // Determine whether this shift occurred within the given week.
    public boolean inWeek(Week w){
       boolean value = w.includes(start.date()) || w.includes(finish.date());
       return value;
 
    }
    // Determine whether this shift at least partly occurred on the given date.
    public boolean includesDate(Date date){
        boolean value = false;
        if (start.date().compareTo(date)<=0 && date.compareTo(finish.date())<=0)
         value= true;  
       return value;
    }
    // Obtain the length of this shift.
    public Duration length(){
        Duration duration = finish.subtract(start);
        return duration;   
    }
    // Obtain a string representation of this shift of the form "<date>%:<time>- <date>%:<time>".
    public String toString(){
        String output = String.format("%s - %s", start.toString(),finish.toString());
        return output;
    }
    
}