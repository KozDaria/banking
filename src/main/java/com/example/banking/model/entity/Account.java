package com.example.banking.model.entity;

import com.example.banking.model.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "all_accounts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "account_number", unique = true, nullable = false)
    String number;

    @Column(name = "person")
    String name;

    @Column(name = "bic")
    String bic;

    @Column(name = "bank")
    String bank;

    @Column(name = "kor_account")
    String korAccount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "cards_account", joinColumns = {@JoinColumn(name = "CARD_ID",
            referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID",
                    referencedColumnName = "id")})
    List<Card> cards;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    User user;

}
