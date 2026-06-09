package com.example.auth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Google OAuth Login";
    }

    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal OAuth2User principal) {

        if (principal == null) {
            return "User not authenticated";
        }

        String email = principal.getAttribute("email");

        if (email == null) {
            return "Email not available. Attributes: " + principal.getAttributes();
        }

        return "Welcome " + email;
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "Logged out successfully. Please sign in again.";
    }
}