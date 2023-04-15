package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

import javax.persistence.PersistenceContext;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        Publisher publisher = new Publisher();
        publisher.setName("Peter");
        publisherDao.add(publisher);
        return "Publisher has been created!";
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        return "Publisher has been found! " + publisher;
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName("Henry");
        publisherDao.update(publisher);
        return "Publisher has been updated! " + publisher;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "Publisher with id = " + id + " has been deleted!";
    }


}
