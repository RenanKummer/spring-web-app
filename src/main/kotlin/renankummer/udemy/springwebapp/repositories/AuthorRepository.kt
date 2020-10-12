package renankummer.udemy.springwebapp.repositories

import org.springframework.data.jpa.repository.JpaRepository
import renankummer.udemy.springwebapp.models.Author

interface AuthorRepository : JpaRepository<Author, Long>
