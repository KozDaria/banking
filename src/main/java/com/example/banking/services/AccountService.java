package com.example.banking.services;

import com.example.banking.model.dto.AccountDtoRequest;


public interface AccountService {

        AccountDtoRequest create(AccountDtoRequest accountDtoRequest);

        AccountDtoRequest get(Integer number);

        AccountDtoRequest getAccountDetails(Integer number);

        void delete(Integer number);
}
