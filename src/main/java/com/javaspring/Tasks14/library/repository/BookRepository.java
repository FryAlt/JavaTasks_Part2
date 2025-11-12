package com.javaspring.Tasks14.library.repository;

import com.javaspring.Tasks14.library.entity.Author;
import com.javaspring.Tasks14.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(Author author);
}