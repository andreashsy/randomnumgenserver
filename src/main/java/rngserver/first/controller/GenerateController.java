package rngserver.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rngserver.first.model.Generate;

@Controller
public class GenerateController {

    @GetMapping("/generate")
    public String showGenerateForm(Model model) {
        Generate generate = new Generate();
        // ties to th object on page
        model.addAttribute("generate", generate);
        //ties to page
        return "generate";
    }
}
