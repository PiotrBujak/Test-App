package akademiakodu.quiz.controller;

import akademiakodu.quiz.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Scope(value = "session")
@Controller
public class TestController {
    private User user = new User();

    @ResponseBody
    @GetMapping("/tests/{id}/play")
    public String play(@PathVariable Integer id){
        user.addPoint();
        return ""+user.getNumberOfPoints();
    }
}
