package br.com.movieflix.MovieFlix.mapper;

import br.com.movieflix.MovieFlix.Controller.request.CategoryRequest;
import br.com.movieflix.MovieFlix.Controller.response.CategoryResponse;
import br.com.movieflix.MovieFlix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

   public static Category toCategory(CategoryRequest categoryRequest){
       return Category
               .builder()
               .nome(categoryRequest.nome())
               .build();
   }

   public static CategoryResponse toCategoryResponse(Category category){
       return CategoryResponse
               .builder()
               .id(category.getId())
               .nome(category.getNome())
               .build();

   }
}
