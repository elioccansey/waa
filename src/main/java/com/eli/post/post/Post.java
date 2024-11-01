package com.eli.post.post;

import com.eli.post.comment.Comment;
import com.eli.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;

    @OneToMany()
    @JoinColumn(name = "post_id")
    private Set<Comment> comments;

    @ManyToOne
    private User user;

}
