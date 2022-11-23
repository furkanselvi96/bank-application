package com.java.bankapplication.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "users")
@ApiModel(value = "User model documentation", description = "Model")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(value = "Unique id field of user object")
    private Long id;

    @ApiModelProperty(value = "Firstname field of user object")
    private String name;

    @ApiModelProperty(value = "LastName field of user object")
    private String lastName;

    @ApiModelProperty(value = "Email Address field of user object")
    private String email;

    @Column(name = "tc", nullable = false)
    @ApiModelProperty(value = "Tc Number field of user object")
    private String tc;


}
