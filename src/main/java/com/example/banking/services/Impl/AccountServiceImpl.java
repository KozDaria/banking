package com.example.banking.services.Impl;

import com.example.banking.exceptions.CustomException;
import com.example.banking.model.dto.AccountDtoRequest;
import com.example.banking.model.entity.Account;
import com.example.banking.model.repository.AccountRepository;
import com.example.banking.services.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ObjectMapper mapper;


    @Override
    public AccountDtoRequest create(AccountDtoRequest accountDtoRequest) {
        accountRepository.findByNumber(accountDtoRequest.getNumber()).ifPresent(
                h -> {
                    throw new CustomException("Счёт с таким номером уже существует", HttpStatus.BAD_REQUEST);
                }
        );

        Account account = mapper.convertValue(accountDtoRequest, Account.class);
        Account save = accountRepository.save(account);

        return mapper.convertValue(save, AccountDtoRequest.class);
    }

    @Override
    public AccountDtoRequest get(String number) {
        return mapper.convertValue(getAccount(number), AccountDtoRequest.class);
    }

    @Override
    public AccountDtoRequest getAccountDetails(String number){

        Account account = mapper.convertValue(accountRepository.getAccountByNumber(number), Account.class);
        Account save = accountRepository.save(account);

        return mapper.convertValue(save, AccountDtoRequest.class);
    }

    @Override
    public void delete(String number) {
        Account account = getAccount(number);
        accountRepository.save(account);
    }

    private Account getAccount(String number) {
        return accountRepository.findByNumber(number)
                .orElseThrow(() -> new CustomException("Счёт с таким номером не найден", HttpStatus.NOT_FOUND));
    }




}