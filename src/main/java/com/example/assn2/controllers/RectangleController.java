package com.example.assn2.controllers;

import com.example.assn2.models.Rectangle;
import com.example.assn2.models.RectangleRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        model.addAttribute("rect", rectRepo.findById(id).get());

        return "viewRectangle";
    }

    @PostMapping("/rectangles/add")
    public String addRectangle(@RequestParam Map<String, String> new_rect, HttpServletResponse response) {
        String new_name = new_rect.get("name");
        String new_colour = new_rect.get("colour");
        int new_width = Integer.parseInt(new_rect.get("width"));
        int new_height = Integer.parseInt(new_rect.get("height"));
        rectRepo.save(new Rectangle(new_name, new_colour, new_width, new_height));
        response.setStatus(HttpServletResponse.SC_CREATED);
        return "redirect:/rectangles/view";
    }

    @PostMapping("/rectangles/delete")
    public String deleteRectangle(@RequestParam Map<String, String> to_remove, HttpServletResponse response) {
        rectRepo.findById(Integer.parseInt(to_remove.get("id"))).ifPresent(rectRepo::delete);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return "redirect:/rectangles/view";
    }

    @PostMapping("/rectangles/update")
    public String updateRectangle(@RequestParam Map<String, String> new_data, HttpServletResponse response) {
        Rectangle to_update = rectRepo.findById(Integer.parseInt(new_data.get("id"))).get();
        to_update.setName(new_data.get("name"));
        to_update.setColour(new_data.get("colour"));
        to_update.setWidth(Integer.parseInt(new_data.get("width")));
        to_update.setHeight(Integer.parseInt(new_data.get("height")));
        rectRepo.save(to_update);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return "redirect:/rectangles/view/"+to_update.getId();
    }

}
