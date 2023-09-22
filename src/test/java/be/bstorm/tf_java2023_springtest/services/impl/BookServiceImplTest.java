package be.bstorm.tf_java2023_springtest.services.impl;

import be.bstorm.tf_java2023_springtest.exceptions.TitleBookException;
import be.bstorm.tf_java2023_springtest.models.entities.Book;
import be.bstorm.tf_java2023_springtest.repositories.BookRepositoryMock;
import be.bstorm.tf_java2023_springtest.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {

    //#region Without mock
//    @Autowired
//    private BookService bookService;
    //#endregion

    //#region With mock
    private BookService bookService = new BookServiceImpl(new BookRepositoryMock());
    //#endregion

    @Test
    void ShouldAddBookWithSuccess(){
        Book bookToAdd = new Book("Toto à la plage","C'est Toto qui découvre la mer");
        Book insertedBook = bookService.add(bookToAdd);
        assertNotNull(insertedBook);
        assertNotNull(insertedBook.getId());
        assertEquals(bookToAdd.getTitle(),insertedBook.getTitle());
        assertEquals(bookToAdd.getDescription(),insertedBook.getDescription());
    }
    @Test
    void ShouldAddBookWithFailure(){
        Book bookToAdd = new Book("Toto au bowling","C'est Toto qui découvre le bowling");
        Book insertedBook = bookService.add(bookToAdd);
        Book book = new Book("Toto au bowling","C'est Toto qui découvre le bowling");
        TitleBookException actualException = assertThrows(TitleBookException.class,() -> bookService.add(book));
    }

    @Test
    void ShouldGetOneBookWithSuccess(){
        Book bookToAdd = new Book("Toto à la pêche","C'est Toto qui découvre la pêche");
        Book insertedBook = bookService.add(bookToAdd);
        Book actualBook = bookService.findById(insertedBook.getId());

        assertEquals(insertedBook.getId(),actualBook.getId());
        assertEquals(insertedBook.getDescription(),actualBook.getDescription());
        assertNotNull(actualBook);
    }
    @Test
    void ShouldGetOneBookWithFailure(){
        assertThrows(NoSuchElementException.class,() -> bookService.findById(0L));
    }

    @Test
    void ShouldUpdateOneBookWithSuccess(){
        Book bookToAdd = new Book("Toto au billard","C'est Toto qui découvre le billard");
        Book insertedBook = bookService.add(bookToAdd);
        Book existingBook = bookService.findById(insertedBook.getId());
        Book bookToUpdate = new Book("Toto a la flemme","Toto decouvre la flemme");
        boolean isOk = bookService.update(existingBook.getId(),bookToUpdate);
        bookToUpdate = bookService.findById(existingBook.getId());
        assertTrue(isOk);
        assertEquals(existingBook.getId(),bookToUpdate.getId());
        assertNotEquals(existingBook.getTitle(),bookToUpdate.getTitle());
        assertNotEquals(existingBook.getDescription(),bookToUpdate.getDescription());
    }
}