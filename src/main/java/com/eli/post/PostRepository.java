package com.eli.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {



//    Post p1 = Post.builder()
//            .id(1L)
//            .title("First post")
//            .author("First Author")
//            .content("Content of the first post")
//            .build();
//
//    Post p2 = Post.builder()
//            .id(2L)
//            .title("Second post")
//            .author("Second Author")
//            .content("Content of the Second post")
//            .build();
//
//    List<Post> posts = new ArrayList<>(Arrays.asList(p1,p2));
//
//    public List<Post> findAll() {
//        return posts;
//    }
//
//    public Post findById(Long id){
//        return posts.stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst()
//                .orElseThrow(()-> new PostNotFoundException(String.format("NOT FOUND : NO POST WITH ID %s ", id)));
//    }
//
//    public Post save(Post post){
//        posts.add(post);
//        return post;
//    }


}
