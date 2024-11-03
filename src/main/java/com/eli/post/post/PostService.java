package com.eli.post.post;

import com.eli.user.User;

import java.util.Collection;
import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post createPost(Post post) ;

    void deletePostById(Long id);

    Post updatePost(Long id, Post post);

    List<Post> filterPostsByAuthor(String authorName);

    List<Post> searchPostsByAuthorNameContaining(String authorName);

    List<Post> filterPostsByTitle(String title);
}
