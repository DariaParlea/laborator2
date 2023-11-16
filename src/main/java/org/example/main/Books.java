package org.example.main;


import org.example.main.Patterns.Decorator.BooksDecorator;

public class Books implements BooksDecorator {
    private int book_id;
    private String title;
    private int publishing_year;
    private Author author;
    private int price;
    private Category category;

    public Books(int book_id, String title, int publishing_year, Author author, int price, Category category) {
        this.book_id = book_id;
        this.title = title;
        this.publishing_year = publishing_year;
        this.author = author;
        this.price = price;
        this.category = category;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishing_year() {
        return publishing_year;
    }

    public void setPublishing_year(int publishing_year) {
        this.publishing_year = publishing_year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
