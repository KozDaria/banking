package com.example.banking.services.Impl;

import com.example.banking.model.dto.UserDto;
import com.example.banking.model.entity.User;
import com.example.banking.model.repository.UserRepository;
import com.example.banking.services.PasswordService;
import com.example.banking.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordService pwService;

    private final ObjectMapper mapper;

    @PersistenceContext
    EntityManager entityManager;

    String findUserByNameQuery = "from User WHERE name=?1";

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }
@Override
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
    @Override
    public UserDto create(UserDto userDTO) {
        User user = mapper.convertValue(userDTO, User.class);
        user.setPassword(PasswordService.encodes(user.getPassword()));

        return mapper.convertValue(userRepository.save(user), UserDto.class);
    }
    @Override
    public User validateUser(String username, String password) {
        User user = findByUsername(username);
        System.out.println(user);
        if (user != null) {
            if (pwService.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

}