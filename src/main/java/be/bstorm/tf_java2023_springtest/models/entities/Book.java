package be.bstorm.tf_java2023_springtest.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"id","title"}) @ToString(of = {"id","title","description"})
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
