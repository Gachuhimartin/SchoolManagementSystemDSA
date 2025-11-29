import java.util.*;

/**
 * Represents a student's performance with average grade for ranking.
 */
public class StudentPerformance implements Comparable<StudentPerformance> {
    String studentId;
    double averageGrade;

    public StudentPerformance(String studentId, double averageGrade) {
        this.studentId = studentId;
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(StudentPerformance other) {
        return Double.compare(other.averageGrade, this.averageGrade); // Max heap
    }
}
