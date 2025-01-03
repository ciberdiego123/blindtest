package com.example.blindtest.persistence

import com.example.blindtest.domain.Room
import com.example.blindtest.domain.RoomRepository
import org.springframework.stereotype.Component

@Component
class RoomMemoryRepository: RoomRepository {
    private val rooms = mutableMapOf<String, Room>()

    override fun save(room: Room) {
        rooms[room.id] = room
    }

    override fun findById(id: String): Room? {
        return rooms[id]
    }

    override fun findAll(): List<Room> {
        return rooms.values.toList()
    }

    override fun deleteById(id: String) {
        rooms.remove(id)
    }

    override fun update(room: Room) {
        rooms[room.id] = room
    }
}
