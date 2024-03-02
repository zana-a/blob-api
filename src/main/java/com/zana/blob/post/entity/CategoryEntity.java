package com.zana.blob.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "_category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategoryEntity {

  @Id
  @GeneratedValue
  private long id;

  @Column(unique = true)
  private String name;

}
