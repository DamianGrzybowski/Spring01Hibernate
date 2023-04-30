package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT b FROM Book b where b.title = :title")
    List<Book> findByCustomJPQLQueryByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b where b.category = :category")
    List<Book> findByCustomJPQLQueryByCategory(@Param("category") String category);

    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN :param1 AND :param2")
    List<Book> findByRatingBetween(@Param("param1") int param1,
                                   @Param("param2") int param2);


    @Query("SELECT b FROM Book b WHERE b.publisher = :publisher")
    List<Book> findByPublisherCustom(@Param("publisher") Publisher publisher);


    @Query("SELECT b FROM Book b WHERE b.category = :category ORDER BY b.title ASC")
    Book findFirstByCategoryOrderByTitleDescCustom(@Param("category") Category category);



}
