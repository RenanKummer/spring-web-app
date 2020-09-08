package renankummer.udemy.springwebapp.model

import javax.persistence.*

@Entity
@Table(name = "authors")
data class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "first_name", nullable = false)
        var firstName: String,
        @Column(name = "last_name", nullable = false)
        var lastName: String,

        @ManyToMany(mappedBy = "authors")
        var books: Set<Book> = HashSet<Book>()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()
}
