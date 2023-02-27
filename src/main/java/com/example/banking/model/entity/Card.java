package com.example.banking.model.entity;

import com.example.banking.model.enums.CardStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
    Integer number;

    @Column(name = "cvv")
    Integer cvv;

    @OneToOne(cascade = CascadeType.ALL)
    Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    User user;

    String ownerName;

    @Enumerated(EnumType.STRING)
    CardStatus status = CardStatus.CREATED;

}