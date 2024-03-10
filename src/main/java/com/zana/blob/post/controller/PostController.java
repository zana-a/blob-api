package com.zana.blob.post.controller;

import com.zana.blob.post.dto.PostDto;
import com.zana.blob.post.dto.PostSaveDto;
import com.zana.blob.post.entity.PostEntity;
import com.zana.blob.post.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @GetMapping
  public ResponseEntity<List<PostDto>> getPosts() {
    return ResponseEntity.ok(postService.getPosts());
  }

  @GetMapping("/date/{year}")
  public ResponseEntity<List<PostDto>> getPostsByYear(@PathVariable int year) {
    return ResponseEntity.ok().body(postService.getPostsByYear(year));
  }

  @GetMapping("/date/{year}/{month}")
  public ResponseEntity<List<PostDto>> getPostsByYearAndMonth(@PathVariable int year,
      @PathVariable int month) {
    return ResponseEntity.ok().body(postService.getPostsByYearAndMonth(year, month));
  }

  @GetMapping("/date/{year}/{month}/{day}")
  public ResponseEntity<List<PostDto>> getPostsByYearAndMonthAndDay(@PathVariable int year,
      @PathVariable int month, @PathVariable int day) {
    return ResponseEntity.ok().body(postService.getPostsByYearAndMonthAndDay(year, month, day));
  }

  @GetMapping("/date/{year}/{month}/{day}/{slug}")
  public ResponseEntity<PostDto> getPostsByDateAndSlug(@PathVariable int year,
      @PathVariable int month, @PathVariable int day, @PathVariable String slug) {
    return ResponseEntity.ok(postService.getPostByDateAndSlug(year, month, day, slug));
  }

  @GetMapping("/category/{id}")
  public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable long id) {
    return ResponseEntity.ok(postService.getPostsByCategory(id));
  }

  @GetMapping("{id}")
  public ResponseEntity<PostEntity> getPostById(@PathVariable long id) {
    return ResponseEntity.ok(postService.getPostById(id));
  }

  @PostMapping
  public ResponseEntity<PostDto> savePost(@RequestBody PostSaveDto postSaveDto) {
    return ResponseEntity.ok(postService.savePost(postSaveDto));
  }
}
