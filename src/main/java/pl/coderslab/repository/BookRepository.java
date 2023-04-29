package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByAuthorsContains(Author author);

    List<Book> findByAuthors_FirstName(String authorFirstName);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByRating(Integer rating);

    Book findFirstByCategoryOrderByTitleDesc(Category category);



}
