package com.example.banking.model.entity;

import com.example.banking.model.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cards")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "valid")
    String valid;

    @Column(name = "number", unique = true)
    String number;

    @Column(name = "cvv")
    String cvv;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "cards_account", joinColumns = {@JoinColumn(name = "CARD_ID",
            referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID",
                    referencedColumnName = "id")})
    List<Account> account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    User user;

    String ownerName;

    @Enumerated(EnumType.STRING)
    CardStatus status = CardStatus.CREATED;

}