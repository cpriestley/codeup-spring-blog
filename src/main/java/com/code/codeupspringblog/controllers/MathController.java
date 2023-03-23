package com.code.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{lhs}/and/{rhs}")
    @ResponseBody
    public float add(@PathVariable float lhs, @PathVariable float rhs) {
        return lhs + rhs;
    }

    @GetMapping("/subtract/{lhs}/from/{rhs}")
    @ResponseBody
    public float subtract(@PathVariable float lhs, @PathVariable float rhs) {
        return lhs - rhs;
    }

    @GetMapping("/multiply/{lhs}/and/{rhs}")
    @ResponseBody
    public float multiply(@PathVariable float lhs, @PathVariable float rhs) {
        return lhs * rhs;
    }

    @GetMapping("/divide/{lhs}/by/{rhs}")
    @ResponseBody
    public float divide(@PathVariable float lhs, @PathVariable float rhs) {
        return lhs / rhs;
    }

}
