package br.com.movieflix.MovieFlix.services;

import br.com.movieflix.MovieFlix.entity.Category;
import br.com.movieflix.MovieFlix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }

}
