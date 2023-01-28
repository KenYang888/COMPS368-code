/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appfevers.controller;

import com.appfevers.dto.MsgRepository;
import com.appfevers.entities.Msg;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author cyrus
 */
@Controller
public class MsgController {
    
    @Resource
    private MsgRepository _repo;  
    
    @RequestMapping(value={"","/index"}, method=RequestMethod.GET)
    public String index(ModelMap _m){
        _m.addAttribute("msgForm", new MsgForm());
        _m.addAttribute("allMsg", _repo.findAll());
        return "index";
    }

    @RequestMapping(value={"","/index"}, method=RequestMethod.POST)
    public String writeMsg(MsgForm _form, ModelMap _m){
        Msg _msg = new Msg();
        _msg.setuName(_form.getuName());
        _msg.setMsg(_form.getMsg());
        _repo.save(_msg);
        _m.addAttribute("msgForm", new MsgForm());
        _m.addAttribute("allMsg", _repo.findAll());
        return "redirect:index";
    }
    
    @RequestMapping(value={"/del"}, method=RequestMethod.POST)
    public String deleteMsg(@RequestParam(value="delId", required=true) Long _id, ModelMap _m){
        Optional<Msg> _msg = _repo.findById(_id);
        if(_msg != null){
            _repo.delete(_msg.get());
        }
        _m.addAttribute("msgForm", new MsgForm());
        _m.addAttribute("allMsg", _repo.findAll());
        return "redirect:index";
    }
    
    public static class MsgForm{

        private String uName;
        private String msg;

        public String getuName() {
            return uName;
        }

        public void setuName(String uName) {
            this.uName = uName;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    }

}