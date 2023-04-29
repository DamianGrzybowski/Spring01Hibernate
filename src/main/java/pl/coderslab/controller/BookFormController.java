package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("bookForm")
public class BookFormController {

    public static final String BOOK_FORM_ADD = "bookForm-add";
    public static final String BOOK_FORM_UPDATE = "bookForm-update";
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;


    @GetMapping
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return BOOK_FORM_ADD;
    }

    @PostMapping
    public String handleAddBookForm(@ModelAttribute("book") @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return BOOK_FORM_ADD;
        }
        bookDao.saveBook(book);
        return "redirect:/bookForm/all";
    }

    @GetMapping("all")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "bookForm-list";
    }

    @GetMapping("update")
    public String updateBook(@RequestParam Long id, Model model) {
        Book book = bookDao.findBookById(id);
        Hibernate.initialize(book.getAuthors());
        model.addAttribute("bookToUpdate", book);
        return BOOK_FORM_UPDATE;
    }

    @PostMapping("/update")
    public String bookFormUpdate(@ModelAttribute("bookToUpdate") @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return BOOK_FORM_UPDATE;
        }
        bookDao.updateBook(book);
        return "redirect:/bookForm/all";
    }

    @GetMapping("confirm")
    public String askAboutDelete(@RequestParam Long id, Model model) {
        Book book = bookDao.findBookById(id);
        Hibernate.initialize(book.getAuthors());
        model.addAttribute("bookToDelete", book);
        return "confirmDelete";
    }

    @GetMapping("delete")
    public String deleteBook(@RequestParam Long id) {
        bookDao.deleteBook(bookDao.findBookById(id));
        return "redirect:/bookForm/all";
    }


    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherDao.getAllPublishers();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorDao.getAllAuthors();
    }
}
