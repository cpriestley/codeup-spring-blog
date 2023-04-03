package com.code.codeupspringblog.controllers;

import com.code.codeupspringblog.models.User;
import com.code.codeupspringblog.repositories.UserRepository;
import com.code.codeupspringblog.services.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserRegistrationService userRegistrationService;

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/signup";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        userRegistrationService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/users/{id}/delete")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}
