package renankummer.udemy.springwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import renankummer.udemy.springwebapp.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> { }
