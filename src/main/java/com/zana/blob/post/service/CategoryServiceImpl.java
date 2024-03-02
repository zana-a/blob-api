package com.zana.blob.post.service;

import com.zana.blob.post.dto.CategoryDto;
import com.zana.blob.post.dto.CategorySaveDto;
import com.zana.blob.post.exception.CategoryExistsException;
import com.zana.blob.post.exception.CategoryNotFoundException;
import com.zana.blob.post.mapper.CategoryEntityToCategoryDtoMapper;
import com.zana.blob.post.mapper.CategorySaveDtoToCategoryEntityMapper;
import com.zana.blob.post.repository.CategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryEntityToCategoryDtoMapper categoryEntityToCategoryDtoMapper;
  private final CategorySaveDtoToCategoryEntityMapper categorySaveDtoToCategoryEntityMapper;

  @Override
  public List<CategoryDto> getCategories() {
    return categoryRepository.findAll().stream()
        .map(categoryEntityToCategoryDtoMapper)
        .toList();
  }

  @Override
  public CategoryDto getCategory(long id) {
    return categoryRepository.findById(id)
        .map(categoryEntityToCategoryDtoMapper)
        .orElseThrow(CategoryNotFoundException::new);
  }

  @Override
  public CategoryDto saveCategory(CategorySaveDto categorySaveDto) {
    var categoryEntity = categoryRepository.findByName(categorySaveDto.getName());
    if (categoryEntity.isPresent()) {
      log.info("Category `{}` already exists", categorySaveDto.getName());
      throw new CategoryExistsException();
    }
    var entity = categorySaveDtoToCategoryEntityMapper.apply(categorySaveDto);
    var savedEntity = categoryRepository.save(entity);
    log.info("Category `{}` (id={}) saved", savedEntity.getName(), savedEntity.getId());
    return categoryEntityToCategoryDtoMapper.apply(savedEntity);
  }
}
