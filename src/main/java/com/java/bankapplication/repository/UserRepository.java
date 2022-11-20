package com.java.bankapplication.repository;

import com.java.bankapplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}