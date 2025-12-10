import java.util.*;

class FeeRecord implements Comparable<FeeRecord> {
    private String studentId;
    private double amount;
    private Date transactionDate;
    private String paymentType;
    
    public FeeRecord(String studentId, double amount, Date transactionDate, String paymentType) {
        this.studentId = studentId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.paymentType = paymentType;
    }
    
    // Getters
    public String getStudentId() { return studentId; }
    public double getAmount() { return amount; }
    public Date getTransactionDate() { return transactionDate; }
    public String getPaymentType() { return paymentType; }
    
    @Override
    public int compareTo(FeeRecord other) {
        int dateCompare = this.transactionDate.compareTo(other.transactionDate);
        if (dateCompare != 0) return dateCompare;
        return this.studentId.compareTo(other.studentId);
    }
    
    @Override
    public String toString() {
        return String.format("FeeRecord{Student: %s, Amount: $%.2f, Date: %s}", 
                           studentId, amount, transactionDate);
    }
}

class AVLNode {
    FeeRecord record;
    AVLNode left, right;
    int height;
    
    public AVLNode(FeeRecord record) {
        this.record = record;
        this.height = 1;
    }
}

public class FeeTracker {
    private AVLNode root;
    
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }
    
    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
    
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        
        x.right = y;
        y.left = T2;
        
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        
        y.left = x;
        x.right = T2;
        
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    public void addFeeRecord(FeeRecord record) {
        root = insert(root, record);
    }
    
    private AVLNode insert(AVLNode node, FeeRecord record) {
        if (node == null) {
            return new AVLNode(record);
        }
        
        if (record.compareTo(node.record) < 0) {
            node.left = insert(node.left, record);
        } else if (record.compareTo(node.record) > 0) {
            node.right = insert(node.right, record);
        } else {
            return node; // Duplicate records not allowed
        }
        
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        int balance = getBalance(node);
        
        // Left Left Case
        if (balance > 1 && record.compareTo(node.left.record) < 0) {
            return rightRotate(node);
        }
        
        // Right Right Case
        if (balance < -1 && record.compareTo(node.right.record) > 0) {
            return leftRotate(node);
        }
        
        // Left Right Case
        if (balance > 1 && record.compareTo(node.left.record) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right Left Case
        if (balance < -1 && record.compareTo(node.right.record) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    public List<FeeRecord> getFeeRecordsInRange(Date startDate, Date endDate) {
        List<FeeRecord> result = new ArrayList<>();
        inOrderRangeSearch(root, startDate, endDate, result);
        return result;
    }
    
    private void inOrderRangeSearch(AVLNode node, Date start, Date end, List<FeeRecord> result) {
        if (node == null) return;
        
        inOrderRangeSearch(node.left, start, end, result);
        
        if (!node.record.getTransactionDate().before(start) && 
            !node.record.getTransactionDate().after(end)) {
            result.add(node.record);
        }
        
        inOrderRangeSearch(node.right, start, end, result);
    }
}