package com.example.assn2.controllers;

import com.example.assn2.models.Rectangle;
import com.example.assn2.models.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RectangleController {
    @Autowired
    private RectangleRepository rectRepo;

    @GetMapping("/rectangles/view")
    public String getRectangles(Model model) {
        List<Rectangle> rectangles = rectRepo.findAll();

        model.addAttribute("rects", rectangles);

        return "viewAll";
    }

    @GetMapping("/rectangles/view/{id}")
    public String getRectangle(Model model, @PathVariable int id) {
        model.addAttribute("rect", rectRepo.findById(id));

        return "viewRectangle";
    }

}
