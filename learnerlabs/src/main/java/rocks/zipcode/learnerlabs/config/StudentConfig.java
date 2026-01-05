package rocks.zipcode.learnerlabs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rocks.zipcode.learnerlabs.models.Student;
import rocks.zipcode.learnerlabs.models.Students;

@Configuration
public class StudentConfig {
    
    @Bean(name = "students")
    public Students currentStudents() {
        return new Students(
            new Student(1L, "Marc"),
            new Student(2L, "Ben"),
            new Student(3L, "Cole"),
            new Student(4L, "Devesh")
        );
    }
    
    @Bean
    public Students previousStudents() {
        return new Students(
            new Student(5L, "Stephen"),
            new Student(6L, "Toni"),
            new Student(7L, "Frank")
        );
    }
}