# Project Task Checklist

## Phase 1: Database Setup
- [ ] Create `User` table (columns: userid, email, password_hash, status, created_at) 
- [ ] Create `Sessions` table (columns: sessionId, user_id, session_token, expires_at) 
- [ ] Create `User Profiles` table (columns: userprofileId, firstname, lastname, profile_url) 

## Phase 2: Backend Development (Spring Boot)
- [ ] Initialize Spring Boot project with Web, JPA, MySQL Driver, and Security dependencies.
- [ ] **Feature 1: User Identity** 
    - [ ] Implement `User` entity and Repository.
    - [ ] Create Registration Service (with Password Encryption).
- [ ] **Feature 2: Session & Access Control** 
    - [ ] Implement Login logic (Credential verification & Session Token generation)
    - [ ] Implement Logout logic (Session invalidation)
    - [ ] Implement Access Restriction for protected routes

## Phase 3: Frontend Development (React)
- [ ] Initialize React project in `/web`.
- [ ] Create Registration Page (Email/Password forms)
- [ ] Create Login Page.
- [ ] Create Dashboard (Display User Profile)[cite: 65].