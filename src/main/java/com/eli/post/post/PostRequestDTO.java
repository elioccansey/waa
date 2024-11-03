package com.eli.post.post;


import com.eli.post.comment.Comment;
import com.eli.post.comment.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostRequestDTO {
        private Long id;
        private String title;
        private String content;
        private Set<Comment> comments;
}
