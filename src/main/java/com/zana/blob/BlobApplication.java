package com.zana.blob;

import com.google.common.collect.ImmutableList;
import com.zana.blob.post.dto.CategorySaveDto;
import com.zana.blob.post.dto.PostSaveDto;
import com.zana.blob.post.service.CategoryService;
import com.zana.blob.post.service.PostService;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlobApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlobApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(CategoryService categoryService,
      PostService postService) {
    return args -> {
      ImmutableList.<CategorySaveDto>builder()
          .add(CategorySaveDto.builder().name("Java").build())
          .add(CategorySaveDto.builder().name("C++").build())
          .add(CategorySaveDto.builder().name("PHP").build())
          .add(CategorySaveDto.builder().name("Ruby on Rails").build())
          .add(CategorySaveDto.builder().name("Systems Programming").build())
          .add(CategorySaveDto.builder().name("Penny for Thought").build())
          .build()
          .forEach(categoryService::saveCategory);

      ImmutableList.<PostSaveDto>builder()
          .add(PostSaveDto.builder()
              .title("Java is cool!")
              .content("The title says it all...")
              .categories(Set.of(1L))
              .build())
          .add(PostSaveDto.builder()
              .title("Why is C++ so hard :(")
              .content("I will probably die of old age before I learn it.")
              .categories(Set.of(2L, 5L, 6L))
              .build())
          .add(PostSaveDto.builder()
              .title("Is web development boring?")
              .content("Yes.")
              .categories(Set.of(3L))
              .build())
          .add(PostSaveDto.builder()
              .title("Ruby on Rails is dead — long live Spring boot!")
              .content("Better believe it sweet cheeks.")
              .categories(Set.of(3L))
              .build())
          .add(PostSaveDto.builder()
              .title("Boring post!")
              .content("A boring post.")
              .categories(Set.of())
              .build())
          .build()
          .forEach(postService::savePost);
    };
  }
}
