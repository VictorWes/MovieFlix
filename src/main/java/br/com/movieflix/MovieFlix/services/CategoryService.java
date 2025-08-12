package br.com.movieflix.MovieFlix.services;

import br.com.movieflix.MovieFlix.entity.Category;
import br.com.movieflix.MovieFlix.entity.Streaming;
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

    public Optional<Category> update(Long id, Category category){
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()){

            Category categoryAltered = byId.get();

            categoryAltered.setNome(category.getNome());
            categoryRepository.save(categoryAltered);
            return Optional.of(categoryAltered);

        }
        return Optional.empty();

    }

}
