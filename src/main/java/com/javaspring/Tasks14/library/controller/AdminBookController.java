package com.javaspring.Tasks14.library.controller;

import com.javaspring.Tasks14.library.entity.Book;
import com.javaspring.Tasks14.library.service.AuthorService;
import com.javaspring.Tasks14.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/books")
public class AdminBookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public AdminBookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "admin/books/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAll());
        return "admin/books/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("authors", authorService.findAll());
        return "admin/books/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.save(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/admin/books";
    }
}