package com.zana.blob.post.repository;

import com.zana.blob.post.entity.CategoryEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

  Optional<CategoryEntity> findByName(String name);
  
}
