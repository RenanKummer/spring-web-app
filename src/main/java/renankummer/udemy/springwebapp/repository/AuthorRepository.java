package renankummer.udemy.springwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import renankummer.udemy.springwebapp.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> { }
