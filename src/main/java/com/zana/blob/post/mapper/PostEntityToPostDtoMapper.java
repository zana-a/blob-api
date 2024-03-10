package com.zana.blob.post.mapper;

import com.google.common.base.Function;
import com.zana.blob.post.dto.PostDto;
import com.zana.blob.post.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostEntityToPostDtoMapper implements Function<PostEntity, PostDto> {

  private final CategoryEntityToCategoryDtoMapper categoryEntityToCategoryDtoMapper;

  @Override
  public PostDto apply(PostEntity input) {
    return PostDto.builder()
        .id(input.getId())
        .title(input.getTitle())
        .slug(input.getSlug())
        .content(input.getContent())
        .categories(input.getCategories().stream()
            .map(categoryEntityToCategoryDtoMapper)
            .toList())
        .createdAt(input.getCreatedAt())
        .updatedAt(input.getUpdatedAt())
        .build();
  }
}
