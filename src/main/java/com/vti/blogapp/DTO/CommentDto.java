package com.vti.blogapp.DTO;

import com.vti.blogapp.controller.CommentController;
import com.vti.blogapp.controller.PostController;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentCreateFrom;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class CommentDto extends RepresentationModel<CommentDto> {
    private String id;
    private String name;
    private String email;
    private String body;
    private Comment.Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentDto withSelfRel() {
        var controller = methodOn(CommentController.class);
        var dto = controller.findById(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}
