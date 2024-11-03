package com.eli.post.post;

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
        return postService.getAllPosts()
                .stream()
                .map(post -> modelMapper.map(post, PostResponseDTO.class))
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public PostResponseDTO getPostById(@PathVariable Long id){
        return modelMapper.map(postService.getPostById(id), PostResponseDTO.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostResponseDTO createPost(@RequestBody PostRequestDTO postRequestDTO) {
        Post post =  postService.createPost(modelMapper.map(postRequestDTO, Post.class));
        return modelMapper.map(post, PostResponseDTO.class);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("{id}")
    public PostResponseDTO updatePost(@PathVariable Long id, @RequestBody PostRequestDTO postRequestDTO){
        Post post =  modelMapper.map(postRequestDTO, Post.class);
        return modelMapper.map(postService.updatePost(id, post), PostResponseDTO.class);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter")
    public List<PostResponseDTO> filterPostsByAuthor(@RequestParam(name = "author") String authorName){
        return postService.filterPostsByAuthor(authorName)
                .stream().map(p -> modelMapper.map(p, PostResponseDTO.class))
                .toList();
    }

    @GetMapping("filter/title")
    public List<PostResponseDTO> filterPostsByTitle(@RequestParam(name = "title") String title){
        return postService.filterPostsByTitle(title).stream()
                .map( p -> modelMapper.map(p, PostResponseDTO.class))
                .toList();
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<PostResponseDTO> searchPostsByAuthorNameContaining(@RequestParam(name = "author") String author){
        return postService.searchPostsByAuthorNameContaining(author)
                .stream()
                .map(post -> modelMapper.map(post, PostResponseDTO.class))
                .toList();
    }


}
