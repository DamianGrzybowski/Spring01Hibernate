package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

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
                .createQuery("SELECT b from Book b")
                .getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager
                .createQuery("SELECT b from Book b WHERE b.rating=:raiting")
                .setParameter("raiting", rating)
                .getResultList();
    }

}
