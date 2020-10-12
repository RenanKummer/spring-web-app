package renankummer.udemy.springwebapp.repositories

import org.springframework.data.jpa.repository.JpaRepository
import renankummer.udemy.springwebapp.models.Book

interface BookRepository : JpaRepository<Book, Long>
