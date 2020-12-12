package org.launchcode.flagshipphonewebsite.controllers;

import org.launchcode.flagshipphonewebsite.models.data.PhoneRepository;
import org.launchcode.flagshipphonewebsite.models.data.UserRepository;
import org.launchcode.flagshipphonewebsite.models.Phone;
//import org.launchcode.flagshipphonewebsite.models.data.UserRepository;
//import org.launchcode.flagshipphonewebsite.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;



@Controller
public class HomeController {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("apple")
    public String a(Model model) {
        model.addAttribute("phones", phoneRepository.findAll());
        return "apple";
    }

    @RequestMapping("samsung")
    public String s (Model model) {

        model.addAttribute("phones", phoneRepository.findAll());
        return "samsung";
    }

    @RequestMapping("lg")
    public String l(Model model){
        model.addAttribute("phones", phoneRepository.findAll());
        return "lg";
    }

    @RequestMapping("motorola")
    public String m(Model model){
        model.addAttribute("phones", phoneRepository.findAll());
        return "motorola";
    }

    @RequestMapping("oneplus")
    public String o(Model model){
        model.addAttribute("phones", phoneRepository.findAll());
        return "oneplus";
    }

    @RequestMapping("google")
    public String g(Model model){
        model.addAttribute("phones", phoneRepository.findAll());
        return "google";
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "home";
    }

    @GetMapping("admin")
    public String displayAddPhoneForm(Model model) {
        model.addAttribute(new Phone());
        return "admin";
    }

    @PostMapping("admin")
    public String processAddPhoneForm(@ModelAttribute @Valid Phone newPhone,
                                    Errors errors) {

        if (errors.hasErrors()) {
            return "admin";
        }

        phoneRepository.save(newPhone);
        return "redirect:";
    }

    @GetMapping("view/{phoneId}")
    public String displayViewPhone(Model model, @PathVariable int phoneId) {

        Optional<?> optPhone = phoneRepository.findById(phoneId);
        if (!optPhone.isEmpty()) {
            Phone phone = (Phone) optPhone.get();
            model.addAttribute("phone", phone);
            return "view";
        } else {
            return "redirect:/";
        }
    }


}

