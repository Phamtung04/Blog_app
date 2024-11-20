package com.vti.blogapp.repository;

import com.vti.blogapp.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
   // Cách 1: method names
    // findBy, countBy, deteleBy, existBy
    Page<Post> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
    void deleteByTitle(String title);
    // Cách 2: @Query annotation
//    @Query("DELETE FROM Post WHERE description = ?1 AND id = ?2")
//    void deleteByDescAndId(String description, Long id);

  //  @Query("DELETE FROM Post WHERE description = :description")
  //  void deleteByDescAndId(@Param("description") String description);

    @Query(value = "DELETE FROM Post WHERE description = ?1", nativeQuery = true)
    @Modifying
    void deleteByDesc(String description);

    // Chú ý: Khi custoom query làm thay đổi dữ liệu, cần thêm:
    // @Modifying ,@Transactional

}
