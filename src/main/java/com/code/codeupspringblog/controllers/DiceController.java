package com.code.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.random.RandomGenerator;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable String guess, Model model) {
        int result = RandomGenerator.getDefault().nextInt(6) + 1;
        model.addAttribute("result", result);
        model.addAttribute("guess", guess);
        return "dice";
    }
}
