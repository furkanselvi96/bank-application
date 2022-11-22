package com.java.bankapplication.repository;

import com.java.bankapplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query
    User findUserById(Long id);

    @Query("select u.id from users u")
    Set<Long> findAllUserId();
    }