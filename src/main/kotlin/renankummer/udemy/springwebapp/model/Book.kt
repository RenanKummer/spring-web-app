package renankummer.udemy.springwebapp.model

import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(name = "books")
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
                name = "authors_books",
                joinColumns = [ JoinColumn(name = "books_id", nullable = false) ],
                inverseJoinColumns = [ JoinColumn(name = "authors_id") ]
        )
        var authors: Set<Author> = HashSet<Author>()
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
