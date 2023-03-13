
package com.example.banking.controllers;

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
import java.io.IOException;

@Controller
@RequestMapping("/users")
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
            session.setAttribute("login", foundUser.getLogin());
            return "welcome";
       }
        model.put("errorMessage", "login_invalid");

        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();

        return "redirect:/";
    }

}

