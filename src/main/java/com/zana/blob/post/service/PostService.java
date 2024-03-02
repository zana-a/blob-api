package com.zana.blob.post.service;

import com.zana.blob.post.dto.PostDto;
import com.zana.blob.post.dto.PostSaveDto;
import java.util.List;

public interface PostService {

  List<PostDto> getPosts();

  List<PostDto> getPostsByYear(int year);

  List<PostDto> getPostsByYearAndMonth(int year, int month);

  List<PostDto> getPostsByYearAndMonthAndDay(int year, int month, int day);

  PostDto getPostByDateAndSlug(int year, int month, int day, String slug);

  PostDto savePost(PostSaveDto postSaveDto);

}
