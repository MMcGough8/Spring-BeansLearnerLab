package rocks.zipcode.learnerlabs.models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alumni {
    
    private Students students;
    private Instructors instructors;
    
    @Autowired
    public Alumni(@Qualifier("previousStudents") Students students, Instructors instructors) {
        this.students = students;
        this.instructors = instructors;
    }
    
    @PostConstruct
    public void executeBootcamp() {
        double totalNumberOfHours = 1200;
        
        for (Instructor instructor : instructors) {
            instructor.lecture(students, totalNumberOfHours / instructors.size());
        }
    }
    
    public Students getStudents() {
        return students;
    }
    
    public Instructors getInstructors() {
        return instructors;
    }
}