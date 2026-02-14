package com.example.tasca_avaluacio.controller.web;

import com.example.tasca_avaluacio.service.ConflictService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/conflicts")
public class ConflictWebController {
     private final ConflictService conflictService;

    public ConflictWebController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public String listConflicts(Model model) {
        model.addAttribute("conflicts", conflictService.getAllConflicts());
        return "conflicts/list";
    }
}
