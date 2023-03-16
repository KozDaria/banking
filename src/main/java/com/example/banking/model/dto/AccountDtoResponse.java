package com.example.banking.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDtoResponse extends AccountDtoRequest {

    UserDto userDto;

    CardDtoResponse cardDtoResponse;

}