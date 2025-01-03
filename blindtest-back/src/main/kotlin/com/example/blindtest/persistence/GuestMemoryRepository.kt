package com.example.blindtest.persistence

import com.example.blindtest.domain.Guest
import com.example.blindtest.domain.GuestRepository
import org.springframework.stereotype.Component

@Component
class GuestMemoryRepository : GuestRepository {
    private val guests = mutableMapOf<String, Guest>()

    override fun save(guest: Guest) {
        guests[guest.id] = guest
    }

    override fun findById(id: String): Guest? {
        return guests[id]
    }

    override fun findAll(): List<Guest> {
        return guests.values.toList()
    }

    override fun deleteById(id: String) {
        guests.remove(id)
    }

    override fun update(guest: Guest) {
        guests[guest.id] = guest
    }
}
