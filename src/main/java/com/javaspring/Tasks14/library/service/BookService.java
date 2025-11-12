package com.javaspring.Tasks14.library.service;

import com.javaspring.Tasks14.library.entity.Book;
import com.javaspring.Tasks14.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) { this.repo = repo; }

    public List<Book> findAll() { return repo.findAll(); }
    public Book findById(Long id) { return repo.findById(id).orElse(null); }
    public Book save(Book b) { return repo.save(b); }
    public void delete(Long id) { repo.deleteById(id); }
}