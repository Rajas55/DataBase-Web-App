package Rajas.in.Frontend.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
//    Home page controller redirecting to index.html
    @GetMapping("/")
    public String showHomePage(){
         return "index";

    }
}
