package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

@Controller
public class BookController {
    private final BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/book/add")
    @ResponseBody()
    public String add() {
        Book book = new Book();
        book.setTitle("Tytuł");
        book.setDescription("Przykładowy opis");
        book.setRating(8);
        bookDao.saveBook(book);
        return "Id of added book is: " + book.getId();
    }

    @RequestMapping("/book/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Book book = bookDao.findBookById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        Book book = bookDao.findBookById(id);
        book.setTitle("title2");
        book.setDescription("description2");
        bookDao.updateBook(book);
        return "Book has been updated. " + book;
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Book book = bookDao.findBookById(id);
        bookDao.deleteBook(book);
        return "Book has been deleted";
    }
}
