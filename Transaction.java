import java.util.*;

/**
 * Represents a library transaction (borrow or return).
 */
public class Transaction {
    private String isbn;
    private String studentId;
    private Date date;
    private String type; // "BORROW" or "RETURN"
    
    public Transaction(String isbn, String studentId, Date date, String type) {
        this.isbn = isbn;
        this.studentId = studentId;
        this.date = date;
        this.type = type;
    }
    
    @Override
    public String toString() {
        return String.format("Transaction{ISBN: %s, Student: %s, Type: %s, Date: %s}", 
                           isbn, studentId, type, date);
    }
}
