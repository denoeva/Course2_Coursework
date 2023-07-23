package pro.sky.Course2Coursework.service;

import pro.sky.Course2Coursework.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
