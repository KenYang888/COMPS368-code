package com.cyrus822.springboot.controllers;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cyrus822.springboot.models.Students;
import com.cyrus822.springboot.repos.StudentsRepo;

@Controller
public class StudentsController {
    
    @Autowired
    private StudentsRepo repo;

    @GetMapping({"","/","/index"})
    public String index(ModelMap m){
        m.addAttribute("allStd", repo.findAll());
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, ModelMap m){
        Optional<Students> std = repo.findById(id);
        if(!std.isPresent()){
            return "redirect:/index";
        }
        m.addAttribute("std", std.get());
        return "detail";
    }    

    @GetMapping("/create")
    public String create(ModelMap m){
        m.addAttribute("newStd", new Students());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("newStd") @Valid Students newStd, BindingResult results, ModelMap m){
        if(results.hasErrors()){
            m.addAttribute("newStd", newStd);
            return "create";
        }
        repo.save(newStd);
        return "create";
    }

    @GetMapping("/udpate/{id}")
    public String update(@PathVariable("id") Integer id, ModelMap m){
        Optional<Students> updStd = repo.findById(id);
        if(!updStd.isPresent()){
            return "redirect:/index";
        }
        m.addAttribute("updStd", updStd.get());
        return "update";
    }

    @PostMapping("/udpate/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("updStd") @Valid Students updStd, BindingResult results, ModelMap m){
        if(results.hasErrors() ||updStd.getId() != id ){
            m.addAttribute("updStd", updStd);
            return "update";
        }
        repo.save(updStd);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Optional<Students> deleteStd = repo.findById(id);
        if(!deleteStd.isPresent()){
            return "redirect:/index";
        }
        repo.deleteById(id);
        return "redirect:/index";
    }
}
