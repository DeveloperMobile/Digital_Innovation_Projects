package com.vittorinoboost.springmvc.controller;

import com.vittorinoboost.springmvc.model.Jedi;
import com.vittorinoboost.springmvc.repository.JediRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class JediController {

    @Autowired
    private JediRepo jediRepo;

    //---------------------------------------------------------------------
    @GetMapping("/jedi")
    public ModelAndView jedi() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", jediRepo.findAll());

        return modelAndView;
    }
    //---------------------------------------------------------------------
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "name") final String name) {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", jediRepo.findByNameContainingIgnoreCase(name));

        return modelAndView;
    }
    //-----------------------------------------------------------------------
    @GetMapping("/new-jedi")
    public ModelAndView newJedi() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");

        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }
    //-----------------------------------------------------------------------
    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()){
            return "new-jedi";
        }

        jediRepo.save(jedi);

        redirectAttributes.addFlashAttribute("message", "Jedi successfully registered");

        return "redirect:jedi";
    }
    //-------------------------------------------------------------------------

    public String deleteJedi(@PathVariable("id") final Long id, Model model) {

        final Optional<Jedi> jedi = jediRepo.findById(id);

        model.addAttribute("jedi", jedi.get());

        return "edit-jedi";
    }
}
