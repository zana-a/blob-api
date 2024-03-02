package com.zana.blob.post.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

  private String title;

  private String slug;

  private String content;

  private List<CategoryDto> categories;

  private LocalDate createdAt;

  private LocalDate updatedAt;

}
