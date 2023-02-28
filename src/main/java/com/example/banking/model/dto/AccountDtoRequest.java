package com.example.banking.model.dto;

import com.example.banking.model.enums.CardStatus;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.math.BigInteger;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDtoRequest {

    Integer number;

    String name;

    Integer bic;

    String bank;

    BigInteger korAccount;

}