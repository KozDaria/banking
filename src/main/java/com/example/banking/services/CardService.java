package com.example.banking.services;

import com.example.banking.model.dto.CardDtoRequest;
import com.example.banking.model.dto.CardDtoResponse;

public interface CardService {

        CardDtoRequest create(CardDtoRequest cardDTORequest);

        CardDtoRequest reissue(String number);

        CardDtoRequest get(String number);

        void delete(String number);

        CardDtoResponse addToAccount(String number, Integer accountNumber);
}
