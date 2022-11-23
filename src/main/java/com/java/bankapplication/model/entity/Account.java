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
@Entity(name = "account")
@ApiModel(value = "Account model documentation", description = "Model")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    @ApiModelProperty(value = "Unique id field of account object")
    private Long Id;

    @ApiModelProperty(value = "Money balance field of account object")
    private Long balance;

    @ApiModelProperty(value = "Money currency field of account object")
    private String currency;

    @Column(name = "ref_user_id", nullable = false)
    @ApiModelProperty(value = "Reference user id field of account object")
    private Long userId;

}
