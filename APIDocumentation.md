# School Management System API Documentation

## Overview

This document provides comprehensive API documentation for the School Management System, detailing all public methods, parameters, return types, and usage examples for each module.

## SchoolManagementSystem (Main Controller)

The central controller class that provides access to all system modules.

### Constructor
```java
public SchoolManagementSystem()
```
Initializes all modules: StudentRegistry, CourseScheduler, FeeTracker, LibrarySystem, and PerformanceGraph.

### Student Registry Methods

#### registerStudent
```java
public boolean registerStudent(Student student)
```
Registers a new student in the system.

**Parameters:**
- `student`: Student object containing ID, name, email, and grade

**Returns:** `boolean` - true if registration successful, false if student ID already exists

**Throws:** None

**Example:**
```java
Student student = new Student("S001", "John Doe", "john@meru.edu", 12);
boolean success = sms.registerStudent(student);
```

#### findStudent
```java
public Student findStudent(String studentId)
```
Retrieves student information by ID.

**Parameters:**
- `studentId`: String representing the student ID

**Returns:** `Student` object or null if not found

**Throws:** None

**Example:**
```java
Student student = sms.findStudent("S001");
if (student != null) {
    System.out.println("Found: " + student.getName());
}
```

#### getStudentRegistrySize
```java
public int getStudentRegistrySize()
```
Returns the total number of registered students.

**Parameters:** None

**Returns:** `int` - number of students in registry

**Throws:** None

### Course Scheduling Methods

#### registerCourse
```java
public void registerCourse(String courseId, int maxCapacity)
```
Creates a new course with specified capacity.

**Parameters:**
- `courseId`: String identifier for the course
- `maxCapacity`: int maximum number of students that can enroll

**Returns:** void

**Throws:** None

**Example:**
```java
sms.registerCourse("CS101", 30);
```

#### enrollInCourse
```java
public boolean enrollInCourse(String courseId, String studentId)
```
Adds a student to the enrollment queue for a course.

**Parameters:**
- `courseId`: String course identifier
- `studentId`: String student identifier

**Returns:** `boolean` - true if queued successfully, false if queue is full

**Throws:** None

**Example:**
```java
boolean queued = sms.enrollInCourse("CS101", "S001");
```

#### processEnrollment
```java
public List<String> processEnrollment(String courseId)
```
Processes the enrollment queue and enrolls students up to course capacity.

**Parameters:**
- `courseId`: String course identifier

**Returns:** `List<String>` - list of student IDs that were successfully enrolled

**Throws:** None

**Example:**
```java
List<String> enrolledStudents = sms.processEnrollment("CS101");
System.out.println("Enrolled: " + enrolledStudents.size() + " students");
```

### Fee Tracking Methods

#### addFeeRecord
```java
public void addFeeRecord(String studentId, double amount, Date date, String type)
```
Adds a financial transaction record to the system.

**Parameters:**
- `studentId`: String student identifier
- `amount`: double transaction amount
- `date`: Date transaction date
- `type`: String transaction type (e.g., "Tuition", "Library Fine")

**Returns:** void

**Throws:** None

**Example:**
```java
import java.util.Date;
Date today = new Date();
sms.addFeeRecord("S001", 500.00, today, "Tuition Fee");
```

### Library System Methods

#### addBook
```java
public void addBook(Book book)
```
Adds a book to the library catalog.

**Parameters:**
- `book`: Book object containing ISBN, title, and author

**Returns:** void

**Throws:** None

**Example:**
```java
Book book = new Book("1234567890", "Data Structures", "Author A");
sms.addBook(book);
```

#### borrowBook
```java
public boolean borrowBook(String isbn, String studentId)
```
Attempts to borrow a book for a student.

**Parameters:**
- `isbn`: String book ISBN
- `studentId`: String student identifier

**Returns:** `boolean` - true if borrow successful, false if book unavailable

**Throws:** None

**Example:**
```java
boolean success = sms.borrowBook("1234567890", "S001");
if (success) {
    System.out.println("Book borrowed successfully");
}
```

### Performance Analytics Methods

#### addGrade
```java
public void addGrade(String studentId, String subject, double grade)
```
Records a grade for a student in a specific subject.

**Parameters:**
- `studentId`: String student identifier
- `subject`: String subject name
- `grade`: double grade value (typically 0-100)

**Returns:** void

**Throws:** None

**Example:**
```java
sms.addGrade("S001", "Mathematics", 95.0);
sms.addGrade("S001", "Science", 90.0);
```

#### getTopPerformers
```java
public List<StudentPerformance> getTopPerformers(int count)
```
Retrieves the top-performing students based on average grades.

**Parameters:**
- `count`: int number of top performers to return

**Returns:** `List<StudentPerformance>` - list of top performers with student IDs and average grades

**Throws:** None

**Example:**
```java
List<StudentPerformance> topStudents = sms.getTopPerformers(5);
for (StudentPerformance student : topStudents) {
    System.out.println(student.studentId + ": " + student.averageGrade);
}
```

## Data Classes

### Student
Represents a student in the system.

**Fields:**
- `studentId`: String - unique identifier
- `name`: String - full name
- `email`: String - email address
- `grade`: int - academic year/grade level
- `courses`: List<String> - enrolled courses

**Constructors:**
```java
public Student(String studentId, String name, String email, int grade)
```

**Methods:**
```java
public String getStudentId()
public String getName()
public String getEmail()
public int getGrade()
public List<String> getCourses()
public void addCourse(String courseId)
```

### Book
Represents a book in the library system.

**Fields:**
- `isbn`: String - unique ISBN
- `title`: String - book title
- `author`: String - book author
- `available`: boolean - availability status

**Constructors:**
```java
public Book(String isbn, String title, String author)
```

**Methods:**
```java
public String getIsbn()
public String getTitle()
public String getAuthor()
public boolean isAvailable()
public void setAvailable(boolean available)
```

### FeeRecord
Represents a financial transaction.

**Fields:**
- `studentId`: String - student identifier
- `amount`: double - transaction amount
- `transactionDate`: Date - transaction date
- `type`: String - transaction type

**Constructors:**
```java
public FeeRecord(String studentId, double amount, Date date, String type)
```

**Methods:**
```java
public String getStudentId()
public double getAmount()
public Date getTransactionDate()
public String getType()
```

### StudentPerformance
Represents a student's performance summary.

**Fields:**
- `studentId`: String - student identifier
- `averageGrade`: double - calculated average grade

**Constructors:**
```java
public StudentPerformance(String studentId, double averageGrade)
```

**Methods:**
```java
public String getStudentId()
public double getAverageGrade()
```

### Transaction
Represents a library transaction (borrow/return).

**Fields:**
- `studentId`: String - student identifier
- `isbn`: String - book ISBN
- `type`: String - transaction type ("BORROW" or "RETURN")
- `timestamp`: Date - transaction timestamp

**Constructors:**
```java
public Transaction(String studentId, String isbn, String type)
```

**Methods:**
```java
public String getStudentId()
public String getIsbn()
public String getType()
public Date getTimestamp()
```

## Error Handling

The API methods generally do not throw exceptions but return boolean values or null to indicate failure:

- **registerStudent()**: Returns false for duplicate student IDs
- **findStudent()**: Returns null for non-existent students
- **enrollInCourse()**: Returns false when course queue is full
- **borrowBook()**: Returns false when book is unavailable

## Thread Safety

The current implementation is not thread-safe. For concurrent access, external synchronization would be required.

## Performance Characteristics

| Method Category | Time Complexity | Notes |
|----------------|-----------------|-------|
| Student Operations | O(1) average | Hash table lookup |
| Course Enrollment | O(1) | Queue operations |
| Fee Recording | O(log n) | AVL tree insertion |
| Library Operations | O(1) | HashMap access |
| Performance Queries | O(k log n) | PriorityQueue extraction |

## Usage Patterns

### Complete Student Lifecycle
```java
// 1. Register student
Student student = new Student("S001", "John Doe", "john@meru.edu", 12);
sms.registerStudent(student);

// 2. Enroll in courses
sms.registerCourse("CS101", 30);
sms.enrollInCourse("CS101", "S001");
List<String> enrolled = sms.processEnrollment("CS101");

// 3. Record fees
sms.addFeeRecord("S001", 500.00, new Date(), "Tuition");

// 4. Borrow books
Book book = new Book("1234567890", "Data Structures", "Author A");
sms.addBook(book);
sms.borrowBook("1234567890", "S001");

// 5. Record grades
sms.addGrade("S001", "Math", 95.0);
sms.addGrade("S001", "Science", 90.0);

// 6. Check performance
List<StudentPerformance> topPerformers = sms.getTopPerformers(10);
```

## Version History

- **v1.0**: Initial implementation with all core modules
- Basic CRUD operations for all entities
- Demonstration program included
- Comprehensive documentation provided
