package com.eli.user;

import com.eli.post.post.Post;

import java.util.Collection;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(Long id);

    List<Post> getPostsByUser(User user);
}
