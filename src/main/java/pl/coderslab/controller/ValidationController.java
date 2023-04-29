package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@Slf4j
@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("validation")
public class ValidationController {

    private final Validator validator;

    @GetMapping("validate")
    public String validate(Model model) {
        Book book = new Book();

        Set<ConstraintViolation<Book>> result = validator.validate(book);

        Map<String, String> validation = new HashMap<>();
        if (!result.isEmpty()) {
            for (ConstraintViolation<Book> v : result) {
                validation.put(String.valueOf(v.getPropertyPath()), v.getMessage());
            }
        } else {
            //brak błędów
        }
        model.addAttribute("validations", validation);

        return "validation";
    }

    @ResponseBody
    @GetMapping("validate/author")
    public String validateAuthor() {
        Author author = new Author();

        Set<ConstraintViolation<Author>> result = validator.validate(author);
        if (!result.isEmpty()) {
            for (ConstraintViolation<Author> a : result) {
                log.info("{} : {}", a.getPropertyPath(), a.getMessage());
            }
        } else {
            //brak błędów
        }

        return null;
    }

    @ResponseBody
    @GetMapping("validate/publisher")
    public String validatePublisher() {
        Publisher publisher = new Publisher();


        Set<ConstraintViolation<Publisher>> result = validator.validate(publisher);

        if (!result.isEmpty()) {
            for (ConstraintViolation<Publisher> p : result) {
                log.info("{} : {}", p.getPropertyPath(), p.getMessage());
            }
        } else {
            //brak błędów
        }
        return null;
    }


}
