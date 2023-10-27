package org.example.repositories;

import org.example.model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepository {
    private List<Author> authors = new ArrayList<>();
    private int nextID = 1;

    public Author findById(int authorId){
        Optional<Author> optionalAuthor = authors.stream().filter(author -> author.getAuthor_id() == authorId).findFirst();
        return optionalAuthor.orElse(null);
    }

    public List<Author> findAll(){
        return authors;
    }

    public void save(Author author){
        author.setAuthor_id(nextID++);
        authors.add(author);
    }
    public void update(Author author){
        int index = -1;
        for (int i = 0; i < authors.size(); i++){
            if(authors.get(i).getAuthor_id() == author.getAuthor_id()){
                index = i;
                break;
            }
        }
        if(index != -1)
            authors.set(index, author);
    }
    public void delete(int authorId){
        authors.removeIf(author -> author.getAuthor_id() == authorId);
    }
}
