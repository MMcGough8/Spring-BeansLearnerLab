package rocks.zipcode.learnerlabs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import rocks.zipcode.learnerlabs.models.Instructors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InstructorConfigTest {
    
    @Autowired
    @Qualifier("tcUsaInstructors")
    private Instructors usaInstructors;
    
    @Autowired
    @Qualifier("tcUkInstructors")
    private Instructors ukInstructors;
    
    @Autowired
    private Instructors instructors;
    
    @Test
    public void testUsaInstructorsExists() {
        assertNotNull(usaInstructors);
    }
    
    @Test
    public void testUsaInstructorsSize() {
        assertEquals(2, usaInstructors.size());
    }
    
    @Test
    public void testUkInstructorsExists() {
        assertNotNull(ukInstructors);
    }
    
    @Test
    public void testUkInstructorsSize() {
        assertEquals(2, ukInstructors.size());
    }
    
    @Test
    public void testAllInstructorsExists() {
        assertNotNull(instructors);
    }
    
    @Test
    public void testAllInstructorsSize() {
        assertEquals(4, instructors.size());
    }
    
    @Test
    public void testPrimaryInstructorsIsInjectedWithoutQualifier() {
        // This works because @Primary is on the instructors() bean
        assertEquals(4, instructors.size());
    }
}