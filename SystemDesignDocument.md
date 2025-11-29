# School Management System Design Document

## Architecture Overview

The School Management System is designed as a modular Java application that manages student data, course scheduling, fee tracking, library resources, and performance analytics for Meru University. The system uses a central controller (SchoolManagementSystem class) that orchestrates interactions between five specialized modules:

- **Student Registry**: Manages student information and provides quick lookup capabilities
- **Course Scheduler**: Handles course registration and student enrollment based on FIFO order
- **Fee Tracker**: Maintains sorted financial records for fee management and reporting
- **Library System**: Tracks book inventory and borrowing transactions
- **Performance Analytics**: Analyzes student grades and identifies top performers

Each module operates independently but shares data through the central controller, ensuring data consistency and modular maintainability.

## Data Structure Justification

### 1. Student Registry - Hash Table with LinkedList
**Choice**: Hash Table (HashMap with LinkedList for collision resolution)
**Justification**: Provides O(1) average-case lookup time for student IDs, which is critical for frequent student searches in a university system. The LinkedList handles hash collisions efficiently.
**Operations**:
- Add student: O(1) average
- Find student: O(1) average
- Remove student: O(1) average

### 2. Course Scheduling - Queue (Circular Array) + HashMap
**Choice**: CircularQueue for enrollment order + HashMap for course management
**Justification**: FIFO queue ensures fair enrollment based on registration order. Circular array implementation provides efficient memory usage and O(1) enqueue/dequeue operations.
**Operations**:
- Enroll student: O(1)
- Process enrollment: O(capacity)

### 3. Fee Tracking - AVL Tree (Self-balancing BST)
**Choice**: AVL Tree for maintaining sorted fee records
**Justification**: Provides O(log n) insertion and range queries for date-sorted financial data. Self-balancing ensures consistent performance for fee clearance reports and transaction history.
**Operations**:
- Add fee record: O(log n)
- Range queries: O(log n + k) where k is result size

### 4. Library System - Stack + HashMap
**Choice**: Stack for transaction history + HashMap for book catalog
**Justification**: Stack maintains chronological order of borrow/return operations for audit trails. HashMap enables O(1) book lookups by ISBN.
**Operations**:
- Borrow/return book: O(1)
- Get recent transactions: O(count)

### 5. Performance Analytics - HashMap + PriorityQueue (Max Heap)
**Choice**: HashMap for grade storage + PriorityQueue for top performer identification
**Justification**: HashMap provides O(1) access to student-subject grades. PriorityQueue efficiently maintains top k performers without full sorting.
**Operations**:
- Add grade: O(1)
- Get top performers: O(k log n)

## Flow Diagrams

### Student Registration Flow
```
User Request → SchoolManagementSystem.registerStudent()
    ↓
StudentRegistry.addStudent() [Hash Table]
    ↓
PerformanceGraph.addStudent() [HashMap]
    ↓
Success/Failure Response
```

### Course Enrollment Flow
```
Student Registration → CourseScheduler.enrollStudent() [Queue]
    ↓
CourseScheduler.processEnrollment() [Dequeue & Student Update]
    ↓
Student.courses.add(courseId)
```

### Fee Payment Flow
```
Fee Transaction → FeeTracker.addFeeRecord() [AVL Tree Insertion]
    ↓
Sorted Storage by Date
    ↓
Range Queries for Reports
```

## Ethical Considerations

1. **Data Privacy**: Student personal information is stored securely with no external sharing
2. **Fair Access**: Queue-based enrollment prevents favoritism
3. **Financial Transparency**: Complete audit trail of fee transactions
4. **Academic Integrity**: Performance data used only for analytics, not manipulation
5. **Resource Equity**: Library system ensures fair book access through availability tracking
