package be.bstorm.tf_java2023_springtest.services.impl;

import be.bstorm.tf_java2023_springtest.models.entities.Book;
import be.bstorm.tf_java2023_springtest.repositories.BookRepository;
import be.bstorm.tf_java2023_springtest.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(Book b) {
        return bookRepository.save(b);
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public Book findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public boolean update(Long id, Book b) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
