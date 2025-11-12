package com.javaspring.Tasks14.library.controller;

import com.javaspring.Tasks14.library.entity.Author;
import com.javaspring.Tasks14.library.entity.Book;
import com.javaspring.Tasks14.library.repository.AuthorRepository;
import com.javaspring.Tasks14.library.repository.BookRepository;
import com.javaspring.Tasks14.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;
    private final AuthorRepository repositoryA;
    private final BookRepository repositoryB;

    public AuthorController(AuthorService service, AuthorRepository repositoryA, BookRepository repositoryB) {
        this.service = service;
        this.repositoryA = repositoryA;
        this.repositoryB = repositoryB;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("authors", service.findAll());
        return "authors/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Author author) {
        service.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("author", service.findById(id));
        return "authors/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Author author) {
        author.setId(id);
        service.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/authors";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Author author = repositoryA.findById(id).orElseThrow();
        List<Book> books = repositoryB.findByAuthor(author);
        model.addAttribute("author", author);
        model.addAttribute("books", books);
        return "authors/view";
    }
}