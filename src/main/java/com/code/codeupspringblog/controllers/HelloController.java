package com.code.codeupspringblog.controllers;

import com.code.codeupspringblog.models.UserWithRoles;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        UserWithRoles user = (UserWithRoles) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        model.addAttribute("classes", "text-center my-5 rounded-5 shadow-lg border border-1 border-dark py-5 d-none");
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("classes", "text-center my-5 rounded-5 shadow-lg border border-1 border-dark py-5");
        model.addAttribute("cohort", String.format("Welcome to %s", cohort));
        return "join";
    }
}
