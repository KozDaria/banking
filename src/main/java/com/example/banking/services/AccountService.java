package com.example.banking.services;

import com.example.banking.model.dto.AccountDtoRequest;


public interface AccountService {

        AccountDtoRequest create(AccountDtoRequest accountDtoRequest);

        AccountDtoRequest get(String number);

        AccountDtoRequest getAccountDetails(String number);

        void delete(String number);
}
