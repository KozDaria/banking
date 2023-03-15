
package com.example.banking.controllers;

import com.example.banking.model.dto.UserDto;
import com.example.banking.model.entity.User;
import com.example.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

   @GetMapping("/login")
    public String showLoginPage(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("login") != null) {
            return "welcome";
        }
        return "login";
    }

    @GetMapping("/registration")
    public String showRegisrationPage(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {

        HttpSession session = request.getSession();

        return "registration";
    }


    @RequestMapping("/")
    public String checkMVC(HttpServletRequest request){
        return "login";
    }


    @PostMapping("/login")
    public String handleLogin(@ModelAttribute ModelMap model, @RequestParam("login") String login, @RequestParam("password") String password,
                              HttpServletRequest request) {
        logger.info("[handleLogin] username: " + login + " and password: " + password);
        // Get user from database
       User foundUser = userService.validateUser(login, password);
        if (foundUser != null) {

            // If user found, create new session
            HttpSession session = request.getSession();
            session.setAttribute("name", foundUser.getLastName() + " " + foundUser.getName());
            return "welcome";
       }
        model.put("errorMessage", "login_invalid");

        return "login";
    }

    @PostMapping("/registration")
    public String saveNewUser(@ModelAttribute ModelMap model, @RequestParam("name") String name, @RequestParam("lastName") String lastName,
                              @RequestParam("email") String email, @RequestParam("phone") String phone,
                              @RequestParam("login") String login, @RequestParam("password") String password,
                              HttpServletRequest request) {
        logger.info("username: " + name + " lastName: " + lastName + "email " + email +  "phone" + phone +"login" + login+ "password" + password);
        // Get user from database

        User foundUser = userService.findByLogin(login);
        if (foundUser != null) {
            model.put("message", "Пользователь с таким логином уже существует!");
            return "registration";
        }
          
        userService.create(new UserDto(name, lastName, email, login,password,phone));

        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();

        return "redirect:/";
    }

}

