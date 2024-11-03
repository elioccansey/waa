package com.eli.user;

import com.eli.post.post.Post;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(Long id);

    List<Post> getPostsByUser(Long id);

    List<User> getUsersWithMoreThanOnePost();

    void deleteUserById(Long id);

    List<User> getUsersWithMoreThanNPosts(Integer n);

    List<User> findDistinctByPosts_Title(String title);
}
