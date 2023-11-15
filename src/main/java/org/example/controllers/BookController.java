package org.example.controllers;
import java.util.Scanner;

import org.example.main.*;
import org.example.repositories.BooksRepository;
import org.example.repositories.CartItemRepository;

import java.util.List;

public class BookController {
    private BooksRepository bookRepository;
    private Scanner scanner = new Scanner(System.in);
    private Clients currentClient;

    public BookController(BooksRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(int book_id, String title, int publishing_year, Author author, int price, Category category) {
        Books book = new Books(book_id, title, publishing_year, author, price, category);
        bookRepository.save(book);
    }

    public Books findBookById(int bookID) {
        return bookRepository.findById(bookID);
    }

    public List<Books> viewAllBooks() {
        return bookRepository.findAll();
    }

    public void updateBook(int book_id, String title, int publishing_year, Author author, int price, Category category) {
        Books updatedbook = new Books(book_id, title, publishing_year, author, price, category);
        bookRepository.update(updatedbook);
    }

    public void deleteBook(int bookId) {
        bookRepository.delete(bookId);
    }


}
