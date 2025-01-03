package com.example.blindtest.domain

interface RoomRepository {

    fun save(room: Room)

    fun findById(id: String): Room?

    fun findAll(): List<Room>

    fun deleteById(id: String)

    fun update(room: Room)
}
