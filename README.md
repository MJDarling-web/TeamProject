# Urban Photography API
A RESTful web service for discovering, contributing to, and managing photography locations.  
Built with **Java**, **Hibernate**, **Jersey**, **JUnit**, and deployed to **AWS**.

---

## Problem Statement
Photography enthusiasts often struggle to discover and share ideal photography spots due to scattered information and the absence of a centralized platform.  
This project aims to address these challenges by creating an API that enables developers to find, contribute to, and manage a curated list of photography locations, including detailed information such as descriptions, images, and optimal shooting times.

---

## API Documentation

[View Documentation](apiDocumentation.md)

---

## Presentation
|Part|Video| Author        |
|--|--|---------------|
|1|https://youtu.be/UOU9_u_9etg| Micah Darling |
|2|https://youtu.be/LryjWLK3B5c| Matt Brophy   |
|3|https://youtu.be/DAUglJrVqHU| Jamin Zimmerman|

## Project Plan (3-Week Timeline)

<details>
<summary><strong>Week 1: Requirement Analysis & Design</strong></summary>

- [X] Finalize API functionality and endpoints (GET, POST, PUT, DELETE)
- [ ] Design the database schema for Location model using Hibernate
- [ ] Set up Maven structure and dependencies (Hibernate, Log4j, JUnit, gitIgnore, Persistence package with classes Database, PropertiesLoader, GenericDao)
- [ ] Configure AWS for DB hosting - Matt will ask Paula
- [X] Assign tasks and roles
- [ ] Create Location and Coordinate entities - Micah
- [ ] Map entities to database via hibernate - Micah
- [ ] Setup API endpoint service shells '/services' & '/locations' shells for our URI endpoints

**Deliverables**:
- Codebase setup
- API design
- AWS DB connection
- Planning doc with milestones
</details>

<details>
<summary><strong>Week 2: Core Development</strong></summary>

- Implement CRUD endpoints with Hibernate
- Configure Log4j for logging
- Write internal unit tests with JUnit
- Code documentation and comments

**Deliverables**:
- Functional REST API
- Logging support
- In-progress code documentation
</details>

<details>
<summary><strong>Week 3: Testing, Optimization, Deployment</strong></summary>

- Write full JUnit tests (including edge cases)
- Deploy to AWS
- Write user + developer documentation

**Deliverables**:
- Fully tested API
- AWS deployment
- Polished documentation
</details>

---

## Team: The Framechasers

<details>
<summary><strong>Team Resume</strong></summary>

**Jamin Zimmerman**  
Sheboygan, WI  
Java, GitHub, JS, debugging  
UW-Stout & MATC  
Clean code & collaboration  
Rock climbing, sports, music

---

**Micah Darling**  
Sun Prairie, WI  
Java, OOP, front-end  
UW-Platteville & Madison College  
Creative problem solver  
Hiking, board games, hockey

---

**Alperen Ozelce**  
Izmir, Türkiye  
Java, full stack  
Political Science @ MCBU  
Curious & quick learner  
Photography, swimming

---

**Matt Brophy**  
Rhinelander, WI  
Java, SQL, HTML/CSS  
Madison College  
Project management pro  
BBQ master, charcuterie fan
</details>

---

## Team Charter & Ground Rules

<details>
<summary><strong>Team Purpose & Objectives</strong></summary>

**Purpose**:
- Build a public-facing web service
- Document it well
- Showcase a polished team portfolio

**Objectives**:
- CRUD REST API
- Final presentation
- Weekly logs & GitHub repo
- Project plan with timeline
</details>

<details>
<summary><strong>Roles & Responsibilities</strong></summary>

| Role            | Assigned To       | Responsibilities              |
|-----------------|-------------------|-------------------------------|
| Coordinator     | Alperen Ozelce    | Coordinate team meetings      |
| Meeting Leader  | Jamin Zimmerman   | Lead team meetings            |
| Scribe          | Matt Brophy       | Document & submit minutes     |
| Repo Manager    | Micah Darling     | Create & manage GitHub repo   |
</details>

<details>
<summary><strong>Communication Plan</strong></summary>

- **Slack** for daily communication
- **Teams** for weekly meetings (Wednesday @ 4:30 PM)
- Slack used for team and instructor updates
</details>

<details>
<summary><strong>Ground Rules</strong></summary>

- Everyone contributes
- Attend weekly meetings (or provide an update)
- Meet deadlines
- Communicate when stuck
- Provide respectful, constructive feedback
</details>

<details>
<summary><strong>Conflict Resolution</strong></summary>

- Use team vote to resolve disputes
- Seek mutual understanding
- Escalate to instructor if needed
- If team member is unresponsive for 48+ hours, and team has tried to contact at least 3 times, the team will let the instructor know and pick up any assigned work we feel is crucial.
</details>

<details>
<summary><strong>Branching Strategy</strong></summary>

- Follow Java best practices
- Branch by feature
- Pull requests will be noted in Slack when they are ready and anyone will pick them up
- Merge Main branch into your own branch before pushing for code review

</details>

---

## Tech Stack
- Java 11
- Hibernate ORM
- Jersey (JAX-RS)
- JUnit 5
- Log4j 2
- MySQL (hosted on AWS)
- Maven  
