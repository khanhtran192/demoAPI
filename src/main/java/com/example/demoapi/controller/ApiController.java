package com.example.demoapi.controller;

import com.example.demoapi.dto.PostRequestDTO;
import com.example.demoapi.entity.Post;
import com.example.demoapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class ApiController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> listPost(@RequestParam(value = "keyword", required = true) String keyword){
        return postService.listPost(keyword);
    }

    @GetMapping("/info")
    public Post listPost(@RequestParam(value = "id") Long id){
        return postService.post(id);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody PostRequestDTO post){
        return postService.createPost(post);
    }

    @PutMapping("")
    public ResponseEntity<?> create(@RequestBody PostRequestDTO post, @RequestParam(value = "id") Long id){
        return postService.updatePost(post, id);
    }

    @DeleteMapping("")
    public ResponseEntity<?> create(@RequestParam(value = "id") Long id){
        return postService.deletePost(id);
    }
}
