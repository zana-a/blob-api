package com.zana.blob.post.helper;

import com.github.slugify.Slugify;
import org.springframework.stereotype.Component;

@Component
public class SlugHelper {

  private final Slugify slugify = Slugify.builder().build();

  public String createSlug(String title) {
    return slugify.slugify(title);
  }
}
