package com.eli.post;

import com.eli.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts/")
public class PostController {

    private final PostService postService;
    private final ModelMapper modelMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostResponseDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public PostResponseDTO getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostResponseDTO createPost(@RequestBody PostRequestDTO postRequestDTO) {
        return postService.save(modelMapper.map(postRequestDTO, Post.class));
    }


}
