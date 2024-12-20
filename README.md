# Conceptile Quiz Project

## Overview

This is a Spring Boot-based project for a simple quiz application called Conceptile. It allows users to start a quiz session, receive random questions, submit answers, and view statistics based on their performance.

## Features
- **Start Quiz**: Initiate a quiz session for a user.
- **Get Random Question**: Fetch a random question from the database.
- **Submit Answer**: Submit answers to a question and store them in the session.
- **Quiz Stats**: View the user's statistics, including total answers, correct answers, and incorrect answers.

## Technologies Used
- **Spring Boot**: Backend framework
- **H2 Database**: In-memory database to store quiz questions and user answers.
- **Hibernate**: ORM for interacting with the database.
- **REST API**: Exposed endpoints for quiz operations.

## Setup and Installation

### Prerequisites
- Java 11 or higher
- Spring Boot
- H2 Database (embedded, no installation required)

### Steps to Run the Project

#### 1. Fork the Repository
- Go to the GitHub repository and click the **Fork** button at the top right.
- Clone the forked repository to your local machine:
  ```bash
  git clone https://github.com/your-username/conceptile-quiz.git
  cd conceptile-quiz
### 2. Start the Server
- Run the application using the following command:
  ```bash
      ./mvnw spring-boot:run
This will start the Spring Boot server locally on http://localhost:8080

### 3. Set up the H2 Database
- Navigate to `http://localhost:8080/h2-console` in your browser. In the H2 Console, set the following configurations:

  - **JDBC URL**: `jdbc:h2:mem:testdb`
  - **Username**: `sa`
  - **Password**: `password`

- **Paste the following SQL script into the `h2-database-console` and run it to create the necessary tables and insert sample data:**

  ```sql
      INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION_A, OPTION_B, OPTION_C, OPTION_D, CORRECT_ANSWER)
        VALUES 
          ('What is the capital of France?', 'Paris', 'London', 'Berlin', 'Rome', 'Paris'),
          ('What is 2 + 2?', '3', '4', '5', '6', '4');

### 4. Test the Endpoints Using Postman
- Use Postman to test the following API endpoints:

    Start Quiz:
    POST /api/quiz/start?username=your-username

    Get Random Question:
    GET /api/quiz/question

- Submit Answer:
    POST /api/quiz/submit?username=your-username&questionId=1&answer=Paris

    Get Quiz Stats:
    GET /api/quiz/stats?username=your-username
