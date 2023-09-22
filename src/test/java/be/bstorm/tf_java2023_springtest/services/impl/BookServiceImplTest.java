package be.bstorm.tf_java2023_springtest.services.impl;

import be.bstorm.tf_java2023_springtest.models.entities.Book;
import be.bstorm.tf_java2023_springtest.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void ShouldAddBookWithSuccess(){
        Book bookToAdd = new Book("Toto à la plage","C'est Toto qui découvre la mer");
        Book insertedBook = bookService.add(bookToAdd);
        assertNotNull(insertedBook);
        assertNotNull(insertedBook.getId());
        assertEquals(bookToAdd.getTitle(),insertedBook.getTitle());
        assertEquals(bookToAdd.getDescription(),insertedBook.getDescription());
    }
}