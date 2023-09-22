package be.bstorm.tf_java2023_springtest.repositories;

import be.bstorm.tf_java2023_springtest.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findBookByTitle(String title);
    boolean existsByTitle(String title);
}
