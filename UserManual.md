# School Management System User Manual

## Introduction

Welcome to the School Management System (SMS) for Meru University. This manual provides detailed instructions for using the system to manage student data, course scheduling, fee tracking, library resources, and performance analytics.

## System Overview

The SMS consists of five integrated modules:

1. **Student Registry**: Manages student information and enrollment
2. **Course Scheduler**: Handles course registration and student enrollment
3. **Fee Tracker**: Maintains financial records and transactions
4. **Library System**: Manages book inventory and borrowing
5. **Performance Analytics**: Tracks student grades and academic performance

## Getting Started

### Prerequisites
- Java Runtime Environment (JRE) 8 or higher
- Compiled Java class files

### Running the System
1. Open a terminal/command prompt
2. Navigate to the project directory
3. Execute: `java SchoolManagementSystem`

The system will run a comprehensive demonstration showing all modules in action.

## Module Details

### 1. Student Registry

#### Purpose
Manages student information including personal details and academic year.

#### Key Operations
- **Register Student**: Add new students to the system
- **Find Student**: Look up student information by ID
- **Remove Student**: Delete student records (if implemented)

#### Usage Example
```java
SchoolManagementSystem sms = new SchoolManagementSystem();

// Register a new student
Student student = new Student("S001", "John Doe", "john@meru.edu", 12);
boolean success = sms.registerStudent(student);

// Find a student
Student found = sms.findStudent("S001");
```

#### Data Structure
- Hash Table with LinkedList collision resolution
- O(1) average lookup time

### 2. Course Scheduling

#### Purpose
Manages course registration and student enrollment on a first-come, first-served basis.

#### Key Operations
- **Register Course**: Create a new course with capacity limit
- **Enroll Student**: Add student to course waiting list
- **Process Enrollment**: Finalize enrollment up to course capacity

#### Usage Example
```java
// Register a course
sms.registerCourse("CS101", 30);

// Enroll students
sms.enrollInCourse("CS101", "S001");
sms.enrollInCourse("CS101", "S002");

// Process enrollment (determines who gets in)
List<String> enrolled = sms.processEnrollment("CS101");
```

#### Data Structure
- Circular Queue for FIFO enrollment
- HashMap for course management
- O(1) enrollment operations

### 3. Fee Tracking

#### Purpose
Maintains financial records for tuition, fees, and other charges.

#### Key Operations
- **Add Fee Record**: Record financial transactions
- **Range Queries**: Search fees within date ranges (implementation may vary)

#### Usage Example
```java
import java.util.Date;

// Add a fee record
Date today = new Date();
sms.addFeeRecord("S001", 500.00, today, "Tuition Fee");
```

#### Data Structure
- AVL Tree (self-balancing binary search tree)
- Maintains records sorted by date
- O(log n) insertion and range queries

### 4. Library System

#### Purpose
Manages book inventory and borrowing transactions.

#### Key Operations
- **Add Book**: Add books to the catalog
- **Borrow Book**: Check out books to students
- **Return Book**: Return borrowed books
- **View Transaction History**: Review recent borrowing activity

#### Usage Example
```java
// Add a book
Book book = new Book("1234567890", "Data Structures", "Author A");
sms.addBook(book);

// Borrow a book
boolean success = sms.borrowBook("1234567890", "S001");
```

#### Data Structure
- HashMap for book catalog (O(1) lookup)
- Stack for transaction history (LIFO access to recent transactions)

### 5. Performance Analytics

#### Purpose
Tracks student grades and identifies top performers.

#### Key Operations
- **Add Grade**: Record student grades by subject
- **Get Top Performers**: Retrieve highest-achieving students

#### Usage Example
```java
// Add grades
sms.addGrade("S001", "Mathematics", 95.0);
sms.addGrade("S001", "Science", 90.0);

// Get top performers
List<StudentPerformance> topStudents = sms.getTopPerformers(5);
```

#### Data Structure
- HashMap for grade storage
- PriorityQueue (Max Heap) for efficient top-k retrieval
- O(k log n) for extracting top k performers

## Demonstration Program

The system includes a built-in demonstration that showcases all modules:

### What the Demo Shows
1. **Student Registration**: Registers 10 sample students
2. **Course Management**: Creates courses and processes enrollments
3. **Fee Recording**: Adds various fee types and amounts
4. **Library Operations**: Manages book catalog and borrowing
5. **Performance Tracking**: Records grades and shows top performers

### Running the Demo
```bash
java SchoolManagementSystem
```

### Sample Demo Output
```
=== SCHOOL MANAGEMENT SYSTEM DEMONSTRATION ===

1. STUDENT REGISTRY MODULE (Hash Table Implementation)
   - Registering student S001 (John Doe): SUCCESS
   - Total students registered: 10

2. COURSE SCHEDULING MODULE (Circular Queue + HashMap)
   - Registered courses: CS101 (capacity 5), MATH201 (capacity 3)
   - Enrolling S001 in CS101: QUEUED

3. FEE TRACKING MODULE (AVL Tree - Self-balancing BST)
   - Added Tuition fee record for S001: $500.0

4. LIBRARY SYSTEM MODULE (Stack + HashMap)
   - Added book to catalog: 'Data Structures' by Author A
   - S001 borrowing book ISBN 1234567890: SUCCESS

5. PERFORMANCE ANALYTICS MODULE (HashMap + Max Heap PriorityQueue)
   - Added grade for S001 in Math: 95.0
   - Top 3 performers:
     1. S005 with average grade 94.00
```

## Troubleshooting

### Common Issues

#### Compilation Errors
- Ensure all Java files are in the same directory
- Check that JDK is properly installed
- Verify file names match class names

#### Runtime Errors
- Confirm all dependent classes are compiled
- Check for null pointer exceptions in data access
- Verify data consistency across modules

#### Performance Issues
- Large datasets may cause memory issues
- Hash table collisions can degrade performance
- AVL tree balancing ensures consistent operation

### Error Messages
- **"Student already exists"**: Attempted duplicate registration
- **"Queue full"**: Course enrollment capacity exceeded
- **"Book unavailable"**: Attempted to borrow already checked-out book

## Best Practices

1. **Data Consistency**: Always use the main controller methods rather than accessing modules directly
2. **Capacity Planning**: Set realistic course capacities to prevent overflow
3. **Regular Backups**: Implement data persistence for production use
4. **Performance Monitoring**: Track operation times for large datasets
5. **Input Validation**: Validate all user inputs before processing

## Advanced Usage

### Customizing the Demo
Modify the `main` method in `SchoolManagementSystem.java` to:
- Change sample data
- Add more operations
- Test edge cases
- Demonstrate specific scenarios

### Extending the System
The modular design allows for easy extension:
- Add new modules following the existing pattern
- Implement additional data structures
- Add persistence layer (database/file storage)
- Create user interfaces (GUI/web)

## Support

This system is designed for educational purposes demonstrating data structure implementations. For technical questions or enhancement requests, refer to the system documentation files:

- [System Explanation](SystemExplanation.md)
- [Design Document](SystemDesignDocument.md)
- [Performance Report](PerformanceReport.md)

## Version Information

- **Current Version**: 1.0 (Educational Implementation)
- **Java Version**: JDK 8+
- **Data Structures**: Hash Table, Queue, AVL Tree, Stack, PriorityQueue
- **Architecture**: Modular controller pattern
