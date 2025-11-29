# School Management System Installation Guide

## Overview

This guide provides step-by-step instructions for installing and setting up the School Management System (SMS) on various operating systems. The SMS is a Java-based application that demonstrates practical implementations of data structures and algorithms.

## System Requirements

### Minimum Requirements
- **Operating System**: Windows 10+, macOS 10.12+, or Linux (Ubuntu 16.04+)
- **Java**: JDK/JRE 8 or higher
- **Memory**: 512 MB RAM
- **Storage**: 50 MB free disk space

### Recommended Requirements
- **Java**: JDK 11+ for optimal performance
- **Memory**: 1 GB RAM or more
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code (for development)

## Installation Methods

### Method 1: Direct Download (Simplest)

1. **Download the source files**
   - Download all `.java` files from the project repository
   - Ensure you have all required files:
     ```
     SchoolManagementSystem.java
     StudentRegistry.java
     CourseScheduler.java
     FeeTracker.java
     LibrarySystem.java
     PerformanceGraph.java
     Student.java
     Book.java
     Transaction.java
     FeeRecord.java
     StudentPerformance.java
     ```

2. **Verify file integrity**
   ```bash
   # List all Java files to ensure completeness
   ls -la *.java
   ```

3. **Proceed to Java setup** (see below)

### Method 2: Git Clone (For Developers)

1. **Install Git**
   - **Windows**: Download from [git-scm.com](https://git-scm.com/download/win)
   - **macOS**: `brew install git` (requires Homebrew)
   - **Ubuntu/Debian**: `sudo apt-get install git`
   - **CentOS/RHEL**: `sudo yum install git` or `sudo dnf install git`

2. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd SchoolManagementSystemDSA
   ```

3. **Verify files**
   ```bash
   ls -la
   ```

## Java Installation and Setup

### Windows Setup

1. **Download JDK**
   - Visit [adoptium.net](https://adoptium.net/)
   - Download Eclipse Temurin JDK 11 or 17 (LTS version)
   - Choose the `.msi` installer for Windows

2. **Install JDK**
   - Run the downloaded installer
   - Follow the installation wizard
   - Note the installation directory (usually `C:\Program Files\Eclipse Adoptium\jdk-XX.x.x`)

3. **Set Environment Variables**
   - Open System Properties → Advanced → Environment Variables
   - Under "System variables", click "New"
   - Variable name: `JAVA_HOME`
   - Variable value: `C:\Program Files\Eclipse Adoptium\jdk-XX.x.x`
   - Find "Path" in System variables, click "Edit"
   - Add: `%JAVA_HOME%\bin`

4. **Verify Installation**
   ```cmd
   java -version
   javac -version
   ```

### macOS Setup

1. **Install Homebrew** (if not already installed)
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```

2. **Install JDK**
   ```bash
   brew install openjdk@11
   ```

3. **Set JAVA_HOME**
   ```bash
   # For zsh (default on macOS 10.15+)
   echo 'export JAVA_HOME=/usr/local/opt/openjdk@11/libexec/openjdk.jdk/Contents/Home' >> ~/.zshrc
   source ~/.zshrc

   # For bash
   echo 'export JAVA_HOME=/usr/local/opt/openjdk@11/libexec/openjdk.jdk/Contents/Home' >> ~/.bash_profile
   source ~/.bash_profile
   ```

4. **Verify Installation**
   ```bash
   java -version
   javac -version
   echo $JAVA_HOME
   ```

### Linux Setup

#### Ubuntu/Debian

1. **Update package list**
   ```bash
   sudo apt update
   ```

2. **Install JDK**
   ```bash
   sudo apt install openjdk-11-jdk
   ```

3. **Verify Installation**
   ```bash
   java -version
   javac -version
   ```

#### CentOS/RHEL/Fedora

1. **Install JDK**
   ```bash
   # CentOS/RHEL 7
   sudo yum install java-11-openjdk-devel

   # CentOS/RHEL 8+ or Fedora
   sudo dnf install java-11-openjdk-devel
   ```

2. **Verify Installation**
   ```bash
   java -version
   javac -version
   ```

## Compilation and Execution

### Compile the Application

1. **Navigate to project directory**
   ```bash
   cd /path/to/SchoolManagementSystemDSA
   ```

2. **Compile all Java files**
   ```bash
   javac *.java
   ```

   **Expected output**: No errors, creates `.class` files

3. **Verify compilation**
   ```bash
   ls -la *.class
   ```

### Run the Demonstration

1. **Execute the main program**
   ```bash
   java SchoolManagementSystem
   ```

2. **Expected output**: Comprehensive demonstration of all modules

### Troubleshooting Compilation

#### Common Issues

**"javac: command not found"**
- Java JDK not installed or not in PATH
- Reinstall JDK and verify environment variables

**"package does not exist"**
- Ensure all source files are in the same directory
- Check for missing import statements

**"class not found"**
- Compile all files together: `javac *.java`
- Ensure no circular dependencies

**Memory errors during compilation**
- Increase heap size: `javac -J-Xmx512m *.java`

## Running Tests

### Automated Testing (Future Enhancement)
The system currently includes a demonstration program that serves as comprehensive testing. Future versions may include JUnit tests.

### Manual Testing
1. Run the demonstration program
2. Verify all modules initialize correctly
3. Check that operations complete without errors
4. Validate output matches expected results

## IDE Setup (Optional)

### IntelliJ IDEA
1. **Import Project**
   - File → Open → Select project directory
   - Choose "Create project from existing sources"

2. **Configure JDK**
   - File → Project Structure → Project SDK
   - Add JDK if not detected

3. **Run Configuration**
   - Run → Edit Configurations
   - Add new Application configuration
   - Main class: `SchoolManagementSystem`

### Eclipse
1. **Import Project**
   - File → Import → General → Existing Projects into Workspace
   - Select project directory

2. **Configure Build Path**
   - Right-click project → Properties → Java Build Path
   - Ensure JDK is selected

### VS Code
1. **Install Extensions**
   - Java Extension Pack
   - Java Debugger

2. **Open Folder**
   - File → Open Folder → Select project directory

3. **Run Program**
   - Open `SchoolManagementSystem.java`
   - Click "Run" above the main method

## Post-Installation Configuration

### Customization
- Modify sample data in `main` method
- Adjust data structure capacities
- Add additional test cases

### Performance Tuning
- Increase hash table sizes for larger datasets
- Adjust course capacities based on needs
- Monitor memory usage with large datasets

## Verification Checklist

- [ ] Java JDK installed and configured
- [ ] All source files present
- [ ] Compilation successful (no errors)
- [ ] Demonstration program runs
- [ ] All modules initialize correctly
- [ ] Sample operations complete successfully

## Getting Help

### Common Issues and Solutions

**Program won't start**
- Verify `java` command works
- Check classpath if using packages
- Ensure all `.class` files exist

**OutOfMemoryError**
- Increase heap size: `java -Xmx1g SchoolManagementSystem`
- Reduce dataset sizes in demonstration

**ClassNotFoundException**
- Compile all files: `javac *.java`
- Run from correct directory

### Support Resources
- Check documentation files in the project
- Review GitHub issues for similar problems
- Test with minimal dataset first

## Next Steps

After successful installation:
1. Run the demonstration program to understand system capabilities
2. Read the [User Manual](UserManual.md) for detailed usage instructions
3. Explore the [API Documentation](APIDocumentation.md) for development
4. Consider contributing via the [Contributing Guide](ContributingGuide.md)

## Uninstalling

To remove the system:
1. Delete the project directory
2. Optionally remove JDK (if installed solely for this project)
3. Remove environment variables (JAVA_HOME) if no longer needed

The system uses no external dependencies and leaves no residual files on the system.
