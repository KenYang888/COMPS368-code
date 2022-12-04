package com.cyrus822.u5.basicweb.controllers;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cyrus822.u5.basicweb.models.Contacts;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/subpath1")
@Slf4j
public class ContactsController {
    @Autowired
    private Contacts bean;

    @GetMapping({"","/","/index"})
    public String testCyrus(ModelMap m){
        if(bean.getEmail() == null || bean.getEmail().isEmpty()){
            Random rand = new Random(System.currentTimeMillis());
            bean.setId(rand.nextInt(100));
            bean.setName("Cyrus");
            bean.setEmail("cyrus@cyrus822.com");
            bean.setPhone("55443544");
        }
        m.addAttribute("thisIsMyModel", bean);
        return "thisIsABC";
    }   
}
