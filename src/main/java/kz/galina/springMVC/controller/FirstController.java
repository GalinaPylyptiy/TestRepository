package kz.galina.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model){

        String greetings = "Hello, " +name + " " + surname;
        model.addAttribute("message", greetings);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodBye(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") long a,
                            @RequestParam("b") long b,
                            @RequestParam("action") String action, Model model ){
       double result = 0;
       switch (action){
           case "multiplication": result=a*b;
           break;
           case "addition":result=a+b;
           break;
           case "subtraction":result=a-b;
           break;
           case "division":result=a/(double) b;
           break;
       }
       model.addAttribute("result", result);
       return "first/calculator";
    }
}
