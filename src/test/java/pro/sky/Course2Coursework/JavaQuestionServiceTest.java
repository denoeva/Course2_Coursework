package pro.sky.Course2Coursework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Course2Coursework.model.Question;
import pro.sky.Course2Coursework.service.impl.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void add() {
        Question expected = new Question("Question", "Answer");
        Question actual = javaQuestionService.add("Question", "Answer");
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        Question question = new Question("Question1", "Answer1");
        javaQuestionService.add("Question1", "Answer1");
        javaQuestionService.add("Question2", "Answer2");
        javaQuestionService.remove(question);
        assertEquals(1, javaQuestionService.getAll().size());
    }

    @Test
    void getAll() {
        javaQuestionService.add("Answer", "Answer");
        javaQuestionService.add("Question", "Question");
        assertEquals(2, javaQuestionService.getAll().size());
    }
}
