package com.eli.post.post;

import com.eli.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(String author);
    List<Post> findByAuthorContaining(String text);
    List<Post> findByUser(User user);


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
