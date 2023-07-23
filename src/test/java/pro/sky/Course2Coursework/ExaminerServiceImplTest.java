package pro.sky.Course2Coursework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Course2Coursework.model.Question;
import pro.sky.Course2Coursework.service.impl.ExaminerServiceImpl;
import pro.sky.Course2Coursework.service.impl.JavaQuestionService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    List<Question> questions = Arrays.asList(
            new Question("Question1", "Answer1"),
            new Question("Question2", "Answer2"),
            new Question("Question3", "Answer3"));

    @BeforeEach
    void setUp() {
        when(javaQuestionService.getAll()).thenReturn(questions);
    }

    @Test
    void getQuestions() {
        int amount = 3;
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(1))
                .thenReturn(questions.get(2));
        Collection<Question> result = examinerService.getQuestions(amount);
        assertEquals(amount, result.size());
        assertTrue(result.contains(questions.get(0)));
        assertTrue(result.contains(questions.get(1)));
        assertTrue(result.contains(questions.get(2)));
    }
}