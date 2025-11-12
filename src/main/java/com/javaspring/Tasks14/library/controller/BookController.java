package com.javaspring.Tasks14.library.controller;

import com.javaspring.Tasks14.library.entity.Book;
import com.javaspring.Tasks14.library.service.AuthorService;
import com.javaspring.Tasks14.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService service;
    private final AuthorService serviceA;

    public BookController(BookService service, AuthorService serviceA) {
        this.service = service;
        this.serviceA = serviceA;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", service.findAll());
        return "books/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", serviceA.findAll());
        return "books/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        service.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.findById(id));
        model.addAttribute("authors", serviceA.findAll());
        return "books/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id);
        service.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.findById(id));
        return "books/view";
    }
}