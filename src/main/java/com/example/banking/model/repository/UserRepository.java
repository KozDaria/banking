package com.example.banking.model.repository;

import com.example.banking.model.entity.Account;
import com.example.banking.model.entity.User;
import com.example.banking.model.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class  UserRepository{
    @PersistenceContext
    EntityManager entityManager;

    String findUserByNameQuery = "from User WHERE name=?1";

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public User findByUsername(String username) {
        try {
            TypedQuery<User> tq = entityManager.createQuery(findUserByNameQuery, User.class);
            User user = tq.setParameter(1, username).getSingleResult();
            return user;
        } catch (NoResultException noresult) {
            // if there is no result
        } catch (NonUniqueResultException notUnique) {
            // if more than one result
        }

        return null;
    }

}