package com.example.demoapi.repo;

import com.example.demoapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT p" +
            " FROM Post p " +
            "WHERE " +
            "(:keyword) IS NULL OR p.content LIKE CONCAT('%',:keyword,'%') " +
            "OR (:keyword) IS NULL OR p.description LIKE CONCAT('%',:keyword,'%') " +
            "OR (:keyword) IS NULL OR p.title LIKE CONCAT('%',:keyword,'%') ")
    List<Post> listPost(@Param("keyword") String keyword);

}
