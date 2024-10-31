package com.eli.user.service;

import com.eli.post.PostResponseDTO;

import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String name;
    private List<PostResponseDTO> posts;
}
