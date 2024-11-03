package com.eli.post.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {
//    @Query(value = " select comments.id, comments.name from comments join posts on posts.id = comments.post_id join users on users.id = posts.user_id where users.id = :userId and posts.id  = :postId and comments.id = :commentId ", nativeQuery = true)
//    Object[] findCommentByUserIdAndPostIdAndCommentId(
//            @Param("userId") Long userId,
//            @Param("postId") Long postId,
//            @Param("commentId") Long commentId
//    );

    @Query(value = " select c from Comment c join Post p on c.post.id = p.id join User u on u.id = p.user.id where u.id = :userId and p.id  = :postId and c.id = :commentId ")
    Comment findCommentByUserIdAndPostIdAndCommentId(
            @Param("userId") Long userId,
            @Param("postId") Long postId,
            @Param("commentId") Long commentId
    );

}
