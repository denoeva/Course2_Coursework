package pro.sky.Course2Coursework.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.Course2Coursework.exceptions.NotEnoughQuestionsException;
import pro.sky.Course2Coursework.model.Question;
import pro.sky.Course2Coursework.service.ExaminerService;
import pro.sky.Course2Coursework.service.QuestionService;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionsException();
        }
        return Stream.generate(questionService::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }
}
