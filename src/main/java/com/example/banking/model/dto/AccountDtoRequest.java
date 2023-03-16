package com.example.banking.model.dto;

import com.example.banking.model.enums.CardStatus;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDtoRequest {

    String number;

    String name;

    String bic;

    String bank;

    String korAccount;

}