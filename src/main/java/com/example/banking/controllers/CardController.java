package com.example.banking.controllers;


import com.example.banking.model.dto.CardDtoRequest;
import com.example.banking.model.dto.CardDtoResponse;
import com.example.banking.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDtoRequest> createCard(@RequestBody CardDtoRequest cardDtoRequest) {
        return ResponseEntity.ok(cardService.create(cardDtoRequest));
    }

    @PutMapping
    public ResponseEntity<CardDtoRequest> reissueCard(@RequestBody CardDtoRequest cardDtoRequest) {
        return ResponseEntity.ok(cardService.reissue(cardDtoRequest));
    }


    @GetMapping
    public ResponseEntity<CardDtoRequest> getCard(@RequestParam Integer number) {
        return ResponseEntity.ok(cardService.get(number));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteCard(@RequestParam Integer number) {

        cardService.delete(number);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/cardToAccount")
    public ResponseEntity<CardDtoResponse> addToAccount(@RequestParam Integer number, @RequestParam Integer numberAcc) {
        return ResponseEntity.ok(cardService.addToAccount(number, numberAcc));
    }

}