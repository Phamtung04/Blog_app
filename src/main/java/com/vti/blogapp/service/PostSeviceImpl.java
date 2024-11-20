package com.vti.blogapp.service;

import com.vti.blogapp.DTO.PostDto;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.form.PostFilterForm;
import com.vti.blogapp.form.PostUpdateForm;
import com.vti.blogapp.mapper.PostMapper;
import com.vti.blogapp.repository.PostRepository;
import com.vti.blogapp.specification.PostSpecification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostSeviceImpl implements PostService{
    private PostRepository postRepository;

    @Override
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        var spec = PostSpecification.buildSpec(form);
        return postRepository.findAll(spec, pageable).map(PostMapper::map);// lambda, menthod reference
    }

    @Override
    public Page<PostDto> findByTitleLikeOrContentLike(String title, String content, Pageable pageable) {
        return postRepository.findByTitleLikeOrContentLike(title, content, pageable).map(PostMapper::map);
    }

    @Override
    public PostDto findById(Long id) {
        var post = postRepository.findById(id).get();
        return PostMapper.map(post);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savePost = postRepository.save(post);
        return PostMapper.map(savePost);
    }

    @Override
    public PostDto update(PostUpdateForm form, Long id) {
        var post = postRepository.findById(id).get();
        PostMapper.map(form, post);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        postRepository.deleteByTitle(title);
    }

    @Override
    @Transactional
    public void deleteByDesc(String description) {
        postRepository.deleteByDesc(description);
    }
}
