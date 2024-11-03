package com.eli.post.comment;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CommentController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{userId}/posts/{postId}/comments/{commentId}")
    public CommentDTO getCommentByUserIdAndPostIdAndCommentId(
            @PathVariable(name = "userId") Long userId,
            @PathVariable(name = "postId") Long postId,
            @PathVariable(name = "commentId") Long commentId
    ){
        return modelMapper.map(commentService.getCommentByUserIdAndPostIdAndCommentId(userId, postId, commentId), CommentDTO.class);
//        return commentService.getCommentByUserIdAndPostIdAndCommentId(userId, postId, commentId);

    }
}
