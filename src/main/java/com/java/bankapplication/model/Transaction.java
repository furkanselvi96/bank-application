package com.java.bankapplication.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "transaction")
@ApiModel(value = "Transaction model documentation", description = "Model")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(value = "Unique id field of user object")
    private Long id;

    @ApiModelProperty(value = "Sender account number")
    private Long sendingAccountId;

    @ApiModelProperty(value = "Receiver account number")
    private Long receivingAccountId;

    @ApiModelProperty(value = "Transfer amount ")
    private Long transactionAmount;

    @ApiModelProperty(value = "Transfer description")
    private String note;

}