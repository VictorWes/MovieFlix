package br.com.movieflix.MovieFlix.Controller;


import br.com.movieflix.MovieFlix.Controller.request.CategoryRequest;
import br.com.movieflix.MovieFlix.Controller.response.CategoryResponse;
import br.com.movieflix.MovieFlix.entity.Category;
import br.com.movieflix.MovieFlix.mapper.CategoryMapper;
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
    public List<CategoryResponse> getAllCategories(){
       List<Category> categories = categoryService.findAll();
       return categories.stream()
               .map(CategoryMapper::toCategoryResponse)
               .toList();
    }

    @PostMapping()
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request){

        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return CategoryMapper.toCategoryResponse(savedCategory);
    }

    @GetMapping("/{id}")
    public CategoryResponse findCategoryById(@PathVariable Long id){
        Optional<Category> optCategory = categoryService.findById(id);
        if (optCategory.isPresent()){
            return CategoryMapper.toCategoryResponse(optCategory.get());
        }
            return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }


}
