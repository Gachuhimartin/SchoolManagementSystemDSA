import java.util.*;

public class LibrarySystem {
    private Map<String, Book> bookCatalog;
    private Stack<Transaction> transactionHistory;
    
    public LibrarySystem() {
        this.bookCatalog = new HashMap<>();
        this.transactionHistory = new Stack<>();
    }
    
    public void addBook(Book book) {
        bookCatalog.put(book.getIsbn(), book);
    }
    
    public boolean borrowBook(String isbn, String studentId) {
        Book book = bookCatalog.get(isbn);
        if (book == null || !book.isAvailable()) {
            return false;
        }
        
        book.setAvailable(false);
        transactionHistory.push(new Transaction(isbn, studentId, new Date(), "BORROW"));
        return true;
    }
    
    public boolean returnBook(String isbn, String studentId) {
        Book book = bookCatalog.get(isbn);
        if (book == null || book.isAvailable()) {
            return false;
        }
        
        book.setAvailable(true);
        transactionHistory.push(new Transaction(isbn, studentId, new Date(), "RETURN"));
        return true;
    }
    
    public Book searchBook(String isbn) {
        return bookCatalog.get(isbn);
    }
    
    public List<Transaction> getRecentTransactions(int count) {
        List<Transaction> recent = new ArrayList<>();
        Stack<Transaction> temp = new Stack<>();
        
        for (int i = 0; i < count && !transactionHistory.isEmpty(); i++) {
            Transaction transaction = transactionHistory.pop();
            recent.add(transaction);
            temp.push(transaction);
        }
        
        // Restore the stack
        while (!temp.isEmpty()) {
            transactionHistory.push(temp.pop());
        }
        
        return recent;
    }
}