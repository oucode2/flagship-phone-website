package org.launchcode.flagshipphonewebsite.controllers;

import org.launchcode.flagshipphonewebsite.models.Phone;
import org.launchcode.flagshipphonewebsite.models.PhoneData;
import org.launchcode.flagshipphonewebsite.models.data.PhoneRepository;
import org.launchcode.flagshipphonewebsite.models.data.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private BrandRepository brandRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController() {

        columnChoices.put("all", "All");
        columnChoices.put("brand", "Brand Name");
        columnChoices.put("model", "Model");
        columnChoices.put("price", "Price");
        }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("phones",phoneRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "phones")
    public String listPhonesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        
        Iterable<Phone> phones;
        if (column.toLowerCase().equals("all")){
            phones = phoneRepository.findAll();
            model.addAttribute("title", "All Phones");
        } else {
            phones = PhoneData.findByColumnAndValue(column, value, phoneRepository.findAll());
            model.addAttribute("title", "phones with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("phones", phones);

        return "list-phones";
    }
}
