package akademiakodu.quiz.data;

import akademiakodu.quiz.model.Question;
import akademiakodu.quiz.model.Test;
import akademiakodu.quiz.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringExampleData implements CommandLineRunner {

    @Autowired
    private TestRepository testRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Hello");

        Test test = new Test("Test wiedzy z javy");
        test.addQuestion(new Question("Czy java ma Klasy?",true));
        test.addQuestion(new Question("Czy java ma Interfejsy?",true));
        test.addQuestion(new Question("Czy java ma klasę integer?",false));
        test.addQuestion(new Question("Czy java ma klasę buldożer?",false));

        testRepository.save(test);
    }
}
