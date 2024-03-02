package com.zana.blob.post.mapper;

import com.google.common.base.Function;
import com.zana.blob.post.dto.CategoryDto;
import com.zana.blob.post.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntityToCategoryDtoMapper implements Function<CategoryEntity, CategoryDto> {

  @Override
  public CategoryDto apply(CategoryEntity input) {
    return CategoryDto.builder()
        .id(input.getId())
        .name(input.getName())
        .build();
  }
}
