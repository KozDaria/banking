package com.example.banking.controllers;


import com.example.banking.model.dto.CardDtoRequest;
import com.example.banking.model.dto.CardDtoResponse;
import com.example.banking.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/houses")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDtoRequest> createCard(@RequestBody CardDtoRequest CardDtoRequest) {
        return ResponseEntity.ok(cardService.create(CardDtoRequest));
    }

    @PutMapping
    public ResponseEntity<CardDtoRequest> reissueCard(@RequestBody CardDtoRequest CardDtoRequest) {
        return ResponseEntity.ok(cardService.reissue(CardDtoRequest));
    }


    @GetMapping
    public ResponseEntity<CardDtoRequest> getCard(@RequestParam Integer number) {
        return ResponseEntity.ok(cardService.get(number));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteHouse(@RequestParam Integer number) {

        cardService.delete(number);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/cardToOwner")
    public ResponseEntity<CardDtoResponse> addToUser(@RequestParam String name, @RequestParam String email) {
        return ResponseEntity.ok(cardService.addToUser(name, email));
    }

}