package com.example.bullhornchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/")
    public String listmessages(Model model) {
        model.addAttribute("message", messageRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addmessages(Model model){
            model.addAttribute("message", new Messages());
            return "messageform";
    }

    @PostMapping("/process")
    public String processform(@Valid Messages message, BindingResult result) {
        if(result.hasErrors()) {
            return "messageform";
        }
        messageRepository.save(message);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showmessages(@PathVariable("id") long id, Model model) {
        model.addAttribute("message", messageRepository.findOne(id));
        return "show";
    }

}
