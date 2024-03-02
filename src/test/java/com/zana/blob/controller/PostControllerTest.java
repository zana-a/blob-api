package com.zana.blob.controller;

import com.zana.blob.post.controller.PostController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers = PostController.class)
public class PostControllerTest {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @MockBean
//  private PostService postService;
//
//  @Autowired
//  private ObjectMapper jacksonObjectMapper;
//
//  @Test
//  public void getAllPosts_hasPosts() throws Exception {
//    var posts = new ImmutableList.Builder<PostDto>()
//        .add(PostDto.builder().build())
//        .add(PostDto.builder().build())
//        .add(PostDto.builder().build())
//        .build();
//
//    when(postService.getPosts()).thenReturn(posts);
//
//    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts"))
//        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(content().json(jacksonObjectMapper.writeValueAsString(posts)))
//        .andReturn();
//  }
//
//  @Test
//  public void getAllPosts_hasNoPosts() throws Exception {
//    var posts = new ImmutableList.Builder<PostDto>().build();
//
//    when(postService.getPosts()).thenReturn(posts);
//
//    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts"))
//        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(content().json(jacksonObjectMapper.writeValueAsString(posts)))
//        .andReturn();
//  }
//
//  @Test
//  public void getPostForDate_hasPosts() throws Exception {
//    var posts = new ImmutableList.Builder<PostDto>()
//        .add(PostDto.builder().build())
//        .add(PostDto.builder().build())
//        .add(PostDto.builder().build())
//        .build();
//
//    var date = LocalDate.now();
//
//    when(postService.getPosts(date)).thenReturn(posts);
//
//    mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/v1/posts/%s", date)))
//        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(content().json(jacksonObjectMapper.writeValueAsString(posts)))
//        .andReturn();
//  }
//
//  @Test
//  public void getPostForDate_hasNoPosts() throws Exception {
//    var posts = new ImmutableList.Builder<PostDto>()
//        .add(PostDto.builder().build())
//        .add(PostDto.builder().build())
//        .add(PostDto.builder().build())
//        .build();
//
//    var date = LocalDate.now();
//
//    when(postService.getPosts(date)).thenReturn(posts);
//
//    mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/v1/posts/%s", date)))
//        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(content().json(jacksonObjectMapper.writeValueAsString(posts)))
//        .andReturn();
//  }
//
//  @Test
//  public void getPostForDateAndSlug_hasNoPost() throws Exception {
//    var date = LocalDate.now();
//    var slug = "hello-world";
//
//    when(postService.getPost(date, slug)).thenReturn(Optional.empty());
//
//    mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/v1/posts/%s/%s", date, slug)))
//        .andDo(print())
//        .andExpect(status().isNotFound())
//        .andReturn();
//  }
//
//  @Test
//  public void getPostForDateAndSlug_hasPost() throws Exception {
//    var post = PostDto.builder().build();
//    var date = LocalDate.now();
//    var slug = "hello-world";
//
//    when(postService.getPost(date, slug)).thenReturn(Optional.of(post));
//
//    mockMvc.perform(MockMvcRequestBuilders.get(String.format("/api/v1/posts/%s/%s", date, slug)))
//        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(content().json(jacksonObjectMapper.writeValueAsString(post)))
//        .andReturn();
//  }
}
