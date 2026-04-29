package librarymanagement;

import java.util.*;

class Library {
    private List<BookItem> bookItems = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBookItem(BookItem bookItem) {
        bookItems.add(bookItem);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public BookItem searchById(int id) {
        for (BookItem item : bookItems) {
            if (item.getBookId() == id) {
                return item;
            }
        }
        return null;
    }
}
