package com.eli.post.comment;

import java.util.List;

public interface CommentService {
   Object getCommentByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);
}
