package com.vti.blogapp.mapper;

import com.vti.blogapp.DTO.CommentDto;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentCreateFrom;
import com.vti.blogapp.form.CommentUpdateForm;

public class CommentMaper {
    public static Comment map(CommentCreateFrom from) {
        var comment = new Comment();
        comment.setName(from.getName());
        comment.setEmail(from.getEmail());
        comment.setBody(from.getBody());
        comment.setStatus(from.getStatus());
        return comment;
    }

    public static CommentDto map(Comment conment) {
        var dto = new CommentDto();
        dto.setId(conment.getId());
        dto.setName(conment.getName());
        dto.setEmail(conment.getEmail());
        dto.setBody(conment.getBody());
        dto.setStatus(conment.getStatus());
        dto.setUpdatedAt(conment.getUpdatedAt());
        dto.setCreatedAt(conment.getCreatedAt());
        return dto.withSelfRel();
    }

    public static void map(CommentUpdateForm form, Comment comment) {
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        comment.setStatus(form.getStatus());
    }
}
