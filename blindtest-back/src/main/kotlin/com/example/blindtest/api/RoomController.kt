package com.example.blindtest.api

import com.example.blindtest.domain.Guest
import com.example.blindtest.domain.RoomService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("private/v1/rooms")
class RoomController(private val roomService: RoomService) {

    @PostMapping
    fun createRoom(@RequestParam id: String): ResponseEntity<String> {
        roomService.createRoom(id)
        return ResponseEntity.ok("Room created with ID: $id")
    }

    @GetMapping("/{id}/raised-hands")
    fun getRaisedHands(@PathVariable id: String): ResponseEntity<List<Guest>> {
        val raisedHands = roomService.getRaisedHands(id)
        return ResponseEntity.ok(raisedHands)
    }

    @PostMapping("/{id}/join")
    fun joinRoom(@PathVariable id: String, @RequestBody guestId: String): ResponseEntity<String> {
        roomService.joinRoom(id, guestId)
        return ResponseEntity.ok("Guest ${guestId} joined room: $id")
    }

    @PostMapping("/{id}/raise-hand/{guestId}")
    fun raiseHand(@PathVariable id: String, @PathVariable guestId: String): ResponseEntity<String> {
        roomService.raiseHand(id, guestId)
        return ResponseEntity.ok("Guest with ID: $guestId raised hand in room: $id")
    }

    @DeleteMapping("/{id}/raised-hands")
    fun clearRaisedHands(@PathVariable id: String): ResponseEntity<String> {
        roomService.clearRaisedHands(id)
        return ResponseEntity.ok("Raised hands cleared for room: $id")
    }
}
