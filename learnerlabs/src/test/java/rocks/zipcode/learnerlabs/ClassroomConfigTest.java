package rocks.zipcode.learnerlabs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import rocks.zipcode.learnerlabs.models.Classroom;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClassroomConfigTest {
    
    @Autowired
    @Qualifier("currentCohort")
    private Classroom currentCohort;
    
    @Autowired
    @Qualifier("previousCohort")
    private Classroom previousCohort;
    
    @Test
    public void testCurrentCohortExists() {
        assertNotNull(currentCohort);
    }
    
    @Test
    public void testCurrentCohortHasInstructors() {
        assertNotNull(currentCohort.getInstructors());
        assertEquals(4, currentCohort.getInstructors().size());
    }
    
    @Test
    public void testCurrentCohortHasStudents() {
        assertNotNull(currentCohort.getStudents());
        assertEquals(4, currentCohort.getStudents().size());
    }
    
    @Test
    public void testPreviousCohortExists() {
        assertNotNull(previousCohort);
    }
    
    @Test
    public void testPreviousCohortHasInstructors() {
        assertNotNull(previousCohort.getInstructors());
        assertEquals(4, previousCohort.getInstructors().size());
    }
    
    @Test
    public void testPreviousCohortHasPreviousStudents() {
        assertNotNull(previousCohort.getStudents());
        assertEquals(3, previousCohort.getStudents().size());
    }
    
    @Test
    public void testHostLecture() {
        // Get a student before lecture
        var student = currentCohort.getStudents().findById(1L);
        double initialStudyTime = student.getTotalStudyTime();
        
        // Host a lecture
        var instructor = currentCohort.getInstructors().findById(100L);
        currentCohort.hostLecture(instructor, 8.0);
        
        // Each student should have learned 2 hours (8 hours / 4 students)
        assertEquals(initialStudyTime + 2.0, student.getTotalStudyTime());
    }
}