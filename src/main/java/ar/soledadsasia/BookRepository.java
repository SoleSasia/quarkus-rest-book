package ar.soledadsasia;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Drama")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio Goncalves", 2020, genre),
                new Book(2, "Practising Quarkus", "Antonio Goncalves", 2020, genre),
                new Book(3, "Effective Java", "Josh Blocj", 2001, genre),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, genre)
        );
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(b -> b.id == id).findFirst();
    }

}
