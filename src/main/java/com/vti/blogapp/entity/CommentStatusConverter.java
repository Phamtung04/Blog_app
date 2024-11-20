package com.vti.blogapp.entity;

import jakarta.persistence.AttributeConverter;

public class CommentStatusConverter implements AttributeConverter<Comment.Status, Character> {
    @Override
    public Character convertToDatabaseColumn(Comment.Status status) {
        return status.toString().charAt(0);
    }

    @Override
    public Comment.Status convertToEntityAttribute(Character code) {
        if (code == 'R')  {
            return Comment.Status.REVIEW;
        } else if (code == 'O') {
            return Comment.Status.OPEN;
        } else {
            return Comment.Status.CLOSED;
        }
    }
}
