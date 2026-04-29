package librarymanagement;

import java.util.*;

class SearchEngine {

    public List<BookItem> searchByTitle(List<BookItem> items, String title) {
        List<BookItem> result = new ArrayList<>();
        for (BookItem item : items) {
            if (item.getBook().getTitle().equalsIgnoreCase(title)) {
                result.add(item);
            }
        }
        return result;
    }
}
