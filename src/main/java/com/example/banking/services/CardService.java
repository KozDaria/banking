package com.example.banking.services;

import com.example.banking.model.dto.CardDtoRequest;
import com.example.banking.model.dto.CardDtoResponse;

public interface CardService {

        CardDtoRequest create(CardDtoRequest cardDTORequest);

        CardDtoRequest reissue(CardDtoRequest cardDTORequest);

        CardDtoRequest get(Integer number);

        void delete(Integer number);

        CardDtoResponse addToAccount(Integer number, Integer accountNumber);
}
