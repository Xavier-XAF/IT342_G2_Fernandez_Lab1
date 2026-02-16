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
- [x] Initialize React project in `/web`. (a81e5ed)
- [x] Create Registration Page (Email/Password forms)
- [x] Create Login Page.
- [x] Create Dashboard (Display User Profile).

## Phase 4: Mobile Development (Android Kotlin)

## DONE 
- Phase 1: Database Setup (f9cf719)
- Phase 2: Backend Development (f9cf719)
- Phase 3: Frontend Development (1935fb1)

## IN-PROGRESS

## TODO 
- Phase 4 : Mobile Development



