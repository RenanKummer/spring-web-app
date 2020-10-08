package renankummer.udemy.springwebapp.bootstrap;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import renankummer.udemy.springwebapp.model.Author;
import renankummer.udemy.springwebapp.model.Book;
import renankummer.udemy.springwebapp.model.Publisher;
import renankummer.udemy.springwebapp.repository.AuthorRepository;
import renankummer.udemy.springwebapp.repository.BookRepository;
import renankummer.udemy.springwebapp.repository.PublisherRepository;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) {
        var kindleDirect = Publisher.builder()
                .name("Kindle Direct")
                .addressLine1("1000 Any St.")
                .city("São Paulo")
                .state("SP")
                .zipCode("91000-000")
                .build();

        publisherRepository.save(kindleDirect);

        var ericEvans = Author.builder()
                .firstName("Eric")
                .lastName("Evans")
                .build();
        var domainDriveDesign = Book.builder()
                .title("Domain Driven Design")
                .build();

        ericEvans.getBooks().add(domainDriveDesign);
        domainDriveDesign.getAuthors().add(ericEvans);
        domainDriveDesign.setPublisher(kindleDirect);

        var rodJohnson = Author.builder()
                .firstName("Rod")
                .lastName("Johnson")
                .build();
        var j2eeDevWithoutEjb = Book.builder()
                .title("J2EE Development Without EJB")
                .build();

        rodJohnson.getBooks().add(j2eeDevWithoutEjb);
        j2eeDevWithoutEjb.getAuthors().add(rodJohnson);
        j2eeDevWithoutEjb.setPublisher(kindleDirect);

        kindleDirect.getBooks().addAll(List.of(domainDriveDesign, j2eeDevWithoutEjb));

        authorRepository.saveAll(List.of(ericEvans, rodJohnson));
        bookRepository.saveAll(List.of(domainDriveDesign, j2eeDevWithoutEjb));
        publisherRepository.save(kindleDirect);
    }
}
