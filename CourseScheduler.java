import java.util.*;

class CircularQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int count;
    private int capacity;
    
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
    
    public boolean enqueue(String studentId) {
        if (isFull()) {
            return false;
        }
        
        rear = (rear + 1) % capacity;
        queue[rear] = studentId;
        count++;
        return true;
    }
    
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        String studentId = queue[front];
        front = (front + 1) % capacity;
        count--;
        return studentId;
    }
    
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }
    
    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class CourseScheduler {
    private Map<String, CircularQueue> courseQueues;

    public CourseScheduler() {
        this.courseQueues = new HashMap<>();
    }
    
    public void registerCourse(String courseId, int maxCapacity) {
        courseQueues.put(courseId, new CircularQueue(maxCapacity));
    }
    
    public boolean enrollStudent(String courseId, String studentId) {
        CircularQueue queue = courseQueues.get(courseId);
        if (queue == null) {
            return false;
        }
        return queue.enqueue(studentId);
    }
    
    public List<String> processEnrollment(String courseId, StudentRegistry registry) {
        CircularQueue queue = courseQueues.get(courseId);
        if (queue == null) {
            return Collections.emptyList();
        }

        List<String> enrolledStudents = new ArrayList<>();

        while (!queue.isEmpty() && enrolledStudents.size() < queue.getCapacity()) {
            String studentId = queue.dequeue();
            Student student = registry.getStudent(studentId);
            if (student != null) {
                student.addCourse(courseId);
                enrolledStudents.add(studentId);
            }
        }

        return enrolledStudents;
    }
}