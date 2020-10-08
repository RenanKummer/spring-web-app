package renankummer.udemy.springwebapp.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import renankummer.udemy.springwebapp.repository.BookRepository;

@Controller
@AllArgsConstructor
public class BookController {

    private final BookRepository repository;

    @GetMapping("/books")
    public String getBooks(@NonNull Model model) {
        model.addAttribute("books", repository.findAll());
        return "books/list";
    }
}
