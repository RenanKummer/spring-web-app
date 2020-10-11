package renankummer.udemy.springwebapp.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import renankummer.udemy.springwebapp.repository.AuthorRepository

@Controller
class AuthorController(val authorRepository: AuthorRepository) {

    @GetMapping("/authors")
    fun getAuthors(model: Model): String {
        model["authors"] = authorRepository.findAll()
        return "authors/list"
    }
}
