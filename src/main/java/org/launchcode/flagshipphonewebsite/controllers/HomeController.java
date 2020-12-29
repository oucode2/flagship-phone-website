package org.launchcode.flagshipphonewebsite.controllers;

import org.dom4j.rule.Mode;
import org.launchcode.flagshipphonewebsite.models.Brand;
import org.launchcode.flagshipphonewebsite.models.data.BrandRepository;
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
import java.util.List;
import java.util.Optional;




@Controller
public class HomeController {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        return "home";
    }

    @GetMapping("admin")
    public String displayAddPhoneForm(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute(new Phone());
        model.addAttribute(new Brand());
        return "admin";
    }

    @PostMapping("admin")
    public String processAddPhoneForm(@ModelAttribute @Valid Phone newPhone, Brand newBrand,
                                      Errors errors, Model model, @RequestParam int brandId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Phone");
            return "admin";
        }

        Optional optBrand = brandRepository.findById(brandId);
        if (optBrand.isPresent()) {
            Brand brand = (Brand) optBrand.get();
            newPhone.setBrand(brand);
            model.addAttribute("brand", brand);
            phoneRepository.save(newPhone);
            return "redirect:";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("viewphone/{phoneId}")
    public String displayViewPhone(Model model, @PathVariable int phoneId, Brand newBrand) {
        model.addAttribute("brands", brandRepository.findAll());

        Optional<?> optPhone = phoneRepository.findById(phoneId);

        if (optPhone.isPresent()) {
            Phone phone = (Phone) optPhone.get();
            model.addAttribute("phone", phone);
            return "viewphone";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("viewbrand/{brandId}")
    public String displayViewBrand(Model model, @PathVariable(value="brandId", required = false) int brandId, Phone newPhone) {
        model.addAttribute("phones", phoneRepository.findByBrandId(brandId));

        return "viewbrand";
        }

    }


