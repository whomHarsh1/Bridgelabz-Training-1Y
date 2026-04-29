package librarymanagement;

import java.util.Date;

class Transaction {
    private int transactionId;
    private BookItem bookItem;
    private User user;
    private Date issueDate;
    private Date returnDate;

    public Transaction(int transactionId, BookItem bookItem, User user) {
        this.transactionId = transactionId;
        this.bookItem = bookItem;
        this.user = user;
        this.issueDate = new Date();
    }

    public void returnBook() {
        this.returnDate = new Date();
        bookItem.setAvailable(true);
    }
}
