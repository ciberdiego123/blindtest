package com.example.blindtest.domain

interface GuestRepository {

    fun save(guest: Guest)

    fun findById(id: String): Guest?

    fun findAll(): List<Guest>

    fun deleteById(id: String)

    fun update(guest: Guest)
}
