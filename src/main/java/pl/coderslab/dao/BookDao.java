package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findBookById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    public void deleteBook(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        return entityManager
                .createQuery("SELECT b from Book b left join fetch b.authors")
                .getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager
                .createQuery("SELECT b from Book b WHERE b.rating=:rating")
                .setParameter("rating", rating)
                .getResultList();
    }

    public List<Book> findBooksWithPublisher() {
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.publisher IS NOT NULL")
                .getResultList();
    }

    public List<Book> findBookByPublisher(Publisher publisher) {
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.publisher=:publisher")
                .setParameter("publisher", publisher)
                .getResultList();
    }

    public List<Book> findBookByAuthor(Author author) {
        return entityManager
                .createQuery("SELECT distinct b FROM Book b join FETCH b.authors WHERE :author MEMBER OF b.authors")
                .setParameter("author", author)
                .getResultList();
    }




}
