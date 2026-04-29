package librarymanagement;



class BookItem {
    private int bookId;
    private Book book;
    private boolean isAvailable;

    public BookItem(int bookId, Book book) {
        this.bookId = bookId;
        this.book = book;
        this.isAvailable = true;
    }

    public int getBookId() {
        return bookId;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }
}

