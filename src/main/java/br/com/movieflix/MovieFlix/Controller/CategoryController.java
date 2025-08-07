package br.com.movieflix.MovieFlix.Controller;


import br.com.movieflix.MovieFlix.entity.Category;
import br.com.movieflix.MovieFlix.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @PostMapping()
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable Long id){
        Optional<Category> optCategory = categoryService.findById(id);
        if (optCategory.isPresent()){
            return optCategory.get();
        }
            return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }


}
