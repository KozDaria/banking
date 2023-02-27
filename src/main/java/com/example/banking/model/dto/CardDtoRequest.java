package com.example.banking.model.dto;

import com.example.banking.model.enums.CardStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardDtoRequest {

    String valid;

    Integer number;

    Integer cvv;

    String ownerName;

    CardStatus status;

}