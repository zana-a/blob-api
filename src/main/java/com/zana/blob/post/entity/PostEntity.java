package com.zana.blob.post.entity;

import com.google.common.collect.Sets;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "_post")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PostEntity {

  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String slug;

  @Column(nullable = false)
  private String content;

  @ManyToMany
  @JoinTable(name = "_post_category",
      joinColumns = @JoinColumn(name = "post_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<CategoryEntity> categories = Sets.newHashSet();

  @CreationTimestamp
  private LocalDate createdAt;

  @UpdateTimestamp
  private LocalDate updatedAt;

}
