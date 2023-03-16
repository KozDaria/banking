package com.example.banking.controllers;


import com.example.banking.NumGenerator;
import com.example.banking.model.dto.AccountDtoRequest;
import com.example.banking.model.dto.CardDtoRequest;
import com.example.banking.model.dto.CardDtoResponse;
import com.example.banking.model.enums.CardStatus;
import com.example.banking.services.AccountService;
import com.example.banking.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/createAcc")
    public ResponseEntity<AccountDtoRequest> createAccount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("name"));
        NumGenerator numGenerator = new NumGenerator();
        AccountDtoRequest accountDtoRequest = accountService.create(new AccountDtoRequest(numGenerator.random(20), "lenPe",  "044030655", "GreatBanK", "301"+numGenerator.random(17)));
        session.setAttribute("acc", accountDtoRequest.getNumber());

        return ResponseEntity.ok(accountDtoRequest);
    }

    @GetMapping("/getAcc")
    public ResponseEntity<AccountDtoRequest> getAccount(@RequestParam String number) {
        return ResponseEntity.ok(accountService.get(number));
    }

    @GetMapping("/getAccDet")
    public ResponseEntity<AccountDtoRequest> getAccountDetails(@RequestParam String number) {
        return ResponseEntity.ok(accountService.getAccountDetails(number));
    }

    @DeleteMapping("/deleteAcc")
    public ResponseEntity<HttpStatus> deleteAccount(@RequestParam String delete_number) {
        accountService.delete(delete_number);
        return ResponseEntity.ok().build();
    }


}