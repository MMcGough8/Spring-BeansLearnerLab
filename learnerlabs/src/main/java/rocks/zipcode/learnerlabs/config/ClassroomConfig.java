package rocks.zipcode.learnerlabs.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import rocks.zipcode.learnerlabs.models.Classroom;
import rocks.zipcode.learnerlabs.models.Instructors;
import rocks.zipcode.learnerlabs.models.Students;

@Configuration
public class ClassroomConfig {
    
    @Bean
    @DependsOn({"instructors", "students"})
    public Classroom currentCohort(Instructors instructors, @Qualifier("students") Students students) {
        return new Classroom(instructors, students);
    }
    
    @Bean
    @DependsOn({"instructors", "previousStudents"})
    public Classroom previousCohort(Instructors instructors, @Qualifier("previousStudents") Students previousStudents) {
        return new Classroom(instructors, previousStudents);
    }
}