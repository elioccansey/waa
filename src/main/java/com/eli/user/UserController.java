package com.eli.user;

import com.eli.post.post.Post;
import com.eli.post.post.PostRepository;
import com.eli.post.post.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers()
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .toList();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUserById(@PathVariable Long id){
        return modelMapper.map(userService.getUserById(id), UserResponseDTO.class);
    }

    @GetMapping("{id}/posts")
    public List<PostResponseDTO> getPostsByUserId(@PathVariable Long id){
        User user = userService.getUserById(id);
        return postRepository.findByUser(user)
                .stream()
                .map(post -> modelMapper.map(post, PostResponseDTO.class))
                .toList();

    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        var createdUser = userService.createUser(modelMapper.map(userRequestDTO, User.class));
        return modelMapper.map(createdUser, UserResponseDTO.class);
    }


}
