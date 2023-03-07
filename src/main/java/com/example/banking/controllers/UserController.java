
package com.example.banking.controllers;

import com.example.banking.model.entity.User;
import com.example.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    @GetMapping("/login")
    public String showLoginPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            return "welcome";
        }
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(ModelMap model, @RequestParam String username, @RequestParam String password,
                              HttpServletRequest request) {

        logger.info("[handleLogin] username: " + username + " and password: " + password);
        // Get user from database
       User foundUser = userService.validateUser(username, password);
        if (foundUser != null) {

            // If user found, create new session
            HttpSession session = request.getSession();
            session.setAttribute("username", foundUser.getName());
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

