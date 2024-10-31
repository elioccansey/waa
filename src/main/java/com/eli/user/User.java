package com.eli.user;

import com.eli.post.Post;
import jakarta.persistence.*;

import java.util.List;

@Entity()
@Table(name="users")
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany()
    private List<Post> posts;
}
