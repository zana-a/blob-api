package com.zana.blob.post.repository;

import com.zana.blob.post.entity.PostEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

  @Query("SELECT p FROM PostEntity p"
      + " WHERE extract(YEAR FROM p.createdAt) = ?1")
  List<PostEntity> findByYear(int year);

  @Query("SELECT p FROM PostEntity p"
      + " WHERE extract(YEAR FROM p.createdAt) = ?1"
      + " AND extract(MONTH FROM p.createdAt) = ?2")
  List<PostEntity> findByYearAndMonth(int year, int month);

  @Query("SELECT p FROM PostEntity p"
      + " WHERE extract(YEAR FROM p.createdAt) = ?1"
      + " AND extract(MONTH FROM p.createdAt) = ?2"
      + " AND extract(DAY FROM p.createdAt) = ?3")
  List<PostEntity> findByYearAndMonthAndDay(int year, int month, int day);

  @Query("SELECT p FROM PostEntity p WHERE p.createdAt = ?1 AND p.slug = ?2")
  Optional<PostEntity> findByDateAndSlug(LocalDate date, String slug);

}
