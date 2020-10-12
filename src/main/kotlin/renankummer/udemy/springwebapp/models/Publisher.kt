package renankummer.udemy.springwebapp.models

import javax.persistence.*

@Entity
data class Publisher(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "name", nullable = false)
        var name: String = "",
        @Column(name = "addressLine1", nullable = false)
        var addressLine1: String = "",
        @Column(name = "city", nullable = false)
        var city: String = "",
        @Column(name = "state", nullable = false)
        var state: String = "",
        @Column(name = "zipCode", nullable = false)
        var zipCode: String = "",

        @OneToMany
        @JoinColumn(name = "publisher_id")
        var books: MutableSet<Book> = mutableSetOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Publisher

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id.hashCode()
}
