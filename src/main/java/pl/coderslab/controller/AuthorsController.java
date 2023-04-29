package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("authorsForm")
public class AuthorsController {

    public static final String AUTHOR_FORM_ADD = "authorForm-add";
    public static final String AUTHOR_FORM_UPDATE = "authorForm-update";
    private final AuthorDao authorDao;

    @GetMapping("all")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorDao.getAllAuthors());
        return "authors-all";
    }

    @GetMapping()
    public String addAuthorsForm(Model model) {
        model.addAttribute("author", new Author());
        return AUTHOR_FORM_ADD;
    }

    @PostMapping
    public String handleAddAuthorsForm(@ModelAttribute("author") @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return AUTHOR_FORM_ADD;
        }
        authorDao.save(author);
        return "redirect:/authorsForm/all";
    }

    @GetMapping("update")
    public String updateAuthor(@RequestParam Long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("authorToUpdate", author);
        return AUTHOR_FORM_UPDATE;
    }

    @PostMapping("update")
    public String handleUpdateAuthorForm(@ModelAttribute("authorToUpdate") @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return AUTHOR_FORM_UPDATE;
        }
        authorDao.update(author);
        return "redirect:/authorsForm/all";
    }
}
