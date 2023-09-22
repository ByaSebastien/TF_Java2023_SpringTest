package be.bstorm.tf_java2023_springtest.services;

import be.bstorm.tf_java2023_springtest.models.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book add(Book b);

    Book findById(Long id);

    Book findByTitle(String title);

    List<Book> findAll();

    boolean update(Long id, Book b);

    boolean delete(Long id);
}
