package com.example.banking.controllers;


import com.example.banking.model.dto.AccountDtoRequest;
import com.example.banking.model.dto.CardDtoRequest;
import com.example.banking.model.dto.CardDtoResponse;
import com.example.banking.services.AccountService;
import com.example.banking.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/createAcc")
    public ResponseEntity<AccountDtoRequest> createAccount(@RequestBody AccountDtoRequest accountDtoRequest) {
        return ResponseEntity.ok(accountService.create(accountDtoRequest));
    }

    @GetMapping("/getAcc")
    public ResponseEntity<AccountDtoRequest> getAccount(@RequestParam Integer number) {
        return ResponseEntity.ok(accountService.get(number));
    }

    @GetMapping("/getAccDet")
    public ResponseEntity<AccountDtoRequest> getAccountDetails(@RequestParam Integer number) {
        return ResponseEntity.ok(accountService.getAccountDetails(number));
    }

    @DeleteMapping("/deleteAcc")
    public ResponseEntity<HttpStatus> deleteAccount(@RequestParam Integer number) {
        accountService.delete(number);
        return ResponseEntity.ok().build();
    }


}