package com.example.banking.model.repository;

import com.example.banking.model.entity.Account;
import com.example.banking.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByNumber(Integer number);

    List<Account> findAllByOwnerName(String ownerName);

    @Query("select number, name, bic, bank, korAccount from Account where number =:numberAcc")
    Optional<Account> getAccountByNumber(@Param("number") Integer numberAcc);

}
