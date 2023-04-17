package com.spring.template.controller;

import com.spring.template.service.UserNotFoundException;
import com.spring.template.service.UserService;
import com.spring.template.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RestController
@Controller
class Controllers {
    @Autowired
    private UserService userService;
    @GetMapping("")
        public String showHomePage(){
        System.out.println("main controller");
        return "index";
        }
    @GetMapping("/users")
    @ModelAttribute
    public String showUserList(Model model){
        List<User> listUsers = userService.getAllData();
        model.addAttribute("listUsers",listUsers);
        return "users";
    }
    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add New User");
        return "user_form";
    }
    @PostMapping("/save")
    public String saveUser(User user,RedirectAttributes redirectAttributes){
        userService.save(user);
        redirectAttributes.addFlashAttribute("message","The user have been save successfully.");
        return "redirect:/users";
    }
  @GetMapping("/users/edit/{id}")
    public  String showEditForm(@PathVariable("id") Integer id,Model model,RedirectAttributes redirectAttributes) {
      try {
          User user = userService.get(id);
          model.addAttribute("user", user);
          model.addAttribute("pageTitle", "Edit user(ID: " + id + " )");
          return "user_form";
      } catch (UserNotFoundException e) {
          redirectAttributes.addFlashAttribute("message", e.getMessage());
          return "redirect:/users";
      }
  }
      @GetMapping ("/users/delete/{id}")
      public  String deleteUser(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
          try {
              userService.delete(id);
              redirectAttributes.addFlashAttribute("messagedel","One Row Is Deleled.");
              return "redirect:/users";
          } catch (UserNotFoundException e) {
              throw new RuntimeException(e);
          }

  }


}
