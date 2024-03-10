package com.zana.blob.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.zana.blob.post.entity.PostEntity;
import com.zana.blob.post.repository.PostRepository;
import com.zana.blob.post.service.PostService;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class PostServiceTest {

  @MockBean
  private PostRepository postRepository;

  @InjectMocks
  private PostService postService;

  @Test
  public void getAllPosts() {
    var postEntities = List.of(
        PostEntity.builder()
            .id(1)
            .title("Test A")
            .slug("test-a")
            .categories(Set.of())
            .createdAt(LocalDate.of(2024, 1, 1))
            .createdAt(LocalDate.of(2024, 1, 2))
            .build(),
        PostEntity.builder()
            .id(2)
            .title("Test B")
            .slug("test-b")
            .createdAt(LocalDate.of(2024, 1, 1))
            .createdAt(LocalDate.of(2024, 1, 1))
            .categories(Set.of())
            .build());

    when(postRepository.findAll()).thenReturn(postEntities);

    var postDtos = postService.getPosts();

    assertEquals(2, postDtos.size());
    assertEquals("Test A", postDtos.getFirst().getTitle());
    assertEquals("test-a", postDtos.getFirst().getSlug());
    assertEquals(LocalDate.of(2024, 1, 1), postDtos.getFirst().getCreatedAt());
    assertEquals(LocalDate.of(2024, 1, 2), postDtos.getFirst().getUpdatedAt());
    assertTrue(postDtos.getFirst().getCreatedAt().isBefore(postDtos.getFirst().getUpdatedAt()));
  }

  // get posts by year

  // get posts by year and month

  // get posts by year and month and day

  // get post by year and month and day and slug

}
