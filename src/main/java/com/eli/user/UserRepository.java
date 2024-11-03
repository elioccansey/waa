package com.eli.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE size(u.posts) > 1 ")
    List<User> findUserWithMoreThanOnePost();

    @Query(value = "SELECT u FROM User u WHERE size(u.posts) > :n ")
    List<User> findUsersWithMoreThanNPost(@Param("n") Integer i);

    List<User> findDistinctByPosts_Title(String title);
}

