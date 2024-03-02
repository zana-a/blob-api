package com.zana.blob.post.mapper;

import com.google.common.base.Function;
import com.zana.blob.post.dto.CategorySaveDto;
import com.zana.blob.post.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategorySaveDtoToCategoryEntityMapper
    implements Function<CategorySaveDto, CategoryEntity> {

  @Override
  public CategoryEntity apply(CategorySaveDto input) {
    return CategoryEntity.builder()
        .name(input.getName())
        .build();
  }
}
