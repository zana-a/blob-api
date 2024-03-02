package com.zana.blob.post.mapper;

import com.google.common.base.Function;
import com.zana.blob.post.dto.PostDto;
import com.zana.blob.post.entity.PostEntity;
import com.zana.blob.post.helper.SlugHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostDtoToPostEntityMapper implements Function<PostDto, PostEntity> {

  private final SlugHelper slugHelper;

  @Override
  public PostEntity apply(PostDto input) {
    return PostEntity.builder()
        .title(input.getTitle())
        .slug(slugHelper.createSlug(input.getSlug()))
        .content(input.getContent())
        .build();
  }
}
