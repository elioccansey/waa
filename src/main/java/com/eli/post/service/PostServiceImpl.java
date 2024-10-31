package com.eli.post.service;

import com.eli.post.Post;
import com.eli.post.PostRepository;
import com.eli.post.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> modelMapper.map(post, PostResponseDTO.class))
                .toList();
    }

    @Override
    public PostResponseDTO getPostById(Long id) {
        return modelMapper.map(postRepository.findById(id), PostResponseDTO.class);
    }

    @Override
    public PostResponseDTO save(Post post) {
        return modelMapper.map(postRepository.save(post), PostResponseDTO.class);
    }
}
