package akademiakodu.quiz.controller;

import akademiakodu.quiz.model.Question;
import akademiakodu.quiz.model.Test;
import akademiakodu.quiz.model.User;
import akademiakodu.quiz.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Scope(value = "session")
@Controller
public class TestController {
    private User user = new User();
    private Question question = new Question();
    private Integer currentQuestion;

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/tests/{id}/play")
    public String play(@PathVariable Integer id, ModelMap modelMap) {
        Test test = testRepository.findById(id).get();
        modelMap.put("test", test);
        modelMap.put("question", test.getQuestionList().get(0));
        currentQuestion = 0;
        user = new User();
        return "test";
    }

    @GetMapping("/tests/{id}/continue")
    public String continueTest(
            @RequestParam(required = false)
                    boolean correct, @PathVariable Integer id, ModelMap modelMap) {
        Test test = testRepository.findById(id).get();
        if (test.getQuestionList().get(currentQuestion).isCorrect() == correct) {
            user.addPoint();
        }
        currentQuestion++;
        if (currentQuestion < test.getQuestionList().size()) {
            modelMap.put("test", test);
            modelMap.put("question", test.getQuestionList().get(currentQuestion));
        } else {
            modelMap.put("test", test);
            modelMap.put("message", "Koniec gry! Twoja liczba punktów to: " + user.getNumberOfPoints());
        }
        return "test";
    }

}
