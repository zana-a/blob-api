package com.zana.blob.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zana.blob.post.controller.CategoryController;
import com.zana.blob.post.dto.CategoryDto;
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

@WebMvcTest(controllers = CategoryController.class)
public class CategoryControllerTest {

  private final List<CategoryDto> categories = List.of(
      CategoryDto.builder().build(),
      CategoryDto.builder().build(),
      CategoryDto.builder().build()
  );

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private CategoryService categoryService;

  @MockBean
  private PostService postService;

  @Test
  public void getAllCategories() throws Exception {
    when(categoryService.getCategories()).thenReturn(categories);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/categories"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(categories)));
  }

  @Test
  public void getSingleCategory() throws Exception {
    when(categoryService.getCategory(anyLong())).thenReturn(categories.getFirst());
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/categories/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(categories.getFirst())));
  }
}
