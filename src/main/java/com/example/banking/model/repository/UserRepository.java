package com.example.banking.model.repository;

import com.example.banking.model.entity.Card;
import com.example.banking.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Optional;

@Repository

public interface   UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}