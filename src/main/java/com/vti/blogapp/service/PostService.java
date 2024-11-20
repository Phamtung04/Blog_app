package com.vti.blogapp.service;

import com.vti.blogapp.DTO.PostDto;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.form.PostFilterForm;
import com.vti.blogapp.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PostService {
    Page<PostDto> findAll(PostFilterForm form, Pageable pageable);
    Page<PostDto> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
    PostDto findById(Long id);
    PostDto create(PostCreateForm form);
    PostDto update(PostUpdateForm form, Long id);
    void deleteById(Long id);
    void deleteByTitle(String title);
    void deleteByDesc(String description);

}
