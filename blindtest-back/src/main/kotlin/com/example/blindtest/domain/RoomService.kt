package com.example.blindtest.domain

import java.util.concurrent.ConcurrentHashMap

class RoomService (
    private val roomRepository: RoomRepository,
    private val guestRepository: GuestRepository
) {
    // Room ID -> List of guests
    private val raisedHands: MutableMap<String, List<Guest>> = ConcurrentHashMap()

    fun createRoom(id: String) {
        roomRepository.save(Room(id, "Room $id"))
        raisedHands[id] = mutableListOf()
    }

    fun getRaisedHands(id: String): List<Guest> {
        return raisedHands[id] ?: throw IllegalArgumentException("Room $id not found")
    }

    fun joinRoom(id: String, guestId: String) {
        roomRepository.findById(id) ?: throw IllegalArgumentException("Room $id not found")
        val guest = guestRepository.findById(guestId) ?: throw IllegalArgumentException("Guest $guestId not found")
        guest.roomId = id
        guestRepository.update(guest)
    }

    fun raiseHand(id: String, guestId: String) {
        roomRepository.findById(id) ?: throw IllegalArgumentException("Room $id not found")
        val guest = guestRepository.findById(guestId) ?: throw IllegalArgumentException("Guest $guestId not found")
        val hands = raisedHands[id] as MutableList<Guest>
        hands.add(guest)
        raisedHands[id] = hands
    }

    fun clearRaisedHands(id: String) {
        roomRepository.findById(id) ?: throw IllegalArgumentException("Room $id not found")
        raisedHands[id] = mutableListOf()
    }
}
