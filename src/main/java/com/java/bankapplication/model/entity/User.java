package com.java.bankapplication.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;


@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String tcNum;


}
