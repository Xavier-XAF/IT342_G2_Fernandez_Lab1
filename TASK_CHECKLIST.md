# Project Task Checklist

## Phase 1: Database Setup
- [x] Create `User` table (columns: userid, email, password_hash, status, created_at) 
- [x] Create `Sessions` table (columns: sessionId, user_id, session_token, expires_at) 
- [x] Create `User Profiles` table (columns: userprofileId, firstname, lastname, profile_url) 

## Phase 2: Backend Development (Spring Boot) 
- [x] Initialize Spring Boot project with Web, JPA, MySQL Driver, and Security dependencies.
- [x] **Feature 1: User Identity** 
    - [x] Implement `User` entity and Repository.
    - [x] Create Registration Service (with Password Encryption).
- [x] **Feature 2: Session & Access Control** 
    - [x] Implement Login logic (Credential verification & Session Token generation)
    - [x] Implement Logout logic (Session invalidation)
    - [x] Implement Access Restriction for protected routes

## Phase 3: Frontend Development (React)
- [ ] Initialize React project in `/web`.
- [ ] Create Registration Page (Email/Password forms)
- [ ] Create Login Page.
- [ ] Create Dashboard (Display User Profile).

## DONE 
- Phase 1: Database Setup (f9cf719)
- Phase 2: Backend Development (f9cf719)
- Phase 3: Frontend Development
- [x] Initialize React Project in '/web'. (a81e5ed)

## IN-PROGRESS
- Phase 3 : Frontend Development
- [ ] Create Registration Page (Email/Password forms)
- [ ] Create Login Page.
- [ ] Create Dashboard (Display User Profile).

## TODO 
- Phase 3 : Frontend Development



