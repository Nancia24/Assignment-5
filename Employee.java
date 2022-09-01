//import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

// nancia
//
//
//
//
//

public class Employee{
    private String name;
    private String uid;
    private CalendarTime startTime;
    private ArrayList<Shift> shifts = new ArrayList();
    // Create an Employee representing the employee with given name and UID.
    public Employee(String name, String uid){
        this.name =name;
        this.uid = uid;
    }

    // Obtain this employee's name.
    public String name(){
      return name;  
    }

    // Obtain this Employee's ID.
    public String UID(){
        return uid;
    }

    // Record that this employee has begun a shift on the given date and at the given time.
    public void signIn(Date d, Time t){
        startTime = new CalendarTime(d, t); 
    }

    // Record that this employee has completed a shift on the given date and at the given time.
    public void signOut(Date d, Time t){
        CalendarTime finishTime = new CalendarTime(d, t);
        Shift newShift = new Shift(startTime, finishTime);
        shifts.add(newShift);
    }

    // Determine whether this employee is present i.e. has signed-in and not yet signed-out.
    public boolean present(){
        boolean value = true;
        if (shifts.size()==0 && startTime== null){
            value = false;
            }
            
        if (shifts.size()!=0){
        for (int i = 0;i< shifts.size();i++){
            if (shifts.get(i).start().compareTo(startTime) == 0){
                value = false;
                break;
            }
        }
       }
        return value;
    }

    // Determine whether this employee worked a shift that at least partly occurred on the given date.
    public boolean worked(Date d){
        boolean value = false;
        for (int i =0; i<shifts.size();i++){
            if (shifts.get(i).includesDate(d)){
                value = true;
                break;
            }
        }
        return value;
    }

    // Determine whether this employee worked at least one shift during the given week.
    public boolean worked(Week w){
        boolean value = false;
        for (int i =0; i<shifts.size();i++){
            if (shifts.get(i).inWeek(w)){
                value = true;
                break;
            }
        }
        return value;
    }

    // Obtain the shift(s) worked by this employee that at least partly occur on the given date.
    public List<Shift> get(Date d){
        ArrayList<Shift> worked = new ArrayList<>();
        for (int i = 0;i< shifts.size();i++){
            if (shifts.get(i).includesDate(d)){
                worked.add(shifts.get(i));
            }
        }
        return worked;
    }

    // Obtain a list of the shifts worked by this employee during the given week.
    public List<Shift> get(Week w){
        ArrayList<Shift> worked = new ArrayList<>();
        for (int i = 0;i< shifts.size();i++){
            if (shifts.get(i).inWeek(w)){
                worked.add(shifts.get(i));
            }
        }
        return worked;
    }

    // Returns the total time (hours and minutes) worked during the given week
    public Duration hours(Week w){
        ArrayList<Shift> worked = new ArrayList<>();
        for (int i = 0;i< shifts.size();i++){
            if (shifts.get(i).inWeek(w)){
                worked.add(shifts.get(i));
            }
        }   
         Duration s  = new Duration(0);
        for (int n = 0;n< worked.size();n++){       
            s = s.add(worked.get(n).length());           
        }
        return s;
    }
}
