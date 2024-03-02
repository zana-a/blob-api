package com.zana.blob.post.service;

import com.zana.blob.post.dto.CategoryDto;
import com.zana.blob.post.dto.CategorySaveDto;
import java.util.List;

public interface CategoryService {

  List<CategoryDto> getCategories();

  CategoryDto getCategory(long id);

  CategoryDto saveCategory(CategorySaveDto categorySaveDto);
  
}
