package rocks.zipcode.learnerlabs.models;

public class Student extends Person implements Learner {
    
    private double totalStudyTime;
    
    public Student(Long id, String name) {
        super(id, name);
        this.totalStudyTime = 0;
    }
    
    @Override
    public void learn(double numberOfHours) {
        this.totalStudyTime += numberOfHours;
    }
    
    public double getTotalStudyTime() {
        return totalStudyTime;
    }
}