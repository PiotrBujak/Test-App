package akademiakodu.quiz.controller;

import akademiakodu.quiz.model.Question;
import akademiakodu.quiz.model.Test;
import akademiakodu.quiz.repository.QuestionRepository;
import akademiakodu.quiz.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {
    private Integer id;

    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/tests/{id}/add")
    public String addQuestion(@PathVariable int id, ModelMap modelMap) {
        modelMap.put("questions", questionRepository.findQuestionsByTestId(id));
        this.id = id;
        return "question";
    }

    @GetMapping("/addquestion")
    public String saveQuestion(@RequestParam String content,
                               @RequestParam boolean correct){
        Test test = testRepository.findById(id).get();
        test.addQuestion(new Question(content, correct));
        testRepository.save(test);
        return "redirect:/tests/"+id+"/add";
    }

    @GetMapping("/tests/{idq}/delete")
    public String deleteQuestion(@PathVariable int idq){
        questionRepository.deleteById(idq);
        return "redirect:/tests/"+id+"/add";
    }

}
