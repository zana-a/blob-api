package com.zana.blob.post.service;

import com.zana.blob.post.dto.PostDto;
import com.zana.blob.post.dto.PostSaveDto;
import com.zana.blob.post.exception.CategoryNotFoundException;
import com.zana.blob.post.exception.PostExistsException;
import com.zana.blob.post.exception.PostNotFoundException;
import com.zana.blob.post.helper.SlugHelper;
import com.zana.blob.post.mapper.PostEntityToPostDtoMapper;
import com.zana.blob.post.mapper.SavePostDtoToPostEntityMapper;
import com.zana.blob.post.repository.CategoryRepository;
import com.zana.blob.post.repository.PostRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final CategoryRepository categoryRepository;

  private final PostEntityToPostDtoMapper postEntityToPostDtoMapper;
  private final SavePostDtoToPostEntityMapper postSaveDtoToPostEntityMapper;

  private final SlugHelper slugHelper;

  @Override
  public List<PostDto> getPosts() {
    return postRepository.findAll().stream()
        .map(postEntityToPostDtoMapper)
        .toList();
  }

  @Override
  public List<PostDto> getPostsByYear(int year) {
    return postRepository.findByYear(year).stream()
        .map(postEntityToPostDtoMapper)
        .toList();
  }

  @Override
  public List<PostDto> getPostsByYearAndMonth(int year, int month) {
    return postRepository.findByYearAndMonth(year, month).stream()
        .map(postEntityToPostDtoMapper)
        .toList();
  }

  @Override
  public List<PostDto> getPostsByYearAndMonthAndDay(int year, int month, int day) {
    return postRepository.findByYearAndMonthAndDay(year, month, day).stream()
        .map(postEntityToPostDtoMapper)
        .toList();
  }

  @Override
  public PostDto getPostByDateAndSlug(int year, int month, int day, String slug) {
    return postRepository.findByDateAndSlug(LocalDate.of(year, month, day), slug)
        .map(postEntityToPostDtoMapper)
        .orElseThrow(PostNotFoundException::new);
  }

  @Override
  public PostDto savePost(PostSaveDto postSaveDto) {
    var date = LocalDate.now();
    var slug = slugHelper.createSlug(postSaveDto.getTitle());

    postRepository.findByDateAndSlug(date, slug)
        .ifPresent(entity -> {
          throw new PostExistsException(entity);
        });

    var categories = postSaveDto.getCategories().stream()
        .map(categoryRepository::findById)
        .collect(Collectors.toSet());

    var allCategoriesPresent = categories.stream().noneMatch(Optional::isEmpty);

    if (!allCategoriesPresent) {
      throw new CategoryNotFoundException();
    }

    var postEntity = postSaveDtoToPostEntityMapper.apply(postSaveDto);

    postEntity.getCategories()
        .addAll(categories.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toSet()));

    var savedPostEntity = postRepository.save(postEntity);

    log.info("Post `{}` (id={}}) saved", savedPostEntity.getTitle(), savedPostEntity.getId());

    return postEntityToPostDtoMapper.apply(savedPostEntity);
  }
}
