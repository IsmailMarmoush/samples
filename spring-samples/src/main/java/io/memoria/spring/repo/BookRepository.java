package io.memoria.spring.repo;

import io.memoria.spring.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
  List<Book> findByTitle(String title);
}