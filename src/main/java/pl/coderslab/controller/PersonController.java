package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.model.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonDao personDao;
    private PersonDetailsDao personDetailsDao;

    @Autowired
    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

//    @ResponseBody
//    @RequestMapping("/add")
//    public String add() {
//        PersonDetails personDetails =
//    }
}
