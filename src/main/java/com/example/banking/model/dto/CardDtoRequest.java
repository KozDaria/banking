package com.example.banking.model.dto;

import com.example.banking.model.enums.CardStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardDtoRequest {

    String valid;

    String number;

    String cvv;

    String ownerName;

    CardStatus status;

}