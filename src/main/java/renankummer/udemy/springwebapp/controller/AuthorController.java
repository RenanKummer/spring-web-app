package renankummer.udemy.springwebapp.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import renankummer.udemy.springwebapp.repository.AuthorRepository;

@Controller
@AllArgsConstructor
public class AuthorController {

    private final AuthorRepository repository;

    @GetMapping("/authors")
    public String getAuthors(@NonNull Model model) {
        model.addAttribute("authors", repository.findAll());
        return "authors/list";
    }
}
