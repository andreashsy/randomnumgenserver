package rngserver.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import rngserver.first.model.Generate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class GenerateController {
    private Logger logger = LoggerFactory.getLogger(GenerateController.class);

    @GetMapping("/")
    public String showGenerateForm(Model model) {
        Generate generate = new Generate();
        // ties to the object on html page, name of object and object itself
        model.addAttribute("generateObj", generate);
        //ties to page
        return "generate";
    }

// This function handles when the submission button is pressed
// @ModelAttribute returns the model associated with the form

    @PostMapping("/generate")
    public String generateNumbers(@ModelAttribute Generate generate, Model model) {
        logger.info("From the form: " + generate.getNumberVal());
        int numberRandomNumbers = generate.getNumberVal();
        if (numberRandomNumbers > 30) {
            model.addAttribute("errorMsg", "Exceeded max number");
            return "error";
        }
        String[] imgNumbers = {"number1.jpg", "number2.jpg", "number3.jpg", "number4.jpg", "number5.jpg", "number6.jpg", 
        "number7.jpg", "number8.jpg", "number9.jpg", "number10.jpg", "number11.jpg", "number12.jpg", "number13.jpg", 
        "number14.jpg", "number15.jpg", "number16.jpg", "number17.jpg", "number18.jpg", "number19.jpg", "number20.jpg", 
        "number21.jpg", "number22.jpg", "number23.jpg", "number24.jpg", "number25.jpg", "number26.jpg", "number27.jpg", 
        "number28.jpg", "number29.jpg", "number30.jpg"};
        List<String> selectedImg = new ArrayList<String>();
        Random randNum = new Random();
        Set<Integer> uniqueGeneratedRandNumSet = new LinkedHashSet<Integer>();
        while (uniqueGeneratedRandNumSet.size() < numberRandomNumbers) {
            Integer resultOfRandNumbers = randNum.nextInt(30); // generate.getNumberVal() 
            uniqueGeneratedRandNumSet.add(resultOfRandNumbers);
        }
        Iterator<Integer> it = uniqueGeneratedRandNumSet.iterator();
        Integer currentElem = null;
        while (it.hasNext()) {
            currentElem = it.next();
            logger.info("current element > " + currentElem);
            selectedImg.add(imgNumbers[currentElem.intValue()]);
        }
        model.addAttribute("randNumsResult", selectedImg.toArray());
        model.addAttribute("numRandNum", numberRandomNumbers);
        return "result";
    }

}
