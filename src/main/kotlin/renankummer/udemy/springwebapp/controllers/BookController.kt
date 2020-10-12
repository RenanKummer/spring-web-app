package renankummer.udemy.springwebapp.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import renankummer.udemy.springwebapp.repositories.BookRepository

@Controller
class BookController(private val bookRepository: BookRepository) {

    @GetMapping("/books")
    fun getBooks(model: Model): String {
        model["books"] = bookRepository.findAll()
        return "books/list"
    }
}
