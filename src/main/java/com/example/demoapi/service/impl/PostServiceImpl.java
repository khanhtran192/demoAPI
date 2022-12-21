package com.example.demoapi.service.impl;

import com.example.demoapi.dto.PostRequestDTO;
import com.example.demoapi.dto.ResponseDTO;
import com.example.demoapi.entity.Post;
import com.example.demoapi.repo.PostRepository;
import com.example.demoapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> listPost(String keyword) {
        return postRepository.listPost(keyword);
    }

    @Override
    public ResponseEntity<?> updatePost(PostRequestDTO post, Long id) {
        Post newPost = postRepository.findById(id).get();
        newPost.setContent(post.getContent());
        newPost.setDescription(post.getDescription());
        newPost.setTitle(post.getTitle());
        newPost.setCreateAt(new Date());
        return new ResponseEntity<>(ResponseDTO.builder().message("thanh cong")
                .status(200L)
                .data(newPost)
                .build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO post) {
        Post newPost = Post.builder()
                .content(post.getContent())
                .title(post.getTitle())
                .description(post.getDescription())
                .createAt(new Date())
                .build();
        return new ResponseEntity<>(ResponseDTO.builder().message("thanh cong")
                .status(201L)
                .data(newPost)
                .build(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deletePost(Long id) {
        Post newPost = postRepository.findById(id).get();
        return new ResponseEntity<>(ResponseDTO.builder().message("thanh cong")
                .status(204L)
                .data(newPost)
                .build(), HttpStatus.OK);
    }

    @Override
    public Post post(Long id) {
        return postRepository.findById(id).get();
    }
}
