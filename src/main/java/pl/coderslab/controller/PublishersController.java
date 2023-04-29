package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("publisherForm")
public class PublishersController {
    public static final String PUBLISHER_FORM_ADD = "publisherForm-add";
    private final PublisherDao publisherDao;


    @GetMapping("all")
    public String getAll(Model model) {
        List<Publisher> publishers = publisherDao.getAllPublishers();
        model.addAttribute("publishers", publishers);
        return "publishers-all";
    }

    @GetMapping()
    public String addPublisher(Model model) {
        model.addAttribute("publisher", new Publisher());
        return PUBLISHER_FORM_ADD;
    }

    @PostMapping()
    public String handlePublisherAddForm(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return PUBLISHER_FORM_ADD;
        }
        publisherDao.add(publisher);
        return "redirect:/publisherForm/all";
    }


}
