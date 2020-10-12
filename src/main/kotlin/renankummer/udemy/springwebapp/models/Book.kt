package renankummer.udemy.springwebapp.models

import java.util.*
import javax.persistence.*

@Entity
data class Book (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "title", nullable = false)
        var title: String,
        @Column(name = "isbn", nullable = false)
        var isbn: String = UUID.randomUUID().toString(),

        @ManyToMany
        @JoinTable(
                name = "author_book",
                joinColumns = [ JoinColumn(name = "book_id") ],
                inverseJoinColumns = [ JoinColumn(name = "author_id") ]
        )
        var authors: MutableSet<Author> = mutableSetOf(),

        @ManyToOne
        var publisher: Publisher = Publisher()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()
}
