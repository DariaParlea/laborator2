package org.example.repositories;

import org.example.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepository {
    private List<Category> categories = new ArrayList<>();
    private int nextID = 1;

    public Category findById(int categoryId){
        Optional<Category> optionalCategory = categories.stream().filter(category -> category.getCategory_id() == categoryId).findFirst();
        return optionalCategory.orElse(null);
    }

    public List<Category> findAll(){
        return categories;
    }

    public void save(Category category){
        category.setCategory_id(nextID++);
        categories.add(category);
    }

    public void update(Category category){
        int index = -1;
        for(int i=0; i<categories.size();i++)
            if(categories.get(i).getCategory_id() == category.getCategory_id()){
                index = i;
                return;
            }
        if(index != -1)
            categories.set(index,category);
    }

    public void delete(int categoryId){
        categories.removeIf((category -> category.getCategory_id() == categoryId));
    }
}
