
package com.example.banking.controllers;

import com.example.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    @GetMapping("/check")
    public String showLoginPage(HttpServletRequest request) {

//        HttpSession session = request.getSession();
//       System.out.println(session.getAttributeNames());
//        if (session.getAttribute("login") != null) {
//            return "welcome";
//        }
//        return "login";
        return null;
    }



//    @PostMapping("/login")
//    public String handleLogin(ModelMap model, @RequestParam String login, @RequestParam String password,
//                              HttpServletRequest request) {
//       System.out.println(login +" qqqq "+password);
//        logger.info("[handleLogin] username: " + login + " and password: " + password);
//        // Get user from database
//       User foundUser = userService.validateUser(login, password);
//        if (foundUser != null) {
//
//            // If user found, create new session
//            HttpSession session = request.getSession();
//            session.setAttribute("login", foundUser.getLogin());
//            return "welcome";
//       }
//        model.put("errorMessage", "login_invalid");
//
//        return "login";
//    }

//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        request.getSession().invalidate();
//
//        return "redirect:/";
//    }

}

