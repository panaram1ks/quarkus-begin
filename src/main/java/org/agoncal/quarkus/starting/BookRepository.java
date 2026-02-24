package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Me","Title1", 2025, "IT"),
                new Book(2, "Him","Title2", 2023, "IT"),
                new Book(3, "She","Title3", 2019, "IT")
        );
    }

    public Optional<Book> getBook(int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }


}
