package com.eli.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users JOIN posts on  users.id = posts.user_id", nativeQuery = true)
    List<User> findUserWithMoreThanOnePost();
}

