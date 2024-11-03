package com.eli.post.post;

import com.eli.post.comment.CommentDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponseDTO {
        private Long id;
        private String title;
        private String content;
        private Set<CommentDTO> comments;
};