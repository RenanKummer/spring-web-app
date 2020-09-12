package renankummer.udemy.springwebapp.bootstrap

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import renankummer.udemy.springwebapp.logging.logger
import renankummer.udemy.springwebapp.model.Author
import renankummer.udemy.springwebapp.model.Book
import renankummer.udemy.springwebapp.model.Publisher
import renankummer.udemy.springwebapp.repository.AuthorRepository
import renankummer.udemy.springwebapp.repository.BookRepository
import renankummer.udemy.springwebapp.repository.PublisherRepository
import java.time.LocalDateTime

@Component
class BootstrapData(
        private val authorRepository: AuthorRepository,
        private val bookRepository: BookRepository,
        private val publisherRepository: PublisherRepository
) : CommandLineRunner {
    companion object {
        private val log = logger<BootstrapData>()
    }

    override fun run(vararg args: String?) {
        initializeAuthorsAndBooksAndPublishers()

        log.info("Started in Bootstrap @ ${LocalDateTime.now()}")
        log.info("Number of books: ${bookRepository.count()}")
        log.info("Number of authors: ${authorRepository.count()}")
        log.info("Number of publishers: ${publisherRepository.count()}")
    }

    fun initializeAuthorsAndBooksAndPublishers() {
        val kindleDirect = Publisher(
                name = "Kindle Direct",
                addressLine1 = "1000 Any St.",
                city = "São Paulo",
                state = "SP",
                zipCode = "91000000"
        )

        publisherRepository.save(kindleDirect)

        val ericEvans = Author(firstName = "Eric", lastName = "Evans")
        val domainDrivenDesign = Book(title = "Domain Driven Design")
        ericEvans.books.add(domainDrivenDesign)
        domainDrivenDesign.authors.add(ericEvans)
        domainDrivenDesign.publisher = kindleDirect

        val rodJohnson = Author(firstName = "Rod", lastName = "Johnson")
        val j2eeDevWithoutEjb = Book(title = "J2EE Development Without EJB")
        rodJohnson.books.add(j2eeDevWithoutEjb)
        j2eeDevWithoutEjb.authors.add(rodJohnson)
        j2eeDevWithoutEjb.publisher = kindleDirect

        kindleDirect.books.addAll(listOf(domainDrivenDesign, j2eeDevWithoutEjb))

        authorRepository.saveAll(listOf(ericEvans, rodJohnson))
        bookRepository.saveAll(listOf(domainDrivenDesign, j2eeDevWithoutEjb))
        publisherRepository.save(kindleDirect)
    }
}
