package com.zana.blob.post.exception;

import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

  public CategoryNotFoundException() {
    super("Category not found");
  }

  public CategoryNotFoundException(String category) {
    super(String.format("Category not found: %s", category));
  }

  public CategoryNotFoundException(Set<String> categories) {
    super(String.format("Category not found: %s", categories));
  }
}
