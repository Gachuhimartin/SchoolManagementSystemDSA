import java.util.*;

/**
 * Performance Analytics Module
 * Data Structures Used:
 * - HashMap: For storing student grades per subject (efficient lookup O(1))
 * - PriorityQueue (Max Heap): For identifying top performers based on average grades (O(log n) insertions, O(1) peek)
 * Justification: HashMap allows fast access to student-subject grades. PriorityQueue efficiently maintains top performers without sorting entire list.
 * Time Complexity: Add grade O(1), Get top performers O(k log n) for k performers.
 * Space Complexity: O(n*m) where n=students, m=subjects.
 */
public class PerformanceGraph {
    private Map<String, Map<String, Double>> studentGrades; // studentId -> subject -> grade
    private PriorityQueue<StudentPerformance> topPerformers;

    public PerformanceGraph() {
        this.studentGrades = new HashMap<>();
        this.topPerformers = new PriorityQueue<>();
    }

    public void addStudent(String studentId) {
        studentGrades.put(studentId, new HashMap<>());
    }

    public void addGrade(String studentId, String subject, double grade) {
        if (!studentGrades.containsKey(studentId)) {
            addStudent(studentId);
        }
        studentGrades.get(studentId).put(subject, grade);
        updateTopPerformers();
    }

    private void updateTopPerformers() {
        topPerformers.clear();
        for (String studentId : studentGrades.keySet()) {
            double avg = calculateAverage(studentId);
            topPerformers.add(new StudentPerformance(studentId, avg));
        }
    }

    private double calculateAverage(String studentId) {
        Map<String, Double> grades = studentGrades.get(studentId);
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public List<StudentPerformance> getTopPerformers(int count) {
        List<StudentPerformance> top = new ArrayList<>();
        PriorityQueue<StudentPerformance> temp = new PriorityQueue<>(topPerformers);
        for (int i = 0; i < count && !temp.isEmpty(); i++) {
            top.add(temp.poll());
        }
        return top;
    }

    public double getStudentAverage(String studentId) {
        return calculateAverage(studentId);
    }
}
