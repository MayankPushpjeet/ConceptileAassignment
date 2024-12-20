package org.example.conceptile.service;

import org.example.conceptile.model.Question;
import org.example.conceptile.model.QuizSession;
import org.example.conceptile.repository.QuestionRepository;
import org.example.conceptile.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public QuizSession submitAnswer(String username, Long questionId, String submittedAnswer) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question == null) return null;

        boolean isCorrect = question.getCorrectAnswer().equals(submittedAnswer);
        QuizSession session = new QuizSession();
        session.setUsername(username);
        session.setQuestionId(questionId);
        session.setSubmittedAnswer(submittedAnswer);
        session.setCorrectAnswer(isCorrect);

        return quizSessionRepository.save(session);
    }

    public long getAnsweredCount(String username) {
        return quizSessionRepository.findByUsername(username).size();
    }

    public long getCorrectCount(String username) {
        return quizSessionRepository.findByUsername(username).stream()
                .filter(QuizSession::isCorrectAnswer)
                .count();
    }

    public long getIncorrectCount(String username) {
        return getAnsweredCount(username) - getCorrectCount(username);
    }
}

