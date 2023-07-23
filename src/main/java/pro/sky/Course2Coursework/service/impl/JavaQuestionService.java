package pro.sky.Course2Coursework.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.Course2Coursework.exceptions.QuestionAlreadyExistsException;
import pro.sky.Course2Coursework.exceptions.QuestionNotFoundException;
import pro.sky.Course2Coursework.model.Question;
import pro.sky.Course2Coursework.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private static final Random RANDOM = new Random();
    List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        return remove(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(RANDOM.nextInt(questions.size()));
    }
}
