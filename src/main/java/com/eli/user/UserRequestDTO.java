package com.eli.user;

import com.eli.post.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
    private String name;
    private List<Post> posts;
}
