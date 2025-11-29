# School Management System (DSA Implementation)

A comprehensive Java-based school management system that demonstrates the practical application of fundamental data structures and algorithms. This system manages student records, course scheduling, fee tracking, library resources, and performance analytics for Meru University.

## Features

### 🏫 Student Registry
- Efficient student registration and lookup using Hash Tables
- O(1) average-case performance for student operations
- Collision handling with LinkedList chaining

### 📚 Course Scheduling
- Fair FIFO enrollment using Circular Queues
- Course capacity management
- Automated enrollment processing

### 💰 Fee Tracking
- Date-sorted financial records using AVL Trees
- Efficient range queries for fee reports
- Self-balancing for consistent performance

### 📖 Library System
- Book catalog management with HashMap
- Transaction history tracking using Stack
- Borrow/return operations with availability checking

### 📊 Performance Analytics
- Grade tracking with HashMap storage
- Top performer identification using PriorityQueue (Max Heap)
- Average grade calculations

## Data Structures Used

| Module | Data Structure | Time Complexity | Purpose |
|--------|----------------|-----------------|---------|
| Student Registry | Hash Table + LinkedList | O(1) avg | Fast student lookup |
| Course Scheduling | Circular Queue + HashMap | O(1) | FIFO enrollment |
| Fee Tracking | AVL Tree | O(log n) | Sorted financial data |
| Library System | Stack + HashMap | O(1) | Transaction history |
| Performance Analytics | HashMap + PriorityQueue | O(k log n) | Top-k performers |

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal/Command Prompt)

## Installation

1. **Clone or download the project files**
   ```bash
   # If using git
   git clone <repository-url>
   cd SchoolManagementSystemDSA
   ```

2. **Compile the Java files**
   ```bash
   javac *.java
   ```

3. **Run the demonstration**
   ```bash
   java SchoolManagementSystem
   ```

## Usage

The system includes a comprehensive demonstration in the `main` method that showcases all modules:

```bash
java SchoolManagementSystem
```

### Sample Output
```
=== SCHOOL MANAGEMENT SYSTEM DEMONSTRATION ===

1. STUDENT REGISTRY MODULE (Hash Table Implementation)
   - Registering student S001 (John Doe): SUCCESS
   - Total students registered: 10
   ...

2. COURSE SCHEDULING MODULE (Circular Queue + HashMap)
   - Registered courses: CS101 (capacity 5), MATH201 (capacity 3)
   - Enrolling S001 in CS101: QUEUED
   ...

3. FEE TRACKING MODULE (AVL Tree - Self-balancing BST)
   - Added Tuition fee record for S001: $500.0
   ...

4. LIBRARY SYSTEM MODULE (Stack + HashMap)
   - Added book to catalog: 'Data Structures' by Author A
   - S001 borrowing book ISBN 1234567890: SUCCESS
   ...

5. PERFORMANCE ANALYTICS MODULE (HashMap + Max Heap PriorityQueue)
   - Added grade for S001 in Math: 95.0
   - Top 3 performers:
     1. S005 with average grade 94.00
     ...
```

## Architecture

The system follows a modular architecture with a central controller (`SchoolManagementSystem`) that orchestrates five specialized modules:

```
SchoolManagementSystem
├── StudentRegistry (Hash Table)
├── CourseScheduler (Queue + HashMap)
├── FeeTracker (AVL Tree)
├── LibrarySystem (Stack + HashMap)
└── PerformanceGraph (HashMap + PriorityQueue)
```

## Documentation

- **[System Explanation](SystemExplanation.md)**: Comprehensive technical documentation
- **[Design Document](SystemDesignDocument.md)**: Architecture and data structure justifications
- **[Performance Report](PerformanceReport.md)**: Time/space complexity analysis
- **[User Manual](UserManual.md)**: Detailed usage guide
- **[TODO](TODO.md)**: Enhancement roadmap

## Educational Value

This implementation serves as an educational tool demonstrating:
- Practical applications of data structures
- Algorithm efficiency trade-offs
- Modular software design
- Real-world problem solving with DSA

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is for educational purposes. Feel free to use and modify as needed.

## Contact

For questions or feedback about this educational implementation, please refer to the documentation files.
