package Rajas.in.Frontend.crud.controller;

import Rajas.in.Frontend.crud.model.user;
import Rajas.in.Frontend.crud.service.UserNotFoundException;
import Rajas.in.Frontend.crud.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.AttributedString;
import java.util.List;

@Controller
public class userController {
    @Autowired
    private userService userService;
//    To list all users.
    @GetMapping("/users")
    public String showUserList(Model model){
        List<user> listUsers = userService.listAll();
        model.addAttribute("listUsers",listUsers);
        return "users";
    }
//    To add new users redirecting to the form page i.e. new.html.
    @GetMapping("/users/new")
    public String showForm(Model model){
        model.addAttribute("user",new user());
        model.addAttribute("pageTitle","New Employee");
        model.addAttribute("pageHeading","Add New Employee");
        model.addAttribute("edit","edit");
        return "new";
    }
//    After clicking on save button and to show user saved successfully msg and redirecting to users list page.
    @PostMapping("/users/save")
    public String saveUser(user user, RedirectAttributes ra){
        userService.save(user);
        ra.addFlashAttribute("Message","Employee has been saved successfully");
        return "redirect:/users";
    }
//    TO edit users and showing the form with user id and pre-filled info.
    @GetMapping("/users/edit/{id}")
    public String editForm(@PathVariable("id")Integer id ,Model model ,RedirectAttributes ra){
        try {
            user user = userService.get(id);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Edit Employee");
            model.addAttribute("pageHeading","Edit Employee, Id: "+id);

//            model.addAttribute("disableSecondButton",true );
            return "new";


        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("Message","Employee has been saved successfully");
            return "redirect:/users";
        }
    }

//    To delete a user by id.
    @GetMapping("/users/delete/{id}")
        public String deleteForm(@PathVariable("id")Integer id , RedirectAttributes ra){
        user user = userService.delete(id);
        ra.addFlashAttribute("Message","Employee with Id: "+id+" been deleted successfully");
        return "redirect:/users";

    }
    @GetMapping("/about")
    public String  aboutPage(){

        return "about";
    }



}
