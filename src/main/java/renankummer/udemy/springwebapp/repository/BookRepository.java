package renankummer.udemy.springwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import renankummer.udemy.springwebapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> { }
