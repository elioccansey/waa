package com.eli.user;

import com.eli.post.post.PostRepository;
import com.eli.post.post.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

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
        return userService.getPostsByUser(id)
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("more-than-one")
    public List<UserResponseDTO> getUsersWithMoreThanOnePost(){
        return userService.getUsersWithMoreThanOnePost()
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .toList();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("posts/more-than/{n}")
    public ResponseEntity<List<UserResponseDTO>> getUsersWithMoreThanNPosts(@PathVariable Integer n){
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.getUsersWithMoreThanNPosts(n)
                        .stream()
                        .map(user -> modelMapper.map(user, UserResponseDTO.class))
                        .toList()
        );
    }

    @GetMapping("posts")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDTO> findDistinctByPosts_Title(@RequestParam String title){
        return userService.findDistinctByPosts_Title(title)
                .stream().map(user -> modelMapper.map(user, UserResponseDTO.class)).toList();
    }
}
