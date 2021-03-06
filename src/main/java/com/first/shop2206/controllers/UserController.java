package com.first.shop2206.controllers;

import com.first.shop2206.model.User;
import com.first.shop2206.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UserController {

    private UserRepository userRepository;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "mainPage";
    }

    @GetMapping("/admin/addUser")
    public String adminAddUser(Model model) {
        return "addUser";
    }

    @GetMapping("/allUsers")
    public String allUsers(Model model) {
        Iterable<User> allUsers = userRepository.findAll();
        model.addAttribute("allUsers", allUsers);
        return "allUsers";
    }

    @PostMapping("/admin/addUser")
    public String adminUserAdd(@RequestParam String username, @RequestParam String password, @RequestParam String e_mail, @RequestParam String phoneNumber, Model model) {
        User user = new User(username,password,e_mail,phoneNumber);
        userRepository.save(user);
        return "redirect:/admin/addUser";}
    @GetMapping("/allUsers/{id}")
    public String allUsersDetails(@PathVariable(value = "id") long id, Model model) {
        if (!userRepository.existsById(id)) {
            return "redirect:/allUsers";
        }
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        return "allUsersDetails";
    }
    @GetMapping("/allUsers/{id}/edit")
    public String allUsersEdit(@PathVariable(value = "id") long id, Model model) {
        if (!userRepository.existsById(id)) {
            return "redirect:/allUsers";
        }
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        return "allUsersEdit";}

    @PostMapping("/allUsers/{id}/edit")
    public String adminUserUpdate(@PathVariable(value = "id") long id, @RequestParam String username, @RequestParam String password, @RequestParam String e_mail, @RequestParam String phoneNumber, Model model) {
        User user= new User(username, password,e_mail,phoneNumber);
        if (!userRepository.existsById(id)) {
            return "redirect:/allUsers";
        }
        User users = userRepository.findById(id).orElseThrow(IllegalStateException::new);
        users.setUsername(username);
        users.setPassword(password);
        users.setE_mail(e_mail);
        users.setPhoneNumber(phoneNumber);
        userRepository.save(users);
        return "redirect:/allUsers";
    }

    @PostMapping("/allUsers/{id}/remove")
    public String adminUserDelete(@PathVariable(value = "id") long id, Model model) {
        User user= userRepository.findById(id).orElseThrow(IllegalStateException::new);
        userRepository.delete(user);
        return "redirect:/allUsers";
    }

    @GetMapping("/basket")
    public String basket(Model model) {
        model.addAttribute("title", "Корзина");
        return "basket";
    }
    @GetMapping("/hello")
    public String securityUrl(){return "helloPage";}
}

