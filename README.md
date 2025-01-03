# Blind Test Application

An interactive application designed for conducting blind tests, allowing a host to manage rooms and guests to join and participate. This is the initial version, using an in-memory collection for persistence. The application is built with a Kotlin backend and a Next.js frontend.

---

## Features

### Backend
- **Create Room**: Hosts can create rooms.
- **Join Room**: Guests can join a specific room.
- **Raise Hand**: Guests can raise their hands.
- **Fetch Raised Hands**: Hosts can view raised hands in a room.
- **Clear Raised Hands**: Hosts can clear the raised hands list.

### Frontend
- User-friendly interface for hosts and guests to interact with the backend.
- Built with React (Next.js) for modern and dynamic user experiences.

---

## Getting Started

### Prerequisites
- **Java**: Version 17 or higher (backend uses Kotlin)
- **Node.js**: Version 18 or higher (for Next.js frontend)
- **npm**: Version 8 or higher

---

### Running the Application Locally

#### Backend
1. Navigate to the backend directory: `cd blindtest-back`.
2. Run the Spring Boot application: `./gradlew bootRun`.  
   The backend server will start on `http://localhost:7070`.

#### Frontend
1. Navigate to the frontend directory: `cd blindtest-front`.
2. Install dependencies: `npm install`.
3. Start the development server: `npm run dev`.  
   The frontend server will start on `http://localhost:4000`.

---

## Usage

### Accessing the Application
1. Open the frontend in your browser: `http://localhost:4000`.
2. Use the frontend interface to interact with the backend:
   - Create rooms
   - Join rooms as guests
   - Raise hands and clear them

### API Endpoints (Backend)
- `POST /private/v1/rooms?id={roomId}`: Create a room.
- `POST /private/v1/rooms/{roomId}/join`: Join a room.
- `POST /private/v1/rooms/{roomId}/raise-hand/{guestId}`: Raise hand.
- `GET /private/v1/rooms/{roomId}/raised-hands`: Fetch raised hands.
- `DELETE /private/v1/rooms/{roomId}/raised-hands`: Clear raised hands.

---

## Current Limitations
- **Persistence**: Data is stored in memory and resets when the application restarts.
- **Database**: A PostgreSQL database will be added in future versions for persistent storage.

---

## Technology Stack
- **Backend**: Kotlin, Spring Boot
- **Frontend**: React (Next.js)

---

## Future Improvements
- Integrate PostgreSQL for data persistence.
- Add authentication for hosts and guests.
- Enhance the UI with modern design frameworks (e.g., Tailwind CSS, Material-UI).
- Add real-time functionality using WebSockets.

---

## Contributing
Contributions are welcome! Please create a new branch for your feature or bug fix and submit a pull request.

---

## License
This project is open-source and available under the [MIT License](LICENSE).

---

## Acknowledgments
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Next.js](https://nextjs.org/)
- [React](https://reactjs.org/)
