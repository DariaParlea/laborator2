package org.example.controllers;

import org.example.main.Author;
import org.example.repositories.AuthorRepository;

import java.util.List;

public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void creatAauthor(int authorId, String firstName, String lastName, String birthDate,String address) {
        Author author = new Author(authorId, firstName, lastName, birthDate, address);
        authorRepository.save(author);
    }


    public Author findAuthorById(int authorId) {
        return authorRepository.findById(authorId);
    }

    public Author findAuthorByName(String firstname, String lastname){return authorRepository.findbyName(firstname,lastname);}

    public List<Author> viewAllAuthors() {
        return authorRepository.findAll();
    }

    public void updateAuthor(int authorId, String firstName, String lastName, String birthDate,String address) {
        Author updatedAuthor = new Author(authorId, firstName, lastName, birthDate, address);
        authorRepository.update(updatedAuthor);
    }

    public void deleteAuthor(int authorId) {
        authorRepository.delete(authorId);
    }


}
