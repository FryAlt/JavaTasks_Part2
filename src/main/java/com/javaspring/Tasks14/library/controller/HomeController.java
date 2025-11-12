package com.javaspring.Tasks14.library.controller;

import com.javaspring.Tasks14.library.service.AuthorService;
import com.javaspring.Tasks14.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final AuthorService authorService;
    private final BookService bookService;

    public HomeController(AuthorService a, BookService b) {
        this.authorService = a; this.bookService = b;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("books", bookService.findAll());
        return "index";
    }
}