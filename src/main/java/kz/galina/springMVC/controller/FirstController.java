package kz.galina.springMVC.controller;

import kz.galina.springMVC.model.Person;
import kz.galina.springMVC.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FirstController {

    private final CalculatorService calculatorService;

    public FirstController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String getInitialPage(@ModelAttribute("person")Person person){
      return "first/login";
    }


    @GetMapping("/hello")
    public String sayHello(Model model){
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodBye(){
        return "first/goodbye";
    }

    @GetMapping ("/calculator")
    public String calculatorPage(){
        return "first/calculator";
    }

    @PostMapping ("/calculator")
    public String calculate(@RequestParam("number1") long number1,
                            @RequestParam("number2") long number2,
                            @RequestParam("action") String action, Model model ){
       double result = calculatorService.calculate(number1, number2, action);
       model.addAttribute("result", result);
       return "first/calculator";
    }
}
