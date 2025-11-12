package com.javaspring.Tasks14.library.repository;

import com.javaspring.Tasks14.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {}