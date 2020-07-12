
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {

    private List<Person> employees;

    public Employees() {
        employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        employees.addAll(peopleToAdd);
    }
    
    public void print() {
//        employees.forEach(p -> System.out.println(p));
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    
    public void print(Education education) {
//        employees.stream()
//                .filter(p -> p.getEducation() == education)
//                .forEach(p -> System.out.println(p));
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()) {
            Person p = iter.next();
            if (p.getEducation() == education) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()) {
            Person p = iter.next();
            if (p.getEducation() == education) {
                iter.remove();
            }
        }
    }    
    
}
