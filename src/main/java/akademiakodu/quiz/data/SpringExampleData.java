package akademiakodu.quiz.data;

import akademiakodu.quiz.model.Question;
import akademiakodu.quiz.model.Test;
import akademiakodu.quiz.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringExampleData implements CommandLineRunner {

    @Autowired
    private TestRepository testRepository;

    @Override
    public void run(String... strings) throws Exception {
        Test test = new Test("Test wiedzy z javy");
        Test test1 = new Test("Test wiedzy o zwierzątkach");
        Test test2 = new Test("Gra w pomidora");

        test.addQuestion(new Question("Czy java ma Klasy?",true));
        test.addQuestion(new Question("Czy java ma Interfejsy?",true));
        test.addQuestion(new Question("Czy java ma klasę integer?",false));
        test.addQuestion(new Question("Czy java ma klasę buldożer?",false));

        test1.addQuestion(new Question("Czy Kot ma ogon?",true));
        test1.addQuestion(new Question("Czy Pies jest najlepszym przyjacielem człowieka?",true));
        test1.addQuestion(new Question("Czy Złota rybka jest złota?",true));
        test1.addQuestion(new Question("Czy foki mają uszy?",true));

        test2.addQuestion(new Question("Pomidor",true));
        test2.addQuestion(new Question("Pomidor",true));
        test2.addQuestion(new Question("Pomidor",false));
        test2.addQuestion(new Question("Pomidor",false));

        testRepository.save(test);
        testRepository.save(test1);
        testRepository.save(test2);
    }
}
