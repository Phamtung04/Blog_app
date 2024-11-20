package com.vti.blogapp.service;

import com.vti.blogapp.DTO.CommentDto;
import com.vti.blogapp.form.CommentCreateFrom;
import com.vti.blogapp.form.CommentFilterForm;
import com.vti.blogapp.form.CommentUpdateForm;
import com.vti.blogapp.mapper.CommentMaper;
import com.vti.blogapp.repository.CommentRepository;
import com.vti.blogapp.repository.PostRepository;
import com.vti.blogapp.specification.CommentSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServicelmpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Override
    public Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable) {
        var spec = CommentSpecification.buildSpec(form);
        return commentRepository.findAll(spec, pageable).map(CommentMaper::map);
    }

    @Override
    public Page<CommentDto> findByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable).map(CommentMaper::map);
    }

    @Override
    public CommentDto findById(String id) {
        var comment = commentRepository.findById(id).get();
        return CommentMaper.map(comment);
    }

    @Override
    public CommentDto create(CommentCreateFrom from, Long postId) {
        var comment = CommentMaper.map(from);
        var post = postRepository.findById(postId).get();
        comment.setPost(post);
        var saveComment = commentRepository.save(comment);
        return CommentMaper.map(saveComment);
    }

    @Override
    public CommentDto update(CommentUpdateForm form, String id) {
        var comment =  commentRepository.findById(id).get();
        CommentMaper.map(form, comment);
        var savedComment = commentRepository.save(comment);
        return CommentMaper.map(savedComment);
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }
}
