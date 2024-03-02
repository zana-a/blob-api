package com.zana.blob.post.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

  public CategoryNotFoundException() {
    super("Category not found");
  }

  public CategoryNotFoundException(long id) {
    super(String.format("Category of `id=%s` not found", id));
  }
}
