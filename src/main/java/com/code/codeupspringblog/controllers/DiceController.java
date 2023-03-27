package com.code.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        List<Integer> diceRolls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            diceRolls.add(RandomGenerator.getDefault().nextInt(6) + 1);
        }
        model.addAttribute("results", diceRolls);
        model.addAttribute("guess", guess);
        return "dice";
    }
}
