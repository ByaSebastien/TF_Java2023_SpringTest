package be.bstorm.tf_java2023_springtest.services.impl;

import be.bstorm.tf_java2023_springtest.exceptions.TitleBookException;
import be.bstorm.tf_java2023_springtest.models.entities.Book;
import be.bstorm.tf_java2023_springtest.repositories.BookRepository;
import be.bstorm.tf_java2023_springtest.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(Book b) {
        if(bookRepository.existsByTitle(b.getTitle())){
            throw new TitleBookException();
        }
        return bookRepository.save(b);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean update(Long id, Book b) {
        Optional<Book> potentialBook = bookRepository.findById(id);
        if(potentialBook.isEmpty()){
            return false;
        }
        Book existingBook = potentialBook.get();
        existingBook.setTitle(b.getTitle());
        existingBook.setDescription(b.getDescription());
        bookRepository.save(existingBook);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
