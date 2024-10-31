package com.eli.post.service;

import com.eli.post.Post;
import com.eli.post.PostResponseDTO;

import java.util.List;

public interface PostService {
    List<PostResponseDTO> getAllPosts();

    PostResponseDTO getPostById(Long id);

    PostResponseDTO save(Post post) ;
}
