package com.zana.blob.post.mapper;

import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.zana.blob.post.dto.PostSaveDto;
import com.zana.blob.post.entity.PostEntity;
import com.zana.blob.post.helper.SlugHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SavePostDtoToPostEntityMapper implements Function<PostSaveDto, PostEntity> {

  private final SlugHelper slugHelper;

  @Override
  public PostEntity apply(PostSaveDto input) {
    return PostEntity.builder()
        .title(input.getTitle())
        .slug(slugHelper.createSlug(input.getTitle()))
        .categories(Sets.newHashSet())
        .content(input.getContent())
        .build();
  }
}
