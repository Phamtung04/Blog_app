package com.vti.blogapp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "comment_id_generator", type = CommentIdGenerator.class)
    @GeneratedValue(generator = "comment_id_generator")
    @Column(name = "id")
//    @JdbcType(VarbinaryJdbcType.class)
    private String id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 75, nullable = false)
    private String email;

    @Column(name = "body", length = 100, nullable = false)
    private String body;

    @Column(name = "status", nullable = false)
//    @Enumerated(value = EnumType.STRING)
    @Convert(converter = CommentStatusConverter.class)
    private Status status;

    @Column(name = "created_at",updatable = false , nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    @OneToOne
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public enum Status {
        REVIEW, OPEN, CLOSED
    }

}
