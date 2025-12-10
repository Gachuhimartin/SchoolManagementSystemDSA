import java.util.*;

class Student {
    private String studentId;
    private String name;
    private String email;
    private int gradeLevel;
    private List<String> courses;
    
    public Student(String studentId, String name, String email, int gradeLevel) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.gradeLevel = gradeLevel;
        this.courses = new ArrayList<>();
    }
    
    // Getters and setters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getGradeLevel() { return gradeLevel; }
    public List<String> getCourses() { return courses; }
    
    public void addCourse(String courseId) {
        courses.add(courseId);
    }
    
    @Override
    public String toString() {
        return String.format("Student{ID: %s, Name: %s, Grade: %d}", 
                           studentId, name, gradeLevel);
    }
}

public class StudentRegistry {
    private static final int DEFAULT_CAPACITY = 1000;
    private LinkedList<Student>[] table;
    private int size;
    
    @SuppressWarnings("unchecked")
    public StudentRegistry(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }
    
    public StudentRegistry() {
        this(DEFAULT_CAPACITY);
    }
    
    private int hash(String studentId) {
        return Math.abs(studentId.hashCode()) % table.length;
    }
    
    public boolean addStudent(Student student) {
        int index = hash(student.getStudentId());
        LinkedList<Student> bucket = table[index];
        
        // Check if student already exists
        for (Student s : bucket) {
            if (s.getStudentId().equals(student.getStudentId())) {
                return false; // Student already exists
            }
        }
        
        bucket.add(student);
        size++;
        return true;
    }
    
    public Student getStudent(String studentId) {
        int index = hash(studentId);
        LinkedList<Student> bucket = table[index];
        
        for (Student student : bucket) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    public boolean removeStudent(String studentId) {
        int index = hash(studentId);
        LinkedList<Student> bucket = table[index];
        
        Iterator<Student> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equals(studentId)) {
                iterator.remove();
                size--;
                return true;
            }
        }
        return false;
    }
    
    public int getSize() {
        return size;
    }
}