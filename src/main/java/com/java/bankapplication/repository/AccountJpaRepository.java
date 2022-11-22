package com.java.bankapplication.repository;

import com.java.bankapplication.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    @Query
    List<Account> findByUserId(Long userId);

    @Query("select a.id from account a")
    Set<Long> findAllAccountId();

    @Query(value = "select a from account a where a.id = ?1")
    Account findAccountById(Long id);
}