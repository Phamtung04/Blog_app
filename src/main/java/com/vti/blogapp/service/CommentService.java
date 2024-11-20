package com.vti.blogapp.service;

import com.vti.blogapp.DTO.CommentDto;
import com.vti.blogapp.form.CommentCreateFrom;
import com.vti.blogapp.form.CommentFilterForm;
import com.vti.blogapp.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(String id);

    CommentDto create(CommentCreateFrom from, Long postId);

    CommentDto update(CommentUpdateForm from, String id);

    void deleteById(String id);
}
