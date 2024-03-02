package com.zana.blob.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.zana.blob.post.controller.PostController;
import com.zana.blob.post.dto.PostDto;
import com.zana.blob.post.dto.PostSaveDto;
import com.zana.blob.post.service.CategoryService;
import com.zana.blob.post.service.PostService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = PostController.class)
public class PostControllerTest {

  private final List<PostDto> posts = ImmutableList.<PostDto>builder()
      .add(PostDto.builder().build())
      .add(PostDto.builder().build())
      .add(PostDto.builder().build())
      .build();

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  @SuppressWarnings("unused")
  private CategoryService categoryService;

  @MockBean
  private PostService postService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void getAllPosts() throws Exception {
    when(postService.getPosts())
        .thenReturn(posts);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/v1/posts"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(posts)));
  }

  @Test
  public void getSinglePost_ByYear() throws Exception {
    when(postService.getPostsByYear(anyInt()))
        .thenReturn(posts);

    mockMvc
        .perform(MockMvcRequestBuilders.get(String.format("/api/v1/posts/%s", anyInt())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(posts)));
  }

  @Test
  public void getSinglePost_ByYearAndMonth() throws Exception {
    when(postService.getPostsByYearAndMonth(anyInt(), anyInt()))
        .thenReturn(posts);

    mockMvc
        .perform(MockMvcRequestBuilders.get(String.format("/api/v1/posts/%s/%s",
            anyInt(), anyInt())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(posts)));
  }

  @Test
  public void getSinglePost_ByYearAndMonthAndDay() throws Exception {
    when(postService.getPostsByYearAndMonthAndDay(anyInt(), anyInt(), anyInt()))
        .thenReturn(posts);

    mockMvc
        .perform(MockMvcRequestBuilders.get(String.format("/api/v1/posts/%s/%s/%s",
            anyInt(), anyInt(), anyInt())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(posts)));
  }

  @Test
  public void getSinglePost_ByDateAndSlug() throws Exception {
    when(postService.getPostByDateAndSlug(anyInt(), anyInt(), anyInt(), anyString()))
        .thenReturn(posts.getFirst());

    mockMvc
        .perform(MockMvcRequestBuilders.get(String.format("/api/v1/posts/%s/%s/%s/%s",
            2024, 2, 24, "hello-world")))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(posts.getFirst())));
  }

  @Test
  public void savePost() throws Exception {
    when(postService.savePost(PostSaveDto.builder().build()))
        .thenReturn(posts.getFirst());

    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/posts"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(posts.getFirst())));
  }
}
