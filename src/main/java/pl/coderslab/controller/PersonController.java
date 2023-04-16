package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.model.Person;

@Slf4j
@Controller
@RequestMapping("/person")
public class PersonController {
    final private PersonDao personDao;
    final private PersonDetailsDao personDetailsDao;

    @Autowired
    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }


    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "persons-form";
    }

    @PostMapping
    @ResponseBody
    public void handleForm(@ModelAttribute("person") Person person) {
        log.info("{}", person);
    }
}
