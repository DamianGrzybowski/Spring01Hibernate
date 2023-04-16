package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> skills() {
        return Arrays.asList("Java", "Ruby", "Python", "JavaScript", "C++");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Swimming", "Programming", "Travels", "Video games");
    }


    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @ResponseBody
    @PostMapping
    public String formHandle(@ModelAttribute("student") Student student) {
        return "Student: " + student;
    }
}
