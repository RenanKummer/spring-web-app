package renankummer.udemy.springwebapp.repository

import org.springframework.data.jpa.repository.JpaRepository
import renankummer.udemy.springwebapp.model.Book

interface BookRepository : JpaRepository<Book, Long>
