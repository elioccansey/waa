package com.eli.post.post;

import com.eli.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository
                .findById(id)
                .orElseThrow(()-> new PostNotFoundException("No post with id " + id));
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        this.getPostById(id);
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        this.getPostById(id);
        post.setId(id);
        return postRepository.save(post);
    }

    @Override
    public List<Post> filterPostsByAuthor(String authorName) {
        return postRepository.findByAuthor(authorName);
    }

    @Override
    public List<Post> searchPostsByAuthorNameContaining(String authorName) {
        return postRepository.findByAuthorContaining(authorName);
    }

    @Override
    public List<Post> filterPostsByTitle(String title) {
        return postRepository.findByTitle(title);
    }

}
