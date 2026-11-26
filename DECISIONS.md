# Project decisions

**English** · [Português (Brasil)](DECISIONS.pt-BR.md)

This file records the important decisions made during the development of the project. Both language versions must remain synchronized.

## 25/11/2026 — Technology stack

- **Decision:** Use Java 21, Spring Boot 4.2.0 and Maven for the back-end; JavaScript, React and Vite for the front-end. The database chosen was SQLite.
- **Database rationale:** SQLite provides persistent local storage with minimal setup, making it suitable for the MVP demonstration.
- **Alternatives considered:** Node.js with Express, Python with FastAPI, and plain JavaScript without React.
- **Rationale:** Java and Spring Boot are already configured and running in the project. React and Vite provide a structured and practical way to build the front-end using JavaScript.

## 25/11/2026 — MVP scope

- **Decision:** Build a lost-and-found system for the campus and community with found-item registration, AI-assisted descriptions reviewed by a human, lost-item reports, search and filters, interest requests and item return status updates.
- **Alternatives considered:** A smaller system limited to found-item registration, or a broader system with additional services.
- **Rationale:** The selected scope covers the core requirements of the hackathon while remaining achievable within the available development time.

## 25/11/2026 — Features excluded from the MVP

- **Decision:** Do not implement facial recognition, shipping, payments, rewards, auctions or police-report functionality.
- **Alternatives considered:** Adding these features as optional services.
- **Rationale:** These features are outside the challenge requirements and would increase the project's complexity and risks.