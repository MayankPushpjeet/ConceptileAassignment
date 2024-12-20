package org.example.conceptile.Controller;

import org.example.conceptile.model.Question;
import org.example.conceptile.model.QuizSession;
import org.example.conceptile.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public String startQuiz(@RequestParam String username) {
        return "Quiz session started for user: " + username;
    }

    @GetMapping("/question")
    public Question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/submit")
    public QuizSession submitAnswer(@RequestParam String username, @RequestParam Long questionId, @RequestParam String answer) {
        return quizService.submitAnswer(username, questionId, answer);
    }

    @GetMapping("/stats")
    public String getStats(@RequestParam String username) {
        long answered = quizService.getAnsweredCount(username);
        long correct = quizService.getCorrectCount(username);
        long incorrect = quizService.getIncorrectCount(username);
        return String.format("User: %s, Total Answered: %d, Correct: %d, Incorrect: %d", username, answered, correct, incorrect);
    }
}
