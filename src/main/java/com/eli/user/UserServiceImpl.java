package com.eli.user;

import com.eli.post.post.Post;
import com.eli.post.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with ID " + id));
    }

    @Override
    public List<Post> getPostsByUser(Long id) {
        return userRepository.findById(id).map(User::getPosts).orElseThrow(()->new UserNotFoundException("User not found with ID " + id));
    }

    @Override
    public List<User> getUsersWithMoreThanOnePost() {
        return userRepository.findUserWithMoreThanOnePost();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersWithMoreThanNPosts(Integer n) {
        return userRepository.findUsersWithMoreThanNPost(n);
    }

    @Override
    public List<User> findDistinctByPosts_Title(String title) {
        return userRepository.findDistinctByPosts_Title(title);
    }
}

