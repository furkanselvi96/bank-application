package com.java.bankapplication.repository;

import com.java.bankapplication.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    @Query
    List<Account> findByUserId(Long userId);
}