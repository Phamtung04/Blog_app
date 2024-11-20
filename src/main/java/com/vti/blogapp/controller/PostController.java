package com.vti.blogapp.controller;

import com.vti.blogapp.DTO.PostDto;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.form.PostFilterForm;
import com.vti.blogapp.form.PostUpdateForm;
import com.vti.blogapp.service.PostService;
import com.vti.blogapp.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/api/v1/posts")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        return postService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/posts/title/{title}/{content}")
    public Page<PostDto> findByTitleLikeOrContentLike(@PathVariable("title") String title,@PathVariable("content") String content, Pageable pageable) {
        return postService.findByTitleLikeOrContentLike("%" + title + "%", "%" + content + "%", pageable);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") @PostIdExists Long id) {
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/posts")
    public PostDto create(@Valid @RequestBody PostCreateForm form) {
        return postService.create(form);
    }

    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(@Valid @RequestBody PostUpdateForm form,@PathVariable("id") @PostIdExists Long id) {
        return postService.update(form, id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") @PostIdExists Long id) {
        postService.deleteById(id);
    }

    @DeleteMapping("/api/v1/posts/title/{title}")
    public void deleteByTitle(@PathVariable("title") String title) {
        postService.deleteByTitle(title);
    }

    @DeleteMapping("/api/v1/posts/desc/{description}")
    public void deleteByDesc(@PathVariable("description") String description) {
        postService.deleteByDesc(description);
    }

}
