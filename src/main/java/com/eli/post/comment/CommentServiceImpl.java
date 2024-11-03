package com.eli.post.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Override
    public Comment getCommentByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId) {
        return commentRepository.findCommentByUserIdAndPostIdAndCommentId(userId, postId, commentId);


//        var obj = commentRepository.findCommentByUserIdAndPostIdAndCommentId(userId, postId, commentId);
//        System.out.println(obj.getClass().getSimpleName());
//        return (CommentDTO) obj[0];
    }
}
