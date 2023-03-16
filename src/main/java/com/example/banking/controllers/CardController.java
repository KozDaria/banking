package com.example.banking.controllers;


import com.example.banking.NumGenerator;
import com.example.banking.model.dto.CardDtoRequest;
import com.example.banking.model.dto.CardDtoResponse;
import com.example.banking.model.enums.CardStatus;
import com.example.banking.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Random;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    @PostMapping("/createCard")
    public String createCard(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("name"));
        NumGenerator numGenerator = new NumGenerator();
        CardDtoRequest cardDtoRequest = cardService.create(new CardDtoRequest("16/25", numGenerator.random(16), numGenerator.random(3), "lenPe", CardStatus.CREATED));
        session.setAttribute("card", cardDtoRequest.getNumber());
        session.setAttribute("valid", cardDtoRequest.getValid());
        ResponseEntity.ok(cardDtoRequest);
        return "createCard";
    }

    @PostMapping("/reissue")
    public ResponseEntity<CardDtoRequest> reissueCard(@RequestParam String reissue_number) {
        return ResponseEntity.ok(cardService.reissue(reissue_number));
    }

    @GetMapping("/getCard")
    public ResponseEntity<CardDtoRequest> getCard(@RequestParam String number) {
        return ResponseEntity.ok(cardService.get(number));
    }

  //  @DeleteMapping("/deleteCard")
    @PostMapping("deleteCard")
    public ResponseEntity<HttpStatus> deleteCard(@RequestParam String delete_number) {
        cardService.delete(delete_number);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/cardToAccount")
    public ResponseEntity<CardDtoResponse> addToAccount(@RequestParam String number, @RequestParam Integer numberAcc) {
        return ResponseEntity.ok(cardService.addToAccount(number, numberAcc));
    }


}