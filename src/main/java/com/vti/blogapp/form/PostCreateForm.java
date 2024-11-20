package com.vti.blogapp.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostCreateForm {
    @NotBlank(message = "{post.title.NotBlank.message}")
    @Length(message = "{post.title.Length.message}", max = 50)
    private String title;

    @NotBlank(message = "Mô tả bài viết không được để trống")
    @Length(message = "Mô tả bài viết tối đa 100 ký tự", max = 100)
    private String description;

    @NotBlank(message = "Nôi dung bài viết không được để trống")
    @Length(message = "Nôi dung bài viết tối đa 150 ký tự", max = 150)
    private String content;
}
