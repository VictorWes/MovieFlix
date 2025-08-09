package br.com.movieflix.MovieFlix.Controller;


import br.com.movieflix.MovieFlix.Controller.request.CategoryRequest;
import br.com.movieflix.MovieFlix.Controller.response.CategoryResponse;
import br.com.movieflix.MovieFlix.entity.Category;
import br.com.movieflix.MovieFlix.mapper.CategoryMapper;
import br.com.movieflix.MovieFlix.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request) {

        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarByCategoriaId(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
