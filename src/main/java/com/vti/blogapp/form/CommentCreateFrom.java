package com.vti.blogapp.form;

import com.vti.blogapp.entity.Comment;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentCreateFrom {
    @NotBlank(message = "Tên không được để trống")
    @Length(message = "Tên tối đa 50 ký tự", max = 50)
    private String name;

    @NotBlank(message = "email không được để trống")
    @Length(message = "email tối đa 75 ký tự", max = 75)
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Body không được để trống")
    @Length(message = "Tên tối đa 50 ký tự", max = 50)
    private String body;

    @Pattern(regexp = "REVIEW|OPEN|CLOSED", message = "Status phải là REVIEW, OPEN hoặc là CLOSED")
    private String status;
}
