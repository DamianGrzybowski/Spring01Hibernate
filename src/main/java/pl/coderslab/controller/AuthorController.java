package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorRepository;

import javax.transaction.Transactional;

@Slf4j
@Controller
@Transactional
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorDao authorDao;
    private final AuthorRepository authorRepository;


    @RequestMapping("/author/add")
    public String add() {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Kennedy");
        authorDao.save(author);
        return "Author has been added: " + author;
    }

    @RequestMapping("/author/find/{id}")
    @ResponseBody
    public String findById(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        return "Author with id: " + id + " : " + author;
    }

    @RequestMapping("/author/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        author.setFirstName("Frank");
        author.setLastName("Sinatra");
        authorDao.update(author);
        return "Author with id = " + id + " has been updated! " + author;
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "Author has been deleted!";
    }


    @ResponseBody
    @RequestMapping("author/test")
    public void test() {
        authorRepository.findByPeselContaining("15")
                .forEach(author -> log.info(author.toString()));
    }


}
