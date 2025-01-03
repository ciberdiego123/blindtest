"use client";

import { useState } from "react";

export default function Home() {
  const [roomId, setRoomId] = useState("");
  const [guestId, setGuestId] = useState("");
  const [raisedHands, setRaisedHands] = useState([]);
  const [message, setMessage] = useState("");

  const apiBaseUrl = "http://localhost:7070/private/v1/rooms";

  const createRoom = async () => {
    try {
      const response = await fetch(`${apiBaseUrl}?id=${roomId}`, {
        method: "POST",
      });
      const data = await response.text();
      setMessage(data);
    } catch (error) {
      setMessage("Error creating room");
    }
  };

  const joinRoom = async () => {
    try {
      const response = await fetch(`${apiBaseUrl}/${roomId}/join`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(guestId),
      });
      const data = await response.text();
      setMessage(data);
    } catch (error) {
      setMessage("Error joining room");
    }
  };

  const raiseHand = async () => {
    try {
      const response = await fetch(`${apiBaseUrl}/${roomId}/raise-hand/${guestId}`, {
        method: "POST",
      });
      const data = await response.text();
      setMessage(data);
    } catch (error) {
      setMessage("Error raising hand");
    }
  };

  const fetchRaisedHands = async () => {
    try {
      const response = await fetch(`${apiBaseUrl}/${roomId}/raised-hands`);
      const data = await response.json();
      setRaisedHands(data);
    } catch (error) {
      setMessage("Error fetching raised hands");
    }
  };

  const clearRaisedHands = async () => {
    try {
      const response = await fetch(`${apiBaseUrl}/${roomId}/raised-hands`, {
        method: "DELETE",
      });
      const data = await response.text();
      setMessage(data);
    } catch (error) {
      setMessage("Error clearing raised hands");
    }
  };

  return (
      <div style={{ padding: "20px" }}>
        <h1>Blind Test App</h1>
        <div>
          <input
              type="text"
              placeholder="Room ID"
              value={roomId}
              onChange={(e) => setRoomId(e.target.value)}
              style={{ marginRight: "10px" }}
          />
          <input
              type="text"
              placeholder="Guest ID"
              value={guestId}
              onChange={(e) => setGuestId(e.target.value)}
          />
        </div>
        <div style={{ marginTop: "20px" }}>
          <button onClick={createRoom}>Create Room</button>
          <button onClick={joinRoom}>Join Room</button>
          <button onClick={raiseHand}>Raise Hand</button>
          <button onClick={fetchRaisedHands}>Get Raised Hands</button>
          <button onClick={clearRaisedHands}>Clear Raised Hands</button>
        </div>
        <div style={{ marginTop: "20px" }}>
          <h2>Message:</h2>
          <p>{message}</p>
        </div>
        <div>
          <h2>Raised Hands:</h2>
          <ul>
            {raisedHands.map((guest, index) => (
                <li key={index}>
                  {guest.name} - {guest.handRaiseTimestamp}
                </li>
            ))}
          </ul>
        </div>
      </div>
  );
}
