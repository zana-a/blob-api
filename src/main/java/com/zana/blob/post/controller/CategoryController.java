package com.zana.blob.post.controller;

import com.zana.blob.post.dto.CategoryDto;
import com.zana.blob.post.dto.CategorySaveDto;
import com.zana.blob.post.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<CategoryDto>> getCategories() {
    return ResponseEntity.ok(categoryService.getCategories());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryDto> getCategory(@PathVariable long id) {
    return ResponseEntity.ok(categoryService.getCategory(id));
  }

  @PostMapping
  public ResponseEntity<CategoryDto> createCategory(@RequestBody CategorySaveDto categorySaveDto) {
    return ResponseEntity.ok(categoryService.saveCategory(categorySaveDto));
  }
}
