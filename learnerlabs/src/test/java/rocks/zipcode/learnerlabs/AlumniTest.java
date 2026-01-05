package rocks.zipcode.learnerlabs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rocks.zipcode.learnerlabs.models.Alumni;
import rocks.zipcode.learnerlabs.models.Student;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlumniTest {
    
    @Autowired
    private Alumni alumni;
    
    @Test
    public void testAlumniExists() {
        assertNotNull(alumni);
    }
    
    @Test
    public void testStudentsHaveBeenTaught() {
        // Each student should have 1200 hours of study time
        for (Student student : alumni.getStudents()) {
            assertEquals(1200.0, student.getTotalStudyTime());
        }
    }
    
    @Test
    public void testHoursDistributedCorrectly() {
        // Calculate expected values
        int numberOfInstructors = alumni.getInstructors().size();
        int numberOfStudents = alumni.getStudents().size();
        double numberOfHoursToTeachEachStudent = 1200;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
        
        // Verify each student received 1200 hours total
        for (Student student : alumni.getStudents()) {
            assertEquals(numberOfHoursToTeachEachStudent, student.getTotalStudyTime());
        }
    }
    
    @Test
    public void testAlumniHasPreviousStudents() {
        assertEquals(3, alumni.getStudents().size());
    }
    
    @Test
    public void testAlumniHasAllInstructors() {
        assertEquals(4, alumni.getInstructors().size());
    }
}