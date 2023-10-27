package org.example.repositories;

import org.example.model.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BooksRepository {
    private List<Books> books = new ArrayList<>();
    private int nextId = 1;

   
    public Books findById(int bookId) {
        Optional<Books> optionalBooks = books.stream().filter(Books -> Books.getBook_id() == bookId).findFirst();
        return optionalBooks.orElse(null);
    }

    
    public List<Books> findAll() {
        return books;
    }

    
    public void save(Books book) {
        book.setBook_id(nextId++);
        books.add(book);
    }

    
    public void update(Books book) {
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBook_id() == book.getBook_id()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            books.set(index, book);
        }
    }

    
    public void delete(int booksId) {
        books.removeIf(book -> book.getBook_id() == booksId);
    }
}
