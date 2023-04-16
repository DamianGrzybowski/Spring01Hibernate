package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.transaction.Transactional;
import java.util.Random;
import java.util.Set;

@Slf4j
@Controller
@Transactional

public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @ResponseBody()
    @RequestMapping("/book/add")
    public String add() {
        Random random = new Random();
        Publisher publisher = new Publisher();
        publisher.setName("Pub" + random.nextInt());
        publisherDao.add(publisher);
        Author author1 = authorDao.findById(1L);
        Author author2 = authorDao.findById(2L);
        Book book = new Book();
        book.setTitle("Example title");
        book.setDescription("Example description");
        book.setRating(8);
        book.setPublisher(publisher);
        Set<Author> authors = book.getAuthors();
        authors.add(author1);
        authors.add(author2);
        book.setAuthors(authors);
        bookDao.saveBook(book);
        return "Id of added book is: " + book.getId();
    }

    @ResponseBody
    @RequestMapping("/book/find/{id}")
    public String find(@PathVariable Long id) {
        Book book = bookDao.findBookById(id);
        return book.toString();
    }

    @ResponseBody
    @RequestMapping("/book/update/{id}")
    public String update(@PathVariable Long id) {
        Book book = bookDao.findBookById(id);
        book.setTitle("title2");
        book.setDescription("description2");
        bookDao.updateBook(book);
        return "Book has been updated. " + book;
    }

    @ResponseBody
    @RequestMapping("/book/delete/{id}")
    public String delete(@PathVariable Long id) {
        Book book = bookDao.findBookById(id);
        bookDao.deleteBook(book);
        return "Book has been deleted";
    }

    @ResponseBody
    @RequestMapping("/book/all")
    public void getAllBooks() {
//        bookDao.findAll().forEach(book -> log.info(book.toString()));
    }

    @ResponseBody
    @GetMapping("/book/find/{rating}")
    public String findByRating(@PathVariable int rating) {
        return bookDao.findAllByRating(rating).toString();
    }

    @ResponseBody
    @GetMapping("/book/findall")
    public String findAllWithPublisher() {
        return bookDao.findBooksWithPublisher().toString();
    }

    @ResponseBody
    @GetMapping("/book/find/publisher")
    public String findAllByPublisher() {
        Publisher publisher = publisherDao.findById(6L);
        return bookDao.findBookByPublisher(publisher).toString();
    }

    @ResponseBody
    @GetMapping("/book/find/author")
    public String findAllByAuthor() {
        Author author = authorDao.findById(1L);
        return bookDao.findBookByAuthor(author).toString();
    }
}
