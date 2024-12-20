# Conceptile Quiz Project

## Overview
This is a Spring Boot-based project for a simple quiz application called **Conceptile**. It allows users to start a quiz session, receive random questions, submit answers, and view statistics based on their performance.

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

## API Endpoints

### 1. Start Quiz
**POST** `/api/quiz/start`
- Starts a quiz session for a user.
- **Request Parameters**:
  - `username`: Name of the user (String)
- **Response**:
  - `String`: Message indicating that the quiz session has started.

### 2. Get Random Question
**GET** `/api/quiz/question`
- Fetches a random question from the database.
- **Response**:
  - `Question`: A random question with options and the correct answer.

### 3. Submit Answer
**POST** `/api/quiz/submit`
- Submits an answer for a given question.
- **Request Parameters**:
  - `username`: Name of the user (String)
  - `questionId`: ID of the question (Long)
  - `answer`: The answer chosen by the user (String)
- **Response**:
  - `QuizSession`: The updated quiz session with the user's progress.

### 4. Get Quiz Stats
**GET** `/api/quiz/stats`
- Retrieves the statistics for the user.
- **Request Parameters**:
  - `username`: Name of the user (String)
- **Response**:
  - `String`: A summary of the user's performance (Total answered, correct, incorrect).

## Database Schema

### `questions` Table
The `questions` table stores the questions, options, and correct answers for the quiz.

```sql
CREATE TABLE IF NOT EXISTS QUESTIONS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    QUESTION_TEXT VARCHAR(255),
    OPTION_A VARCHAR(255),
    OPTION_B VARCHAR(255),
    OPTION_C VARCHAR(255),
    OPTION_D VARCHAR(255),
    CORRECT_ANSWER VARCHAR(255)
);
