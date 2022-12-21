package com.example.demoapi.service;

import com.example.demoapi.dto.PostRequestDTO;
import com.example.demoapi.entity.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> listPost(String keyword);
    ResponseEntity<?> updatePost(PostRequestDTO post,  Long id);
    ResponseEntity<?> createPost(PostRequestDTO post);
    ResponseEntity<?> deletePost(Long id);

    Post post(Long id);

}
