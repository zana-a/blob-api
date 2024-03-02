package com.zana.blob.post.exception;

import com.zana.blob.post.entity.PostEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PostExistsException extends RuntimeException {

  private static final String MESSAGE_TEMPLATE = "Post `%s` already exists for date `%s`";

  public PostExistsException(PostEntity postEntity) {
    super(String.format(MESSAGE_TEMPLATE, postEntity.getTitle(), postEntity.getCreatedAt()));
  }
}
