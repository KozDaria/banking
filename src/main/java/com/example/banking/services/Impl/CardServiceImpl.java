package com.example.banking.services.Impl;

import com.example.banking.exceptions.CustomException;
import com.example.banking.model.dto.CardDtoRequest;
import com.example.banking.model.dto.CardDtoResponse;
import com.example.banking.model.entity.Card;
import com.example.banking.model.enums.CardStatus;
import com.example.banking.model.repository.CardRepository;
import com.example.banking.services.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final ObjectMapper mapper;

    @Override
    public CardDtoRequest create(CardDtoRequest cardDtoRequest) {
        cardRepository.findByNumber(cardDtoRequest.getNumber()).ifPresent(
                h -> {
                    throw new CustomException("Карта с таким номером уже существует", HttpStatus.BAD_REQUEST);
                }
        );

        Card card = mapper.convertValue(cardDtoRequest, Card.class);
        Card save = cardRepository.save(card);

        return mapper.convertValue(save, CardDtoRequest.class);
    }

    @Override
    public CardDtoRequest reissue(CardDtoRequest cardDtoRequest) {
        Card card = getCard(cardDtoRequest.getNumber());

        card.setValid(cardDtoRequest.getValid() == null ? card.getValid() : cardDtoRequest.getValid());
        card.setCvv(cardDtoRequest.getCvv() == null ? card.getCvv() : cardDtoRequest.getCvv());
        card.setStatus(CardStatus.VALID);

        return mapper.convertValue(cardRepository.save(card), CardDtoRequest.class);
    }

    @Override
    public CardDtoRequest get(Integer number) {
        return mapper.convertValue(getCard(number), CardDtoRequest.class);
    }

    @Override
    public void delete(Integer number) {
        Card card = getCard(number);
        card.setStatus(CardStatus.DELETED);
        cardRepository.save(card);
    }

    private Card getCard(Integer number) {
        return cardRepository.findByNumber(number)
                .orElseThrow(() -> new CustomException("Карта с таким номером не найдена", HttpStatus.NOT_FOUND));
    }


    @Override
    public CardDtoResponse addToAccount(Integer number, Integer accountNumber) {
//        Account account = accountService.getAccount(accountNumber);
//        Card card = getCard(number);
//        card.setAccount(account);
//        Card save = cardRepository.save(card);
//        CardDtoResponse response = mapper.convertValue(save, CardDtoResponse.class);
//        response.setUserDto(mapper.convertValue(account, UserDto.class));
//        return response;
        return null;
    }


}