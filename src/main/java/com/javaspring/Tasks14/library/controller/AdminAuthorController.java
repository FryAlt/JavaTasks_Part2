package com.javaspring.Tasks14.library.controller;

import com.javaspring.Tasks14.library.entity.Author;
import com.javaspring.Tasks14.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/authors")
public class AdminAuthorController {

    private final AuthorService service;

    public AdminAuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("authors", service.findAll());
        return "admin/authors/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("author", new Author());
        return "admin/authors/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Author author) {
        service.save(author);
        return "redirect:/admin/authors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("author", service.findById(id));
        return "admin/authors/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Author author) {
        author.setId(id);
        service.save(author);
        return "redirect:/admin/authors";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin/authors";
    }
}