package pro.sky.Course2Coursework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Course2Coursework.model.Question;
import pro.sky.Course2Coursework.service.impl.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService questionService;

    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(String question, String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(String question, String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
