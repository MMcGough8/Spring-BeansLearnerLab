package rocks.zipcode.learnerlabs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import rocks.zipcode.learnerlabs.models.Students;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentConfigTest {
    
    @Autowired
    @Qualifier("students")
    private Students currentStudents;
    
    @Autowired
    @Qualifier("previousStudents")
    private Students previousStudents;
    
    @Test
    public void testCurrentStudentsExists() {
        assertNotNull(currentStudents);
    }
    
    @Test
    public void testCurrentStudentsSize() {
        assertEquals(4, currentStudents.size());
    }
    
    @Test
    public void testPreviousStudentsExists() {
        assertNotNull(previousStudents);
    }
    
    @Test
    public void testPreviousStudentsSize() {
        assertEquals(3, previousStudents.size());
    }
    
    @Test
    public void testFindStudentById() {
        assertNotNull(currentStudents.findById(1L));
        assertEquals("Marc", currentStudents.findById(1L).getName());
    }
}