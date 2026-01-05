package rocks.zipcode.learnerlabs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import rocks.zipcode.learnerlabs.models.Instructor;
import rocks.zipcode.learnerlabs.models.Instructors;

@Configuration
public class InstructorsConfig {
    
    @Bean
    public Instructors tcUsaInstructors() {
        return new Instructors(
            new Instructor(100L, "Kris"),
            new Instructor(101L, "Paul")
        );
    }
    
    @Bean
    public Instructors tcUkInstructors() {
        return new Instructors(
            new Instructor(200L, "Raz"),
            new Instructor(201L, "Dan")
        );
    }
    
    @Bean
    @Primary
    public Instructors instructors() {
        Instructors allInstructors = new Instructors();
        allInstructors.addAll(tcUsaInstructors());
        allInstructors.addAll(tcUkInstructors());
        return allInstructors;
    }
}